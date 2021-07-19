package io.vbytsyuk.example.episodes

import io.vbytsyuk.example.core.di.DiModule
import io.vbytsyuk.example.core.repository.domain.EpisodesRepository
import io.vbytsyuk.example.episodes.list.EpisodesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class EpisodesDiModule(dependencies: Dependencies) :
    DiModule<EpisodesDiModule.Dependencies, EpisodesDiModule.Api>(dependencies) {

    interface Dependencies : DiModule.Dependencies {
        val charactersRepository: EpisodesRepository
    }

    interface Api : DiModule.Api {
        val episodesListViewModel: EpisodesListViewModel
    }

    override val api: Api = object : Api {
        override val episodesListViewModel: EpisodesListViewModel
            get() = EpisodesListViewModel(dependencies.charactersRepository)
    }

    companion object {
        val koinModule: Module = module {
            single {
                EpisodesDiModule(
                    dependencies = object : Dependencies {
                        override val charactersRepository: EpisodesRepository = get()
                    }
                )
            }
            viewModel { get<EpisodesDiModule>().api.episodesListViewModel }
        }
    }
}
