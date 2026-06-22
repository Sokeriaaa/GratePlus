package sokeriaaa.grateplus.platform.neoforge.datagen

import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.GratePlusModels
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.lang.GratePlusLanguageENUS
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.lang.GratePlusLanguageZHCN
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.server.GratePlusBlockTags
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.server.GratePlusItemTags
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.server.GratePlusLootTables
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.server.GratePlusRecipes

@EventBusSubscriber
object GratePlusDatagen {
    @SubscribeEvent
    @JvmStatic
    fun gatherDataClient(event: GatherDataEvent.Client) {
        val generator = event.generator
        val lookupProvider = event.lookupProvider
        val output = generator.packOutput
        generator.apply {
            // Client
            addProvider(true, GratePlusModels(output))
            addProvider(true, GratePlusLanguageENUS(output))
            addProvider(true, GratePlusLanguageZHCN(output))
            // Server
            addProvider(true, GratePlusLootTables(output, lookupProvider))
            addProvider(true, GratePlusRecipes.Runner(output, lookupProvider))
            val blockTags = GratePlusBlockTags(output, lookupProvider)
            addProvider(true, blockTags)
            addProvider(true, GratePlusItemTags(output, lookupProvider, blockTags.contentsGetter()))
        }
    }
}