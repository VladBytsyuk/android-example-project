package io.vbytsyuk.example.android

import android.app.Application
import io.vbytsyuk.example.api.ApiDiModule
import io.vbytsyuk.example.characters.CharactersDiModule
import io.vbytsyuk.example.core.CoreDiModule
import io.vbytsyuk.example.database.DatabaseDiModule
import io.vbytsyuk.example.episodes.EpisodesDiModule
import io.vbytsyuk.example.locations.LocationsDiModule
import io.vbytsyuk.example.log.LogDiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                LogDiModule.koinModule,
                ApiDiModule.koinModule,
                DatabaseDiModule.koinModule,
                CoreDiModule.koinModule,
                LocationsDiModule.koinModule,
                CharactersDiModule.koinModule,
                EpisodesDiModule.koinModule,
            )
        }
    }
}
