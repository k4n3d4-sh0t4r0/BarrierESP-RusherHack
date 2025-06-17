package org.k4n3d4.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static org.k4n3d4.BarrierESPModule.IsEnable;

@Mixin(ClientLevel.class)
public class ClientLevelMixin {

    @Shadow @Final
    private Minecraft minecraft;

    @Inject(method = "getMarkerParticleTarget", at = @At("RETURN"), cancellable = true)
    private void onGetMarkerParticleTarget(CallbackInfoReturnable<Block> cir) {
        if (minecraft.gameMode.getPlayerMode() == GameType.CREATIVE
                && minecraft.player.getMainHandItem().getItem() == Items.LIGHT) {
            return;
        }

        if (IsEnable) {
            cir.setReturnValue(Blocks.BARRIER);
        }
    }
}
