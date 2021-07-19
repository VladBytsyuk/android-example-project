package io.vbytsyuk.example.locations

import io.vbytsyuk.example.core.di.DiModule
import io.vbytsyuk.example.core.repository.domain.LocationsRepository
import io.vbytsyuk.example.locations.list.LocationsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class LocationsDiModule(dependencies: Dependencies) :
    DiModule<LocationsDiModule.Dependencies, LocationsDiModule.Api>(dependencies) {

    interface Dependencies : DiModule.Dependencies {
        val locationsRepository: LocationsRepository
    }

    interface Api : DiModule.Api {
        val locationsListViewModel: LocationsListViewModel
    }

    override val api: Api = object : Api {
        override val locationsListViewModel: LocationsListViewModel
            get() = LocationsListViewModel(dependencies.locationsRepository)
    }

    companion object {
        val koinModule: Module = module {
            single {
                LocationsDiModule(
                    dependencies = object : Dependencies {
                        override val locationsRepository: LocationsRepository = get()
                    }
                )
            }
            viewModel { get<LocationsDiModule>().api.locationsListViewModel }
        }
    }
}
