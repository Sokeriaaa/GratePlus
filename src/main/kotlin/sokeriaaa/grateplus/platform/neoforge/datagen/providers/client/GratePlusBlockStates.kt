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
        ModBlocks.grateList.forEach(::simpleCutoutBlock)
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