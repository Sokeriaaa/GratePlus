package sokeriaaa.grateplus.platform.neoforge.datagen.providers.server

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Blocks
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.registry.ModBlocks
import java.util.concurrent.CompletableFuture

class GratePlusRecipes(
    output: PackOutput,
    registries: CompletableFuture<HolderLookup.Provider>,
) : RecipeProvider(output, registries) {

    override fun buildRecipes(recipeOutput: RecipeOutput) {
        fun grate(key: String, input: ItemLike, output: ItemLike) {
            ShapedRecipeBuilder
                .shaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A', input)
                .unlockedBy("has_${key}_block", has(input))
                .save(recipeOutput, "${GratePlus.MOD_ID}:${key}_grate_from_crafting")
            SingleItemRecipeBuilder
                .stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output, 4)
                .unlockedBy("has_${key}_block", has(input))
                .save(recipeOutput, "${GratePlus.MOD_ID}:${key}_grate_from_stonecutting")
        }

        super.buildRecipes(recipeOutput)
        grate("amethyst", Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_GRATE.value)
        grate("diamond", Blocks.DIAMOND_BLOCK, ModBlocks.DIAMOND_GRATE.value)
        grate("emerald", Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_GRATE.value)
        grate("gold", Blocks.GOLD_BLOCK, ModBlocks.GOLD_GRATE.value)
        grate("iron", Blocks.IRON_BLOCK, ModBlocks.IRON_GRATE.value)
        grate("lapis", Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_GRATE.value)
        grate("netherite", Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_GRATE.value)
        grate("redstone", Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_GRATE.value)
    }
}