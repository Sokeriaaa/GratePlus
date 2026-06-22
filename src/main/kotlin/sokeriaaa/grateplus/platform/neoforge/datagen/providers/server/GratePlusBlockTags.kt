package sokeriaaa.grateplus.platform.neoforge.datagen.providers.server

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import net.neoforged.neoforge.common.data.BlockTagsProvider
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.registry.ModBlockTags
import sokeriaaa.grateplus.registry.ModBlocks
import java.util.concurrent.CompletableFuture

class GratePlusBlockTags(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
) : BlockTagsProvider(
    output,
    lookupProvider,
    GratePlus.MOD_ID,
) {
    override fun addTags(provider: HolderLookup.Provider) {
        // Mineable
        tag(BlockTags.MINEABLE_WITH_PICKAXE).apply {
            ModBlocks.grateList.forEach(::add)
        }
        // Required tool levels
        tag(BlockTags.NEEDS_STONE_TOOL)
            .add(ModBlocks.IRON_GRATE.value)
            .add(ModBlocks.LAPIS_GRATE.value)
        tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.GOLD_GRATE.value)
            .add(ModBlocks.EMERALD_GRATE.value)
            .add(ModBlocks.DIAMOND_GRATE.value)
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.NETHERITE_GRATE.value)
        // Misc
        tag(BlockTags.GUARDED_BY_PIGLINS)
            .add(ModBlocks.GOLD_GRATE.value)
        tag(BlockTags.CRYSTAL_SOUND_BLOCKS)
            .add(ModBlocks.AMETHYST_GRATE.value)
        // Mod
        tag(ModBlockTags.GRATES).apply {
            ModBlocks.grateList.forEach(::add)
            add(Blocks.COPPER_GRATE)
            add(Blocks.EXPOSED_COPPER_GRATE)
            add(Blocks.WEATHERED_COPPER_GRATE)
            add(Blocks.OXIDIZED_COPPER_GRATE)
            add(Blocks.WAXED_COPPER_GRATE)
            add(Blocks.WAXED_EXPOSED_COPPER_GRATE)
            add(Blocks.WAXED_WEATHERED_COPPER_GRATE)
            add(Blocks.WAXED_OXIDIZED_COPPER_GRATE)
        }
    }
}