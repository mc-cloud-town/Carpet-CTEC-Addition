/*
 * This file is part of the Carpet CTEC Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2026  CTEC and contributors
 *
 * Carpet CTEC Addition is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Carpet CTEC Addition is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Carpet CTEC Addition.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.ctec.CarpetCTECAddition;

import carpet.settings.Rule;

public class CarpetCTECAdditionSettings {
    public static final String CTEC = "CTEC";
    public static final String CREATIVE = "creative";
    public static final String EXTRAS = "extras";
//    @Rule(
//        desc = "Test rule for Carpet CTEC Addition",
//        category = {CTEC},
//        options = {"true", "false"}
//    )
//    public static String testRule = "false";
    @Rule(
        desc = "Note blocks no longer change notes when right-clicked on",
        category = {CTEC, EXTRAS, CREATIVE},
        options = {"true", "false"}
    )
    public static String staticNoteBlock = "false";

}
