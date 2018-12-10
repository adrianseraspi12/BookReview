package com.codace.bookreview.ui.home.newrelease

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codace.bookreview.R
import com.codace.bookreview.data.repository.DataRepositoryImpl
import com.codace.bookreview.utils.ext.load

class NewReleaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_release)

        val newReleaseFragment = NewReleaseFragment.newInstance()
        supportFragmentManager.load(R.id.new_release_list_container, newReleaseFragment)

        NewReleasePresenter(DataRepositoryImpl(), newReleaseFragment)
    }

}
