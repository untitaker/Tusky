/* Copyright 2022 Tusky Contributors
 *
 * This file is a part of Tusky.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * Tusky is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Tusky; if not,
 * see <http://www.gnu.org/licenses>. */

@file:JvmName("StatusParsingHelper")

package com.keylesspalace.tusky.util

import android.text.Html.TagHandler
import android.text.Spanned
import androidx.core.text.parseAsHtml

/**
 * parse a String containing html from the Mastodon api to Spanned
 */
@JvmOverloads
fun String.parseAsMastodonHtml(tagHandler: TagHandler? = null): Spanned {
    return this.replace("<br> ", "<br>&nbsp;")
        .replace("<br /> ", "<br />&nbsp;")
        .replace("<br/> ", "<br/>&nbsp;")
        .replace("  ", "&nbsp;&nbsp;")
        .parseAsHtml(tagHandler = tagHandler)
        /* Html.fromHtml returns trailing whitespace if the html ends in a </p> tag, which
         * most status contents do, so it should be trimmed. */
        .trimTrailingWhitespace()
}
