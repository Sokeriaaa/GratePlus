package sokeriaaa.grateplus.platform.neoforge

import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.platform.Platform
import sokeriaaa.grateplus.platform.neoforge.impl.PlatformRegistryNeoForge

@EventBusSubscriber(modid = GratePlus.MOD_ID)
object GratePlusNeoForgeEventbus {

    @SubscribeEvent
    @JvmStatic
    fun onBuildCreativeModeTabContentsEvent(event: BuildCreativeModeTabContentsEvent) {
        (Platform.registry as PlatformRegistryNeoForge).registerItemsToVanillaTabs(event)
    }
}