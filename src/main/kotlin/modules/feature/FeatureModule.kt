package modules.feature

import config.Config
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import module
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.koin

val featureModule = module {

    koin {
        modules(featureDI())
    }

    routing {
        val config by inject<Config>()
        val service by inject<FeatureService>()

        get("/") {
            call.respondText {
                service.foo()
                config.someString
            }
        }
    }
}