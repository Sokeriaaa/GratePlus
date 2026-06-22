package sokeriaaa.grateplus.platform.neoforge.datagen.providers.server

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.tags.ItemTags
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.registry.ModBlocks
import sokeriaaa.grateplus.registry.ModItemTags
import java.util.concurrent.CompletableFuture

class GratePlusItemTags(
    output: PackOutput,
    provider: CompletableFuture<HolderLookup.Provider>,
    blockTags: CompletableFuture<TagLookup<Block>>,
) : ItemTagsProvider(
    output,
    provider,
    blockTags,
    GratePlus.MOD_ID,
) {
    override fun addTags(provider: HolderLookup.Provider) {
        // Misc
        tag(ItemTags.PIGLIN_LOVED).add(ModBlocks.GOLD_GRATE.value.asItem())
        // Mod
        tag(ModItemTags.GRATES).apply {
            ModBlocks.grateList.forEach { add(it.asItem()) }
            add(Blocks.COPPER_GRATE.asItem())
            add(Blocks.EXPOSED_COPPER_GRATE.asItem())
            add(Blocks.WEATHERED_COPPER_GRATE.asItem())
            add(Blocks.OXIDIZED_COPPER_GRATE.asItem())
            add(Blocks.WAXED_COPPER_GRATE.asItem())
            add(Blocks.WAXED_EXPOSED_COPPER_GRATE.asItem())
            add(Blocks.WAXED_WEATHERED_COPPER_GRATE.asItem())
            add(Blocks.WAXED_OXIDIZED_COPPER_GRATE.asItem())
        }
    }
}