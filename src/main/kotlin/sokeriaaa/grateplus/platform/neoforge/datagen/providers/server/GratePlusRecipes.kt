package sokeriaaa.grateplus.platform.neoforge.datagen.providers.server

import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Blocks
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.registry.ModBlocks
import java.util.concurrent.CompletableFuture

class GratePlusRecipes(
    registries: HolderLookup.Provider,
    output: RecipeOutput,
) : RecipeProvider(registries, output) {

    private val itemLookup: HolderLookup.RegistryLookup<Item> = this.registries.lookupOrThrow(Registries.ITEM)
    private val recipeOutput: RecipeOutput = this.output

    override fun buildRecipes() {

        fun grate(key: String, itemInput: ItemLike, itemOutput: ItemLike) {
            ShapedRecipeBuilder
                .shaped(itemLookup, RecipeCategory.BUILDING_BLOCKS, itemOutput, 4)
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A', itemInput)
                .unlockedBy("has_${key}_block", has(itemInput))
                .save(recipeOutput, "${GratePlus.MOD_ID}:${key}_grate_from_crafting")
            SingleItemRecipeBuilder
                .stonecutting(Ingredient.of(itemInput), RecipeCategory.BUILDING_BLOCKS, itemOutput, 4)
                .unlockedBy("has_${key}_block", has(itemInput))
                .save(recipeOutput, "${GratePlus.MOD_ID}:${key}_grate_from_stonecutting")
        }

        grate("amethyst", Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_GRATE.value)
        grate("diamond", Blocks.DIAMOND_BLOCK, ModBlocks.DIAMOND_GRATE.value)
        grate("emerald", Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_GRATE.value)
        grate("gold", Blocks.GOLD_BLOCK, ModBlocks.GOLD_GRATE.value)
        grate("iron", Blocks.IRON_BLOCK, ModBlocks.IRON_GRATE.value)
        grate("lapis", Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_GRATE.value)
        grate("netherite", Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_GRATE.value)
        grate("redstone", Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_GRATE.value)
    }

    class Runner(
        packOutput: PackOutput,
        registries: CompletableFuture<HolderLookup.Provider>,
    ) : RecipeProvider.Runner(packOutput, registries) {
        override fun createRecipeProvider(
            registries: HolderLookup.Provider,
            output: RecipeOutput,
        ): RecipeProvider = GratePlusRecipes(registries, output)

        override fun getName(): String = "Grate+ Recipes"
    }
}