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

package org.ctec.CarpetCTECAddition.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.NoteBlock;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.ctec.CarpetCTECAddition.CarpetCTECAdditionSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {

//    @Redirect(
//            method = "onUse",
//            at = @At(
//                    value = "INVOKE",
//                    target = "Lnet/minecraft/block/BlockState;cycle(Lnet/minecraft/state/property/Property;)Ljava/lang/Object;"
//            )
//    )
//    private Object modifyCycle(BlockState state, Property<?> property) {
//        // your custom logic here
//        if ("true".equals(CarpetCTECAdditionSettings.staticNoteBlock)) {
//            return state; // Return the original state without cycling
//        }
//        return state.cycle(property); // Proceed with the normal cycling behavior
//    }
    @Redirect(
            method = "onUse",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"
            )
    )
    private boolean redirectSetBlockState(World instance, BlockPos pos, BlockState state, int flags) {
        BlockState state2 = instance.getBlockState(pos);

        boolean ret =  instance.setBlockState(pos, state, flags);
        if ("true".equals(CarpetCTECAdditionSettings.staticNoteBlock) && state2.getBlock() instanceof NoteBlock) {
            WorldChunk chunk = instance.getWorldChunk(pos);
            chunk.setBlockState(pos, state2, false);
        }
        return ret;

    }
}
