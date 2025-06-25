package org.k4n3d4.BarrierESP;

import net.minecraft.client.Minecraft;
import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;

public class BarrierESPModule  extends ToggleableModule{
    public static boolean IsEnable = false;

    public BarrierESPModule() {
        super("Barrier ESP", "Displays barrier blocks at all times", ModuleCategory.CLIENT);
    }

    @Override
    public void onEnable() {
        IsEnable = true;
    }

    @Override
    public void onDisable() {
        IsEnable = false;
    }
}
