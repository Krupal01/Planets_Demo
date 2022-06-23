package com.example.practical_planets.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.practical_planets.R
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.tan

@Preview(device = Devices.AUTOMOTIVE_1024p )
@Composable
fun AdvanceSpaceCompose(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier.background(color = Color.Black).fillMaxSize()
    ) {

        val configuration  = LocalConfiguration.current
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
            val angleInDegree = Math.toRadians((angle).toDouble())
            val distance = sqrt(
                (
                        ((horizontalSemiAxis*verticalSemiAxis* tan(angleInDegree)).pow(2))+(horizontalSemiAxis*verticalSemiAxis).pow(2)
                        )/(
                        ((verticalSemiAxis* tan(angleInDegree)).pow(2))+(horizontalSemiAxis).pow(2)
                        )
            )
            return distance.toFloat().textDp()
        }

        fun isAngle60():Boolean{
            return (90 - mercuryAngle.value)>=60 && (90 - mercuryAngle.value)<=180
        }

        Image(
            painter = painterResource(id = R.drawable.space),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
                .constrainAs(space) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.half_sun),
            contentDescription = null,
            modifier = Modifier
                .size(width = ref.times(0.20).dp, height = ref.times(0.60).dp)
                .constrainAs(sun) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .zIndex(if (isAngle60()) 2f else 1f),
            contentScale = ContentScale.FillHeight
        )

        val center : ConstrainedLayoutReference = sun

        val planetXScale = listOf(
            2*0.15,     //mercury
            2*0.25,     //venus
            2*0.35,     //earth
            2*0.45,     //mars
            2*0.55,     //jupiter
            2*0.65,     //saturn
            2*0.75,     //uranus
            2*0.85,     //neptune
        )
        val planetYScale = listOf(
            0.15,       //mercury
            0.25,       //venus
            0.35,       //earth
            0.45,       //mars
            0.55,       //jupiter
            0.65,       //saturn
            0.75,       //uranus
            0.85,       //neptune
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
                text = "Angle : ${90 - mercuryAngle.value}",
                color = Color.White
            )
        }


        MercuryCompose(modifier = Modifier
                .constrainAs(mercury) {
                    circular(
                        center,
                        mercuryAngle.value,
                        getRadius(mercuryAngle.value, ref.times(planetXScale[0]), ref.times(planetYScale[0]))
                    )
                }
                .zIndex(if (isAngle60()) 1f else 2f))
        for(i in 0..360) {
            val j = createRef()
            Text(
                text = "-",
                color = Color.Gray,
                modifier = Modifier.constrainAs(j){
                    circular(
                        center,
                        i.toFloat(),
                        getRadius(i.toFloat(),  ref.times(planetXScale[0]), ref.times(planetYScale[0]))
                    )
                }
            )
        }


        VenusCompose(modifier = Modifier
            .constrainAs(venus) {
                circular(
                    center,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(planetXScale[1]), ref.times(planetYScale[1]))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))
        for(i in 0..360) {
            val j = createRef()
            Text(
                text = "-",
                color = Color.Gray,
                modifier = Modifier.constrainAs(j){
                    circular(
                        center,
                        i.toFloat(),
                        getRadius(i.toFloat(), ref.times(planetXScale[1]), ref.times(planetYScale[1]))
                    )
                }
            )
        }


        EarthCompose(modifier = Modifier
            .constrainAs(earth) {
                circular(
                    center,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(planetXScale[2]), ref.times(planetYScale[2]))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))
        for(i in 0..360) {
            val j = createRef()
            Text(
                text = "-",
                color = Color.Gray,
                modifier = Modifier.constrainAs(j){
                    circular(
                        center,
                        i.toFloat(),
                        getRadius(i.toFloat(), ref.times(planetXScale[2]), ref.times(planetYScale[2]))
                    )
                }
            )
        }


        MarsCompose(modifier = Modifier
            .constrainAs(mars) {
                circular(
                    center,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(planetXScale[3]), ref.times(planetYScale[3]))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))
        for(i in 0..360) {
            val j = createRef()
            Text(
                text = "-",
                color = Color.Gray,
                modifier = Modifier.constrainAs(j){
                    circular(
                        center,
                        i.toFloat(),
                        getRadius(i.toFloat(), ref.times(planetXScale[3]), ref.times(planetYScale[3]))
                    )
                }
            )
        }


        JupiterCompose(modifier = Modifier
            .constrainAs(jupiter) {
                circular(
                    center,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(planetXScale[4]), ref.times(planetYScale[4]))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))
        for(i in 0..360) {
            val j = createRef()
            Text(
                text = "-",
                color = Color.Gray,
                modifier = Modifier.constrainAs(j){
                    circular(
                        center,
                        i.toFloat(),
                        getRadius(i.toFloat(), ref.times(planetXScale[4]), ref.times(planetYScale[4]))
                    )
                }
            )
        }


        SaturnCompose(modifier = Modifier
            .constrainAs(saturn) {
                circular(
                    center,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(planetXScale[5]), ref.times(planetYScale[5]))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))
        for(i in 0..360) {
            val j = createRef()
            Text(
                text = "-",
                color = Color.Gray,
                modifier = Modifier.constrainAs(j){
                    circular(
                        center,
                        i.toFloat(),
                        getRadius(i.toFloat(), ref.times(planetXScale[5]), ref.times(planetYScale[5]))
                    )
                }
            )
        }


        UranusCompose(modifier = Modifier
            .constrainAs(uranus) {
                circular(
                    center,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(planetXScale[6]), ref.times(planetYScale[6]))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))
        for(i in 0..360) {
            val j = createRef()
            Text(
                text = "-",
                color = Color.Gray,
                modifier = Modifier.constrainAs(j){
                    circular(
                        center,
                        i.toFloat(),
                        getRadius(i.toFloat(), ref.times(planetXScale[6]), ref.times(planetYScale[6]))
                    )
                }
            )
        }


        NeptuneCompose(modifier = Modifier
            .constrainAs(neptune) {
                circular(
                    center,
                    mercuryAngle.value,
                    getRadius(mercuryAngle.value, ref.times(planetXScale[7]), ref.times(planetYScale[7]))
                )
            }
            .zIndex(if (isAngle60()) 1f else 2f))
        for(i in 0..360) {
            val j = createRef()
            Text(
                text = "-",
                color = Color.Gray,
                modifier = Modifier.constrainAs(j){
                    circular(
                        center,
                        i.toFloat(),
                        getRadius(i.toFloat(), ref.times(planetXScale[7]), ref.times(planetYScale[7]))
                    )
                }
            )
        }
    }
}