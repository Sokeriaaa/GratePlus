package sokeriaaa.grateplus.platform

import sokeriaaa.grateplus.platform.registry.PlatformRegistry
import java.util.*

object Platform {
    @PublishedApi
    internal val registry: PlatformRegistry by lazy {
        ServiceLoader.load(PlatformRegistry::class.java).first()
    }
}