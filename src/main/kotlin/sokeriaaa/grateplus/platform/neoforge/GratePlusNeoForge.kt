package sokeriaaa.grateplus.platform.neoforge

import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.platform.Platform
import sokeriaaa.grateplus.platform.neoforge.impl.PlatformRegistryNeoForge

@Mod(GratePlus.MOD_ID)
class GratePlusNeoForge(modEventBus: IEventBus, modContainer: ModContainer) {

    init {
        // Run our common setup.
        GratePlus.init()
        // Register the Deferred Register to the mod event bus so objects get registered
        (Platform.registry as PlatformRegistryNeoForge).registerAllDeferredTo(modEventBus)
    }
}