package com.codace.bookreview.utils.ext

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.load(path: String, request: (RequestCreator) -> RequestCreator) {
        request(Picasso.get().load(path)).into(this)
}

fun FragmentManager.load(@IdRes containerId: Int, fragment: Fragment) {
        beginTransaction().replace(containerId, fragment).commit()
}

fun Context.showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}