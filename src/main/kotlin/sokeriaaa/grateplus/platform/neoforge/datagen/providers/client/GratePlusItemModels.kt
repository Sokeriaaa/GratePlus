package sokeriaaa.grateplus.platform.neoforge.datagen.providers.client

import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.registry.ModBlocks

class GratePlusItemModels(
    output: PackOutput,
    existingFileHelper: ExistingFileHelper?,
) : ItemModelProvider(
    output,
    GratePlus.MOD_ID,
    existingFileHelper,
) {
    override fun registerModels() {
        ModBlocks.grateList.forEach(::simpleBlockItem)
    }
}