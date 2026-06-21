package sokeriaaa.grateplus.platform.neoforge.datagen

import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.data.event.GatherDataEvent
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.GratePlusBlockStates
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.GratePlusItemModels
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.lang.GratePlusLanguageENUS
import sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.lang.GratePlusLanguageZHCN

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