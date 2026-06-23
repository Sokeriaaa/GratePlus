package sokeriaaa.grateplus

import net.minecraft.resources.Identifier
import sokeriaaa.grateplus.registry.ModBlocks

object GratePlus {
    const val MOD_ID: String = "grate_plus"

    @JvmStatic
    fun init() {
        ModBlocks.register()
    }

    fun id(path: String): Identifier =
        Identifier.fromNamespaceAndPath(MOD_ID, path)
}