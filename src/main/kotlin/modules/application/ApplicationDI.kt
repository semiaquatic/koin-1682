package modules.application

import config.Config
import org.koin.dsl.module

fun applicationDI(config: Config) = module {
    // app-wide DI definitions

    single { config } // register config as singleton
}
