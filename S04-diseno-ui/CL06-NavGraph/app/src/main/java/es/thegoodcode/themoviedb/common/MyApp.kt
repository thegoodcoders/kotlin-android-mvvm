package es.thegoodcode.themoviedb.common

import android.app.Application
import es.thegoodcode.themoviedb.api.NetworkContainer

class MyApp: Application() {

    companion object {
        lateinit var instance: MyApp
        val networkContainer = NetworkContainer()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    
}