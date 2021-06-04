package id.health.mate.presentation.helper.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

fun Fragment.removeFragment() =
    requireActivity().supportFragmentManager
        .beginTransaction().remove(this)
        .commit()

fun Fragment.add(@IdRes id: Int, fragment: Fragment, bundle: Bundle? = null) =
    requireActivity().supportFragmentManager
        .beginTransaction().add(id, fragment.apply { arguments = bundle })
        .commit()