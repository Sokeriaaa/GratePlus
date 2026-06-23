package sokeriaaa.grateplus.platform.neoforge.datagen.providers.client

import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.ModelProvider
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.client.data.models.model.TextureMapping
import net.minecraft.client.data.models.model.TexturedModel
import net.minecraft.data.PackOutput
import net.minecraft.resources.Identifier
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.registry.ModBlocks

class GratePlusModels(
    output: PackOutput,
) : ModelProvider(
    output,
    GratePlus.MOD_ID,
) {
    val cutoutCubeTemplate: ExtendedModelTemplate = ExtendedModelTemplateBuilder.of(ModelTemplates.CUBE_ALL)
        .renderType(Identifier.withDefaultNamespace("cutout"))
        .build()

    override fun registerModels(
        blockModelGenerators: BlockModelGenerators,
        itemModelGenerators: ItemModelGenerators
    ) {
        ModBlocks.grateList.forEach { block ->
            blockModelGenerators.createTrivialBlock(block) {
                TexturedModel(
                    TextureMapping.cube(it),
                    cutoutCubeTemplate,
                )
            }
        }
    }
}