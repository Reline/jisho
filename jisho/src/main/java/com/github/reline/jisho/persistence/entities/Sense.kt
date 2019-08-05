/*
 * Copyright 2017 Nathaniel Reline
 *
 * This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or
 * send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.github.reline.jisho.persistence.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 *  The sense element will record the translational equivalent
    of the Japanese word, plus other related information. Where there
    are several distinctly different meanings of the word, multiple
    sense elements will be employed.
 */
@Entity
data class Sense @JvmOverloads constructor(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        @Ignore
        val kanjiTags: List<KanjiTag> = emptyList(),
        @Ignore
        val readingTags: List<ReadingTag> = emptyList(),
        @Ignore
        val partsOfSpeech: List<PartOfSpeech> = emptyList(),
        @Ignore
        val seeAlso: List<XReference> = emptyList(),
        @Ignore
        val antonyms: List<Antonym> = emptyList(),
        @Ignore
        val fields: List<Field> = emptyList(),
        @Ignore
        val miscellaneous: List<Misc> = emptyList(),
        @Ignore
        val information: List<SenseInfo> = emptyList(),
        @Ignore
        val sources: List<Source> = emptyList(),
        @Ignore
        val dialects: List<Dialect> = emptyList(),
        @Ignore
        val glosses: List<Gloss> = emptyList()
)