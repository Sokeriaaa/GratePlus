package sokeriaaa.grateplus.registry

import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import sokeriaaa.grateplus.GratePlus

object ModItemTags {
    val GRATES: TagKey<Item> = TagKey.create(
        Registries.ITEM,
        GratePlus.id("grates"),
    )
}