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
 *  General coded information pertaining to the specific reading.
    Typically it will be used to indicate some unusual aspect of
    the reading.
 */
@Xml(name = "re_inf")
open class ReadingInfo {

    @TextContent
    lateinit var value: String

    val info get() = Info.get(value)

}