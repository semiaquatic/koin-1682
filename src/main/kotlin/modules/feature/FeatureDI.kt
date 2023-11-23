package modules.feature

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun featureDI() = module {
    // DI definitions specific to feature module

    singleOf(::FeatureService)
}