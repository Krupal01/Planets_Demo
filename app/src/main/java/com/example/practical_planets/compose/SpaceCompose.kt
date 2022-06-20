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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.practical_planets.R
import kotlin.math.*

@Preview(device = Devices.AUTOMOTIVE_1024p , )
@Composable
fun SpaceCompose(
    modifier: Modifier = Modifier
){
    ConstraintLayout(
        modifier = modifier
    ) {

        val configuration  = LocalConfiguration.current
        val scrHeight = configuration.screenHeightDp
        val scrWidth = configuration.screenWidthDp

        val ref = scrWidth.times(0.5)

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

        val (
            mercuryOrbit,
            venusOrbit,
            earthOrbit,
            marsOrbit,
            jupiterOrbit,
            saturnOrbit,
            uranusOrbit,
            neptuneOrbit
        ) = createRefs()

        val mercuryAngle = remember {
            mutableStateOf(90f)
        }

        val density = LocalDensity.current
        fun Float.textDp(): Dp = with(density) {
            this@textDp.toDp()
        }

        fun getRadius(angle: Float, hSemiAxis: Double, vSemiAxis: Double): Dp {
            val horizontalSemiAxis = hSemiAxis.toFloat()
            val verticalSemiAxis = vSemiAxis.toFloat()
            val angleInDegree = Math.toRadians((90-angle).toDouble())
            val distance = sqrt(
                x = ((horizontalSemiAxis.pow(2) * ((1 + cos( 2*angleInDegree)) / 2)) + (verticalSemiAxis.pow(2) * ((1 - cos(2 * angleInDegree)) / 2)))
//            x= (((horizontalSemiAxis * cos(angleInDegree)).pow(2)) + ((verticalSemiAxis * sin(angleInDegree)).pow(2)))
            )
//            return ((distance * 100.0).roundToInt() / 100.0).toFloat()
            return distance.toFloat().textDp()
        }

        fun isAngle60():Boolean{
            return (90 - mercuryAngle.value)>=60 && (90 - mercuryAngle.value)<=180
        }

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
                .size(width = ref.times(0.20).dp, height = ref.times(0.60).dp)
                .constrainAs(sun) {
                    start.linkTo(space.start)
                    top.linkTo(space.top)
                    bottom.linkTo(space.bottom)
                }
                .zIndex(if(isAngle60()) 2f else 1f),
            contentScale = ContentScale.FillHeight
        )



        Button(
            onClick = {
                if((90-mercuryAngle.value)==360f){mercuryAngle.value = 90f}
                mercuryAngle.value = mercuryAngle.value - 10
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
                    getRadius(mercuryAngle.value, ref.times(0.25), ref.times(0.20))
                )
            }.zIndex(if(isAngle60()) 1f else 2f)
        )

        VenusCompose(modifier = Modifier
            .constrainAs(venus) {
                circular(
                    sun,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(0.35), ref.times(0.30))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))

        EarthCompose(modifier = Modifier
            .constrainAs(earth) {
                circular(
                    sun,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(0.55), ref.times(0.50))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))
        MarsCompose(modifier = Modifier
            .constrainAs(mars) {
                circular(
                    sun,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(0.75), ref.times(0.70))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))

        JupiterCompose(modifier = Modifier
            .constrainAs(jupiter) {
                circular(
                    sun,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(1.0), ref.times(0.9))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))

        SaturnCompose(modifier = Modifier
            .constrainAs(saturn) {
                circular(
                    sun,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(1.3), ref.times(1.1))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))

        UranusCompose(modifier = Modifier
            .constrainAs(uranus) {
                circular(
                    sun,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(1.5), ref.times(1.3))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))

        NeptuneCompose(modifier = Modifier
            .constrainAs(neptune) {
                circular(
                    sun,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(1.7), ref.times(1.5))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))





        OrbitCompose(
            modifier = Modifier
                .constrainAs(mercuryOrbit) {
                    top.linkTo(sun.top)
                    start.linkTo(sun.start)
                    bottom.linkTo(sun.bottom)
                }
                .zIndex(0f)
                .offset(y=scrWidth.times(0.02).toFloat().textDp()),
            mWidth = scrWidth.times(0.18).toFloat(),
            mHeight = scrWidth.times(0.22).toFloat()
        )

        OrbitCompose(
            modifier = Modifier
                .constrainAs(venusOrbit) {
                    top.linkTo(sun.top)
                    start.linkTo(sun.start)
                    bottom.linkTo(sun.bottom)
                }
                .zIndex(0f)
                .offset(y=scrWidth.times(0.02).toFloat().textDp()),
            mWidth = scrWidth.times(0.22).toFloat(),
            mHeight = scrWidth.times(0.30).toFloat()
        )

        OrbitCompose(
            modifier = Modifier
                .constrainAs(earthOrbit) {
                    top.linkTo(sun.top)
                    start.linkTo(sun.start)
                    bottom.linkTo(sun.bottom)
                }
                .zIndex(0f)
                .offset(y=scrWidth.times(0.02).toFloat().textDp()),
            mWidth = scrWidth.times(0.32).toFloat(),
            mHeight = scrWidth.times(0.50).toFloat()
        )

        OrbitCompose(
            modifier = Modifier
                .constrainAs(marsOrbit) {
                    top.linkTo(sun.top)
                    start.linkTo(sun.start)
                    bottom.linkTo(sun.bottom)
                }
                .zIndex(0f)
                .offset(y=scrWidth.times(0.05).toFloat().textDp()),
            mWidth = scrWidth.times(0.42).toFloat(),
            mHeight = scrWidth.times(0.7).toFloat()
        )

        OrbitCompose(
            modifier = Modifier
                .constrainAs(jupiterOrbit) {
                    top.linkTo(sun.top)
                    start.linkTo(sun.start)
                    bottom.linkTo(sun.bottom)
                }
                .zIndex(0f)
                .offset(y=scrWidth.times(0.09).toFloat().textDp()),
            mWidth = scrWidth.times(0.55).toFloat(),
            mHeight = scrWidth.times(1.3).toFloat()
        )

        OrbitCompose(
            modifier = Modifier
                .constrainAs(saturnOrbit) {
                    top.linkTo(sun.top)
                    start.linkTo(sun.start)
                    bottom.linkTo(sun.bottom)
                }
                .zIndex(0f)
                .offset(y=scrWidth.times(0.25).toFloat().textDp()),
            mWidth = scrWidth.times(0.7).toFloat(),
            mHeight = scrWidth.times(4).toFloat()
        )

        OrbitCompose(
            modifier = Modifier
                .constrainAs(uranusOrbit) {
                    start.linkTo(sun.start)
                }
                .zIndex(0f)
                .offset(y=scrWidth.times(0.35).toFloat().textDp()),
            mWidth = scrWidth.times(0.8).toFloat(),
            mHeight = scrWidth.times(5.6).toFloat()
        )

        OrbitCompose(
            modifier = Modifier
                .constrainAs(neptuneOrbit) {
                    top.linkTo(sun.top)
                    start.linkTo(sun.start)
                    bottom.linkTo(sun.bottom)
                }
                .zIndex(0f)
                .offset(y=scrWidth.times(0.48).toFloat().textDp()),
            mWidth = scrWidth.times(0.9).toFloat(),
            mHeight = scrWidth.times(8).toFloat()
        )
    }
}

