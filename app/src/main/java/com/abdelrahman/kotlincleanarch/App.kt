package com.abdelrahman.kotlincleanarch

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @Author : Abdel-Rahman El-Shikh
 * @Date : 04-Oct-20
 * @Project : com.abdelrahman.kotlincleanarch
 */
@HiltAndroidApp
class App :Application() {
    override fun onCreate() {
        super.onCreate()
    }
}