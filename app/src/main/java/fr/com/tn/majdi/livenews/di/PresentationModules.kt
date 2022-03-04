package fr.com.tn.majdi.livenews.di

import com.majdi.livenews.domain.usecases.InsertNewsUseCase
import fr.com.tn.majdi.livenews.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.get
import org.koin.dsl.module

/**
 * Created by Majdi RABEH on 27/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
val PresentationModules = module {
    viewModel {
        MainViewModel(
            get(named("GetAllRemoteNewsUseCase")),
            get(named("GetAllLocalNewsUseCase")),
            get(named("InsertNewsUseCase")),
            get(named("DeleteAllNewsUseCase"))
        )
    }
}