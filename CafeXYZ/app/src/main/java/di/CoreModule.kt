package di

import com.orion.cafexyz.ViewModels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val CoreModule = module {
//    fun provideAppDatabase(appContext: Context): AppDatabase =
//        Room.databaseBuilder(
//            appContext,
//            AppDatabase::class.java,
//            "issues-db"
//        ).build()

    viewModel { MainViewModel() }
}