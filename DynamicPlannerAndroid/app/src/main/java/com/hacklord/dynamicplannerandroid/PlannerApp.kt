package com.hacklord.dynamicplannerandroid

import android.app.Application
import com.hacklord.dynamicplannerandroid.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PlannerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PlannerApp)
            androidLogger()
            modules(appModule)
        }
    }
}