package com.codace.bookreview.ui.home.relevant


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.codace.bookreview.R

/**
 * A simple [Fragment] subclass.
 *
 */
class RelevantFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_relevant, container, false)
    }


}
