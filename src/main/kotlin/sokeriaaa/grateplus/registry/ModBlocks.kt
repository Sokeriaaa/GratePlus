package sokeriaaa.grateplus.registry

import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.WaterloggedTransparentBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import sokeriaaa.grateplus.platform.Platform
import sokeriaaa.grateplus.platform.registry.RegistryObject

object ModBlocks {

    val AMETHYST_GRATE = block("amethyst_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).asGrate()
        )
    }

    val DIAMOND_GRATE = block("diamond_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).asGrate()
        )
    }

    val EMERALD_GRATE = block("emerald_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK).asGrate()
        )
    }

    val GOLD_GRATE = block("gold_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).asGrate()
        )
    }

    val IRON_GRATE = block("iron_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).asGrate()
        )
    }

    val LAPIS_GRATE = block("lapis_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).asGrate()
        )
    }

    val NETHERITE_GRATE = block("netherite_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).asGrate()
        )
    }

    val REDSTONE_GRATE = block("redstone_grate") {
        WaterloggedTransparentBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK).asGrate()
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

    private fun BlockBehaviour.Properties.asGrate(): BlockBehaviour.Properties =
        this.sound(SoundType.COPPER_GRATE)
            .noOcclusion()
            .requiresCorrectToolForDrops()
            .isValidSpawn { _, _, _, _ -> false }
            .isRedstoneConductor { _, _, _ -> false }
            .isSuffocating { _, _, _ -> false }
            .isViewBlocking { _, _, _ -> false }

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