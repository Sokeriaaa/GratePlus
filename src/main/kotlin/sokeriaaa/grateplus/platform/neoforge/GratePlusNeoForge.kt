package sokeriaaa.grateplus.platform.neoforge

import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import sokeriaaa.grateplus.GratePlus

@Mod(GratePlus.MOD_ID)
class GratePlusNeoForge(modEventBus: IEventBus, modContainer: ModContainer) {

    init {
        // Run our common setup.
        GratePlus.init()
    }
}