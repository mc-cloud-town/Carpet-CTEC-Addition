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

import carpet.CarpetExtension;
import carpet.CarpetServer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.system.CallbackI;

public class CarpetCTECAddition implements CarpetExtension, ModInitializer {
    final static String MOD_NAME = "Carpet CTEC Addition";
    final static String ID = "carpet-ctec-addition";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    public static String name, version;



    public static String getName() {
        return name;
    }

    public static String getVersion() {
        return version;
    }

    @Override
    public void onInitialize() {
        final ModMetadata metadata = FabricLoader.getInstance().getModContainer(ID).orElseThrow(IllegalStateException::new).getMetadata();
        name = metadata.getName();
        version = metadata.getVersion().getFriendlyString();
        CarpetServer.manageExtension(new CarpetCTECAddition());
    }

    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(CarpetCTECAdditionSettings.class);
    }

}
