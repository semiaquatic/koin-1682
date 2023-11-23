package modules.application

import config.Config
import io.ktor.server.application.*
import module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun applicationModule(config: Config) = module {

    install(Koin) {
        slf4jLogger()
        modules(applicationDI(config)) // pass config instance to koin module
    }

    // other stuff here like serialization setup, DB access setup, authentication setup, etc.
}