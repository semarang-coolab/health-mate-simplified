package id.health.mate.presentation.helper.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.health.mate.data.Repository
import id.health.mate.presentation.home.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor() : ViewModelProvider.Factory {

    companion object {
        @Volatile
        var instance: ViewModelFactory? = null

        @JvmName("getInstance1")
        fun getInstance(): ViewModelFactory {
            synchronized(ViewModelFactory::class) {
                if (instance == null) instance = ViewModelFactory()
            }
            return instance as ViewModelFactory
        }
    }

    private val repo = Repository.getInstance()


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}