package com.codace.bookreview

import android.app.Application
import com.github.ajalt.timberkt.Timber

class BookReview: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}