package com.avs.moviefinder.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.avs.moviefinder.ui.find_detail.FindDetailViewModel
import com.avs.moviefinder.ui.home.HomeViewModel
import com.avs.moviefinder.ui.main.MainViewModel
import com.avs.moviefinder.ui.watch_later.WatchLaterViewModel
import com.avs.moviefinder.ui.watched.WatchedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WatchLaterViewModel::class)
    internal abstract fun watchLaterViewModel(watchLaterViewModel: WatchLaterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WatchedViewModel::class)
    internal abstract fun watchedViewModel(watchedViewModel: WatchLaterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FindDetailViewModel::class)
    internal abstract fun findDetailViewModel(findDetailViewModel: FindDetailViewModel): ViewModel
}