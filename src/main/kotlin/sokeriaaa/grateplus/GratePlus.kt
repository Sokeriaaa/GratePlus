package sokeriaaa.grateplus

import net.minecraft.resources.ResourceLocation
import sokeriaaa.grateplus.registry.ModBlocks

object GratePlus {
    const val MOD_ID: String = "grate_plus"

    @JvmStatic
    fun init() {
        ModBlocks.register()
    }

    fun id(path: String): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(MOD_ID, path)
}