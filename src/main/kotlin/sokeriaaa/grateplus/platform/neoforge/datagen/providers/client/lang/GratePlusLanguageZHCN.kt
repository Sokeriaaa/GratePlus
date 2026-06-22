package sokeriaaa.grateplus.platform.neoforge.datagen.providers.client.lang

import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.registry.ModBlocks

class GratePlusLanguageZHCN(
    output: PackOutput,
) : LanguageProvider(
    output,
    GratePlus.MOD_ID,
    "zh_cn",
) {
    override fun addTranslations() {
        addBlock({ ModBlocks.AMETHYST_GRATE.value }, "紫水晶格栅")
        addBlock({ ModBlocks.DIAMOND_GRATE.value }, "钻石格栅")
        addBlock({ ModBlocks.EMERALD_GRATE.value }, "绿宝石格栅")
        addBlock({ ModBlocks.GOLD_GRATE.value }, "金格栅")
        addBlock({ ModBlocks.IRON_GRATE.value }, "铁格栅")
        addBlock({ ModBlocks.LAPIS_GRATE.value }, "青金石格栅")
        addBlock({ ModBlocks.NETHERITE_GRATE.value }, "下界合金格栅")
        addBlock({ ModBlocks.REDSTONE_GRATE.value }, "红石格栅")

        addItem({ ModBlocks.AMETHYST_GRATE.value.asItem() }, "紫水晶格栅")
        addItem({ ModBlocks.DIAMOND_GRATE.value.asItem() }, "钻石格栅")
        addItem({ ModBlocks.EMERALD_GRATE.value.asItem() }, "绿宝石格栅")
        addItem({ ModBlocks.GOLD_GRATE.value.asItem() }, "金格栅")
        addItem({ ModBlocks.IRON_GRATE.value.asItem() }, "铁格栅")
        addItem({ ModBlocks.LAPIS_GRATE.value.asItem() }, "青金石格栅")
        addItem({ ModBlocks.NETHERITE_GRATE.value.asItem() }, "下界合金格栅")
        addItem({ ModBlocks.REDSTONE_GRATE.value.asItem() }, "红石格栅")
    }
}