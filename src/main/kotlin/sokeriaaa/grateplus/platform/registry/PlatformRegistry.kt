package sokeriaaa.grateplus.platform.registry

import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

interface PlatformRegistry {
    fun <B : Block> registerBlockAndItem(
        registryObject: RegistryObject<B>,
        creativeModeTab: ResourceKey<CreativeModeTab>? = null,
        itemProperties: Item.Properties = Item.Properties(),
    )
}