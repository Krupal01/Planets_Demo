package com.example.practical_planets.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.practical_planets.R
import kotlin.math.*

@Preview(widthDp = 869,heightDp = 412)
@Composable
fun SpaceCompose(
    modifier: Modifier = Modifier,
){
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {

        val (
            space,
            sun,
            mercury,
            venus,
            earth,
            mars,
            jupiter,
            saturn,
            uranus,
            neptune,
            addBtn
        ) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.space),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(space) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.half_sun),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .constrainAs(sun) {
                    start.linkTo(space.start)
                    top.linkTo(space.top)
                    bottom.linkTo(space.bottom)
                },
            contentScale = ContentScale.FillHeight
        )

        val mercuryAngle = remember {
            mutableStateOf(90f)
        }


        fun getRadius(angle: Float, horizontalSemiAxis: Float, verticalSemiAxis: Float): Float {
            val angleInDegree = Math.toRadians((90-angle).toDouble())
            val distance = sqrt(
                x = ((horizontalSemiAxis.pow(2) * ((1 + cos( 2*angleInDegree)) / 2)) + (verticalSemiAxis.pow(2) * ((1 - cos(2 * angleInDegree)) / 2)))
//            x= (((horizontalSemiAxis * cos(angleInDegree)).pow(2)) + ((verticalSemiAxis * sin(angleInDegree)).pow(2)))
            )
            return ((distance * 100.0).roundToInt() / 100.0).toFloat()
        }

        Button(
            onClick = {
                mercuryAngle.value = mercuryAngle.value - 1
            },
            modifier = Modifier
                .constrainAs(addBtn) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            border = BorderStroke(width = 1.dp,color = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {

            Text(
                text = "Angle : ${90 - mercuryAngle.value} ",
                color = Color.White
            )
        }

        MercuryCompose(
            modifier = Modifier.constrainAs(mercury){
                circular(
                    sun,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value ,70f,50f).dp
                )
            }
        )

        VenusCompose(modifier = Modifier.constrainAs(venus){
            circular(
                sun,
                mercuryAngle.value,
                getRadius(mercuryAngle.value ,105f,70f).dp
            )
        })

        EarthCompose(modifier = Modifier.constrainAs(earth){
            circular(
                sun,
                mercuryAngle.value,
                getRadius(mercuryAngle.value ,150f,100f).dp
            )
        })
        MarsCompose(modifier = Modifier.constrainAs(mars){
            circular(
                sun,
                mercuryAngle.value,
                getRadius(mercuryAngle.value ,210f,110f).dp
            )
        })

        JupiterCompose(modifier = Modifier.constrainAs(jupiter){
            circular(
                sun,
                mercuryAngle.value,
                getRadius(mercuryAngle.value ,300f,120f).dp
            )
        })

        SaturnCompose(modifier = Modifier.constrainAs(saturn){
            circular(
                sun,
                mercuryAngle.value,
                getRadius(mercuryAngle.value ,400f,130f).dp
            )
        })

        UranusCompose(modifier = Modifier.constrainAs(uranus){
            circular(
                sun,
                mercuryAngle.value,
                getRadius(mercuryAngle.value ,470f,140f).dp
            )
        })

        NeptuneCompose(modifier = Modifier.constrainAs(neptune){
            circular(
                sun,
                mercuryAngle.value,
                getRadius(mercuryAngle.value ,520f,150f).dp
            )
        })


    }
}
