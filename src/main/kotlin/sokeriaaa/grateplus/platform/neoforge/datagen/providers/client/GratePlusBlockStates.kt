package sokeriaaa.grateplus.platform.neoforge.datagen.providers.client

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.registry.ModBlocks

class GratePlusBlockStates(
    output: PackOutput,
    exFileHelper: ExistingFileHelper?,
) : BlockStateProvider(
    output,
    GratePlus.MOD_ID,
    exFileHelper,
) {
    override fun registerStatesAndModels() {
        simpleCutoutBlock(ModBlocks.AMETHYST_GRATE.value)
        simpleCutoutBlock(ModBlocks.DIAMOND_GRATE.value)
        simpleCutoutBlock(ModBlocks.EMERALD_GRATE.value)
        simpleCutoutBlock(ModBlocks.GOLD_GRATE.value)
        simpleCutoutBlock(ModBlocks.IRON_GRATE.value)
        simpleCutoutBlock(ModBlocks.LAPIS_GRATE.value)
        simpleCutoutBlock(ModBlocks.NETHERITE_GRATE.value)
        simpleCutoutBlock(ModBlocks.REDSTONE_GRATE.value)
    }

    fun simpleCutoutBlock(block: Block) {
        simpleBlock(
            block,
            this.models()
                .cubeAll(BuiltInRegistries.BLOCK.getKey(block).path, this.blockTexture(block))
                .renderType("minecraft:cutout"),
        )
    }
}