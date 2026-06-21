package sokeriaaa.grateplus.registry

import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.WaterloggedTransparentBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import sokeriaaa.grateplus.platform.Platform
import sokeriaaa.grateplus.platform.registry.RegistryObject

object ModBlocks {

    val AMETHYST_GRATE = block("amethyst_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)
        )
    }

    val DIAMOND_GRATE = block("diamond_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)
        )
    }

    val EMERALD_GRATE = block("emerald_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)
        )
    }

    val GOLD_GRATE = block("gold_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)
        )
    }

    val IRON_GRATE = block("iron_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)
        )
    }

    val LAPIS_GRATE = block("lapis_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)
        )
    }

    val NETHERITE_GRATE = block("netherite_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)
        )
    }

    val REDSTONE_GRATE = block("redstone_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE)
        )
    }

    val grateList: List<Block>
        get() = listOf(
            AMETHYST_GRATE.value,
            DIAMOND_GRATE.value,
            EMERALD_GRATE.value,
            GOLD_GRATE.value,
            IRON_GRATE.value,
            LAPIS_GRATE.value,
            NETHERITE_GRATE.value,
            REDSTONE_GRATE.value,
        )

    fun register() {
        Platform.registry.apply {
            registerBlockAndItem(REDSTONE_GRATE, CreativeModeTabs.BUILDING_BLOCKS)
            registerBlockAndItem(GOLD_GRATE, CreativeModeTabs.BUILDING_BLOCKS)
            registerBlockAndItem(IRON_GRATE, CreativeModeTabs.BUILDING_BLOCKS)
            registerBlockAndItem(EMERALD_GRATE, CreativeModeTabs.BUILDING_BLOCKS)
            registerBlockAndItem(DIAMOND_GRATE, CreativeModeTabs.BUILDING_BLOCKS)
            registerBlockAndItem(LAPIS_GRATE, CreativeModeTabs.BUILDING_BLOCKS)
            registerBlockAndItem(NETHERITE_GRATE, CreativeModeTabs.BUILDING_BLOCKS)
            registerBlockAndItem(AMETHYST_GRATE, CreativeModeTabs.BUILDING_BLOCKS)
        }
    }

    private inline fun <reified T : Block> block(
        path: String,
        noinline supplier: () -> T,
    ) = RegistryObject(
        path = path,
        lazy = lazy(supplier),
    )
}