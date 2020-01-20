package ru.smak.grpahics.painting

import ru.smak.graphics.convertation.CartesianScreenPlane
import ru.smak.graphics.convertation.Converter
import ru.smak.graphics.painting.APainter
import java.awt.Color
import java.awt.Graphics
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class MyPainter2(

    override val plane: CartesianScreenPlane) : APainter() {

    override fun paint(g: Graphics?) {
        myPaint(g)
    }

    private val color: Color = Color(200, 0, 0, 100)
    private val left = -PI
    private val right = PI
    private val x = {t:Double -> sin(4*t) }
    private val y = {t:Double -> cos(t) }

    private fun myPaint(g: Graphics?) {

        g?.color = color
        var cur = left
        val step = (right - left) / 100
        while (cur <= right) {
            val x1 = Converter.xCrt2Scr(x(cur), plane)
            val y1 = Converter.yCrt2Scr(y(cur), plane)
            val x2 = Converter.xCrt2Scr(x(cur+step), plane)
            val y2 = Converter.yCrt2Scr(y(cur+step), plane)
            g?.drawLine(x1, y1, x2, y2)
            cur+=step
        }
    }


}