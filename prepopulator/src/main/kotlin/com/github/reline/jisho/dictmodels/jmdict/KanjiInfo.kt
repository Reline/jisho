/*
 * Copyright 2020 Nathaniel Reline
 *
 * This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or
 * send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.github.reline.jisho.dictmodels.jmdict

import com.tickaroo.tikxml.annotation.TextContent
import com.tickaroo.tikxml.annotation.Xml

/**
 * This is a coded information field related specifically to the
 * orthography of the keb, and will typically indicate some unusual
 * aspect, such as okurigana irregularity.
 */
@Xml(name = "ke_inf")
open class KanjiInfo {

    @TextContent
    lateinit var value: String

    fun getInfo() = Info.get(value)
}