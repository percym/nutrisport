package dev.percym.shared.util

actual fun getScreenWidth(): Float {
    return return android.content.res.Resources.getSystem().displayMetrics.widthPixels /
            android.content.res.Resources.getSystem().displayMetrics.density
}