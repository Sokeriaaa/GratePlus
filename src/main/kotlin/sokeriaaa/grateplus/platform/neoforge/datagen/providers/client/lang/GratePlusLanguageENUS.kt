package sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.lang

import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.registry.ModBlocks

class GratePlusLanguageENUS(
    output: PackOutput,
) : LanguageProvider(
    output,
    GratePlus.MOD_ID,
    "en_us",
) {
    override fun addTranslations() {
        addBlock({ ModBlocks.AMETHYST_GRATE.value }, "Amethyst Grate")
        addBlock({ ModBlocks.DIAMOND_GRATE.value }, "Diamond Grate")
        addBlock({ ModBlocks.EMERALD_GRATE.value }, "Emerald Grate")
        addBlock({ ModBlocks.GOLD_GRATE.value }, "Gold Grate")
        addBlock({ ModBlocks.IRON_GRATE.value }, "Iron Grate")
        addBlock({ ModBlocks.LAPIS_GRATE.value }, "Lapis Lazuli Grate")
        addBlock({ ModBlocks.NETHERITE_GRATE.value }, "Netherite Grate")
        addBlock({ ModBlocks.REDSTONE_GRATE.value }, "Redstone Grate")

        addItem({ ModBlocks.AMETHYST_GRATE.value.asItem() }, "Amethyst Grate")
        addItem({ ModBlocks.DIAMOND_GRATE.value.asItem() }, "Diamond Grate")
        addItem({ ModBlocks.EMERALD_GRATE.value.asItem() }, "Emerald Grate")
        addItem({ ModBlocks.GOLD_GRATE.value.asItem() }, "Gold Grate")
        addItem({ ModBlocks.IRON_GRATE.value.asItem() }, "Iron Grate")
        addItem({ ModBlocks.LAPIS_GRATE.value.asItem() }, "Lapis Lazuli Grate")
        addItem({ ModBlocks.NETHERITE_GRATE.value.asItem() }, "Netherite Grate")
        addItem({ ModBlocks.REDSTONE_GRATE.value.asItem() }, "Redstone Grate")
    }
}