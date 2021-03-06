/*
 * Copyright 2020 Nathaniel Reline
 *
 * This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or
 * send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.github.reline.jisho

import com.github.reline.jisho.dictmodels.Radical
import java.io.File

fun main() = RadicalPopulator.run()

object RadicalPopulator {
    fun run() {
        println("Extracting radicals...")
        extractRadKFiles(arrayOf(
                File("$buildDir/dict/radkfile"),
                File("$buildDir/dict/radkfile2"),
                File("$buildDir/dict/radkfilex")
        ))

        extractKRadFiles(arrayOf(
                File("$buildDir/dict/kradfile"),
                File("$buildDir/dict/kradfile2")
        ))
    }

    private fun extractRadKFiles(files: Array<File>) {
        val radkparser = RadKParser()
        files.forEach {
            val parseStart = System.currentTimeMillis()
            val radicals = radkparser.parse(it)
            val parseEnd = System.currentTimeMillis()
            println("${it.name}: Parsing took ${(parseEnd - parseStart)}ms")

            val insertStart = System.currentTimeMillis()
            insertRadk(radicals)
            val insertEnd = System.currentTimeMillis()
            println("${it.name}: Inserting took ${(insertEnd - insertStart)}ms")
        }
    }

    private fun insertRadk(radicals: List<Radical>) = with(database) {
        transaction(noEnclosing = true) {
            radicals.forEach { radical ->
//            kanjiRadicalQueries.insertRadical(radical.value.toString(), radical.strokes.toLong())
//            val radicalId = kanjiRadicalQueries.radicalId(radical.value.toString()).executeAsOne()
                radical.kanji.forEach { kanji ->
//                kanjiRadicalQueries.insertKanji(kanji.toString())
//                val kanjiId = kanjiRadicalQueries.kanjiId(kanji.toString()).executeAsOne()
//                kanjiRadicalQueries.insertKanjiRadicalTag(kanjiId, radicalId)
                }
            }
        }
    }

    fun extractKRadFiles(files: Array<File>) {
        val kradparser = KRadParser()
        files.forEach {
            val parseStart = System.currentTimeMillis()
            val krad = kradparser.parse(it)
            val parseEnd = System.currentTimeMillis()
            println("${it.name}: Parsing took ${(parseEnd - parseStart)}ms")

            val insertStart = System.currentTimeMillis()
            insertKrad(krad)
            val insertEnd = System.currentTimeMillis()
            println("${it.name}: Inserting took ${(insertEnd - insertStart)}ms")
        }
    }

    fun insertKrad(krad: Map<Char, List<Char>>) = with(database) {
        transaction(noEnclosing = true) {
            krad.forEach { (kanji, radicals) ->
//            kanjiRadicalQueries.insertKanji(kanji.toString())
//            val kanjiId = kanjiRadicalQueries.kanjiId(kanji.toString()).executeAsOne()
                radicals.forEach { radical ->
                    try {
//                    val radicalId = kanjiRadicalQueries.radicalId(radical.toString()).executeAsOne()
//                    kanjiRadicalQueries.insertKanjiRadicalTag(kanjiId, radicalId)
                    } catch (e: NullPointerException) {
                        // note: 悒 contains the radical 邑 which isn't in the radfile
                        // but 悒 explicitly consists of 口 and 巴 which make up 邑

                        // omit any failures for now
                        println("$radical couldn't be found, used in $kanji")
                    }
                }
            }
        }
    }
}