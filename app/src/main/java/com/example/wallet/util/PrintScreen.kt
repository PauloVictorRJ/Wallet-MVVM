package com.example.wallet.util

import android.graphics.Bitmap
import android.util.Log
import android.view.View


class PrintScreen() {
    fun printScreen(view: View): Bitmap? {
        var screen: Bitmap? = null
        try {
            screen = Bitmap.createBitmap(
                view.measuredWidth,
                view.measuredHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = android.graphics.Canvas(screen)
            view.draw(canvas)
        } catch (e: Exception) {
            Log.e("IMAGE ERROR", e.message.toString())
        }
        return screen
    }
}