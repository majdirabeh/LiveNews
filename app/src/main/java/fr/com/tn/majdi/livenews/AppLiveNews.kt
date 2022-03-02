package fr.com.tn.majdi.livenews

import androidx.multidex.MultiDexApplication
import com.majdi.livenews.data.local.di.DataLocalModules
import com.majdi.livenews.data.remote.di.DataRemoteModules
import com.majdi.livenews.data.remote.di.NetworkModule
import com.majdi.livenews.domain.di.DomainModules
import fr.com.tn.majdi.livenews.di.PresentationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


/**
 * Created by Majdi RABEH on 27/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
class AppLiveNews : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@AppLiveNews)
            modules(
                listOf(
                    DomainModules,
                    NetworkModule,
                    DataRemoteModules,
                    DataLocalModules,
                    PresentationModules
                )
            )
        }
    }

}