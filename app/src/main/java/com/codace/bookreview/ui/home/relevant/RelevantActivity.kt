package com.codace.bookreview.ui.home.relevant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codace.bookreview.R
import com.codace.bookreview.data.repository.DataRepositoryImpl
import com.codace.bookreview.utils.ext.load

class RelevantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relevant)

        val relevantFragment = RelevantFragment.newInstance()

        supportFragmentManager.load(R.id.relevant_container, relevantFragment)

        RelevantPresenter(DataRepositoryImpl(), relevantFragment)
    }
}
