package sokeriaaa.grateplus.platform.neoforge.datagen.providers.server

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import sokeriaaa.grateplus.registry.ModBlocks
import java.util.concurrent.CompletableFuture

class GratePlusLootTables(
    output: PackOutput,
    registries: CompletableFuture<HolderLookup.Provider>
) : LootTableProvider(
    output,
    emptySet(),
    listOf(
        SubProviderEntry({ Blocks(it) }, LootContextParamSets.BLOCK),
    ),
    registries,
) {
    private class Blocks(
        registries: HolderLookup.Provider,
    ) : BlockLootSubProvider(
        emptySet(),
        FeatureFlags.REGISTRY.allFlags(),
        registries,
    ) {
        override fun generate() {
            ModBlocks.grateList.forEach(::dropSelf)
        }

        override fun getKnownBlocks(): Iterable<Block> = ModBlocks.grateList
    }
}