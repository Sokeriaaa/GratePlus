package sokeriaaa.grateplus.platform.neoforge.impl

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.registries.DeferredRegister
import sokeriaaa.grateplus.GratePlus
import sokeriaaa.grateplus.platform.registry.PlatformRegistry
import sokeriaaa.grateplus.platform.registry.RegistryObject
import java.util.function.Supplier

class PlatformRegistryNeoForge : PlatformRegistry {

    // Create a Deferred Register to hold Items which will all be registered under the initialized namespace
    private val _items: DeferredRegister.Items =
        DeferredRegister.createItems(GratePlus.MOD_ID)

    // Create a Deferred Register to hold Blocks which will all be registered under the initialized namespace
    private val _blocks: DeferredRegister.Blocks =
        DeferredRegister.createBlocks(GratePlus.MOD_ID)

    // Create a map to add items into vanilla creative mod tabs.
    private val _itemTabMapping: MutableMap<ResourceKey<CreativeModeTab>, MutableList<Item>> = HashMap()

    override fun <B : Block> registerBlockAndItem(
        registryObject: RegistryObject<B>,
        creativeModeTab: ResourceKey<CreativeModeTab>?,
        itemProperties: Item.Properties
    ) {
        _blocks.register(registryObject.path, Supplier { registryObject.value })
        _items.register(
            registryObject.path,
            Supplier {
                BlockItem(
                    registryObject.value,
                    itemProperties.setId(
                        ResourceKey.create(Registries.ITEM, GratePlus.id(registryObject.path))
                    ),
                ).also { item ->
                    // registerCreativeModeTab
                    creativeModeTab?.let { tab ->
                        if (!_itemTabMapping.containsKey(tab)) {
                            _itemTabMapping[tab] = ArrayList()
                        }
                        _itemTabMapping[tab]!!.add(item)
                    }
                }
            }
        )
    }

    // Register all deferred registers.
    fun registerAllDeferredTo(eventBus: IEventBus) {
        _items.register(eventBus)
        _blocks.register(eventBus)
    }

    // Register items to vanilla creative tabs.
    fun registerItemsToVanillaTabs(event: BuildCreativeModeTabContentsEvent) {
        _itemTabMapping[event.tabKey]?.forEach(event::accept)
    }
}