import config.Config
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import modules.application.applicationModule
import modules.feature.featureModule

fun main() {
    System.setProperty("io.ktor.development", "true") // activate hot-reload

    embeddedServer(Netty, applicationEngineEnvironment {
        val config = Config("foo") // global config instance loaded from external sources, application module should make it available for injection for all modules

        modules += applicationModule(config) // pass config instance to application module
        modules += featureModule

        watchPaths += arrayOf("classes", "resources") // paths for hot-reload

        connector {
            host = "localhost"
            port = 8080
        }
    }).start(wait = true)
}