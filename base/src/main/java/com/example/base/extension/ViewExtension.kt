package com.example.base.extension

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.enable() {
    this.isEnabled = true
}

fun View.disable() {
    this.isEnabled = false
}

inline fun Context.showToast(message: () -> String) {
    Toast.makeText(this, message(), Toast.LENGTH_SHORT).show()
}

inline fun Fragment.showToast(message: () -> String) {
    Toast.makeText(requireActivity(), message(), Toast.LENGTH_SHORT).show()
}

fun Group.setAllOnclickListener(listener: (View) -> Unit) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener(listener)
    }
}