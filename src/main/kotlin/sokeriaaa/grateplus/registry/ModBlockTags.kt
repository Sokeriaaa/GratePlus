package sokeriaaa.grateplus.registry

import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block
import sokeriaaa.grateplus.GratePlus

object ModBlockTags {
    val GRATES: TagKey<Block> = TagKey.create(
        Registries.BLOCK,
        GratePlus.id("grates"),
    )
}