package io.vbytsyuk.example.log

import io.vbytsyuk.example.core.Logger
import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.di.DiModule
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.core.domain.Location
import org.koin.core.module.Module
import org.koin.dsl.module

class LogDiModule(dependencies: Dependencies) :
    DiModule<LogDiModule.Dependencies, LogDiModule.Api>(dependencies) {

    interface Dependencies : DiModule.Dependencies

    interface Api : DiModule.Api {
        val logger: Logger
    }

    override val api: Api = object : Api {
        override val logger: Logger
            get() = AndroidLogger()
    }

    companion object {
        val koinModule: Module = module {
            single { LogDiModule(dependencies = object : Dependencies { }) }
            factory { get<LogDiModule>().api.logger }
        }
    }
}
