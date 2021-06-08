package id.health.mate.presentation.helper.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.health.mate.data.Repository
import id.health.mate.presentation.home.MainViewModel

class ViewModelFactory private constructor(private val repo: Repository) : ViewModelProvider.Factory {

    companion object {
        @Volatile
        var instance: ViewModelFactory? = null

        fun instance(): ViewModelFactory {
            synchronized(ViewModelFactory::class) {
                if (instance == null) instance = ViewModelFactory(Repository.getInstance())
            }
            return instance as ViewModelFactory
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}