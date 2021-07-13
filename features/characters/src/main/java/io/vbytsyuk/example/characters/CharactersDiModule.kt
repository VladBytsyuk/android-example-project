package io.vbytsyuk.example.characters

import io.vbytsyuk.example.core.di.DiModule
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.repository.Repository
import io.vbytsyuk.example.core.repository.domain.CharactersRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class CharactersDiModule(dependencies: Dependencies) :
    DiModule<CharactersDiModule.Dependencies, CharactersDiModule.Api>(dependencies) {

    interface Dependencies : DiModule.Dependencies {
        val charactersRepository: CharactersRepository
    }

    interface Api : DiModule.Api {
        val charactersListViewModel: CharactersListViewModel
    }

    override val api: Api = object : Api {
        override val charactersListViewModel: CharactersListViewModel =
            CharactersListViewModel(repository = dependencies.charactersRepository)
    }

    companion object {
        val koinModule: Module = module {
            single {
                CharactersDiModule(
                    dependencies = object : Dependencies {
                        override val charactersRepository: CharactersRepository = get()
                    }
                )
            }
            viewModel { get<CharactersDiModule>().api.charactersListViewModel }
        }
    }
}
