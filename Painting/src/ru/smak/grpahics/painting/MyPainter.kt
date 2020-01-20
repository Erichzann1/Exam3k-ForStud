package ru.smak.grpahics.painting

import ru.smak.graphics.convertation.CartesianScreenPlane
import ru.smak.graphics.convertation.Converter
import ru.smak.graphics.painting.APainter
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin

enum class PlaneAxisType {
    X, Y
}

class MyPainter(final override var plane: CartesianScreenPlane) : APainter() {

    private val color: Color = Color(200, 0, 0, 100)

    override fun paint(g:Graphics?) {
        g?.color = color
        val first = {x:Double -> x+1/(x*x*x)}
        val second = {x:Double -> cos(asin(x)/4)}
        myPaint(g, first)
    }

    private fun myPaint(g: Graphics?, operation: (Double)->Double){
        var y1:Int
        var y2:Int
        for (i in 0..plane.width) {
            y1 = Converter.yCrt2Scr(operation(Converter.xScr2Crt(i, plane)), plane)
            y2 = Converter.yCrt2Scr(operation(Converter.xScr2Crt(i + 1, plane)), plane)
            g?.drawLine(i, y1, i + 1, y2)
        }
    }

}