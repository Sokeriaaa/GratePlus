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
        simpleBlockItem(ModBlocks.AMETHYST_GRATE.value)
        simpleBlockItem(ModBlocks.DIAMOND_GRATE.value)
        simpleBlockItem(ModBlocks.EMERALD_GRATE.value)
        simpleBlockItem(ModBlocks.GOLD_GRATE.value)
        simpleBlockItem(ModBlocks.IRON_GRATE.value)
        simpleBlockItem(ModBlocks.LAPIS_GRATE.value)
        simpleBlockItem(ModBlocks.NETHERITE_GRATE.value)
        simpleBlockItem(ModBlocks.REDSTONE_GRATE.value)
    }
}