package sokeriaaa.grateplus

import net.minecraft.resources.ResourceLocation

object GratePlus {
    const val MOD_ID: String = "grate_plus"

    @JvmStatic
    fun init() {

    }

    fun id(path: String): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(MOD_ID, path)
}