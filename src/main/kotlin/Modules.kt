import io.ktor.server.application.*

typealias ApplicationModule = Application.() -> Unit

fun module(module: ApplicationModule) = module