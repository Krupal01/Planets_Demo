package com.example.practical_planets.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlin.math.*

@Composable
fun OrbitCompose(
    modifier: Modifier = Modifier,
    mWidth : Float = 550f,
    mHeight : Float = 1500f,
) {
    val density = LocalDensity.current
    fun Float.textDp(): Dp = with(density) {
        this@textDp.toDp()
    }

    Canvas(modifier =modifier
        .size(width =  mWidth.textDp(), height = mHeight.textDp())
    ){
        val mstartAngle = (mWidth+mHeight)/((mWidth+mHeight)/(0.4f*mWidth))

        drawArc(
            color = Color.Gray,
            startAngle = -(mstartAngle),
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(width = 5f,cap = StrokeCap.Round),
            topLeft = Offset(x= -(mWidth/0.6F) , y = -(mHeight/8))
        )
    }

}
