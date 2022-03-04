package fr.com.tn.majdi.livenews

import androidx.multidex.MultiDexApplication
import com.majdi.livenews.data.local.di.DataLocalModules
import com.majdi.livenews.data.remote.di.DataRemoteModules
import com.majdi.livenews.data.remote.di.NetworkModule
import com.majdi.livenews.domain.di.DomainModules
import fr.com.tn.majdi.livenews.di.PresentationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import timber.log.Timber


/**
 * Created by Majdi RABEH on 27/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
class AppLiveNews : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.tag("LiveData")
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@AppLiveNews)
            androidLogger(Level.ERROR)
            modules(
                listOf(
                    NetworkModule,
                    DataRemoteModules,
                    DataLocalModules,
                    DomainModules,
                    PresentationModules
                )
            )
        }
    }

}