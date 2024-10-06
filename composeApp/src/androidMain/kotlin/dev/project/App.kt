package dev.project

import android.app.Application
import dev.project.di.initKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
