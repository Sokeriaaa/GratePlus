package sokeriaaa.grateplus.platform.neoforge.datagen

import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.data.event.GatherDataEvent
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.GratePlusBlockStates
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.GratePlusItemModels
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
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val lookupProvider = event.lookupProvider
        val output = generator.packOutput
        val helper: ExistingFileHelper? = event.existingFileHelper
        generator.apply {
            if (event.includeServer()) {
                addProvider(true, GratePlusLootTables(output, lookupProvider))
                addProvider(true, GratePlusRecipes(output, lookupProvider))
                val blockTags = GratePlusBlockTags(output, lookupProvider, helper)
                addProvider(true, blockTags)
                addProvider(true, GratePlusItemTags(output, lookupProvider, blockTags.contentsGetter(), helper))
            }
            if (event.includeClient()) {
                addProvider(true, GratePlusBlockStates(output, helper))
                addProvider(true, GratePlusItemModels(output, helper))
                addProvider(true, GratePlusLanguageENUS(output))
                addProvider(true, GratePlusLanguageZHCN(output))
            }
        }
    }
}