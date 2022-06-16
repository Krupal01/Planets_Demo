package com.example.practical_planets.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practical_planets.R

val FONT_SIZE = 20.sp
val FONT_WEIGHT = FontWeight.Bold

@Preview
@Composable
fun MercuryCompose(
modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mercury",
            color = Color.White,
            fontSize = FONT_SIZE,
            fontWeight = FONT_WEIGHT
        )
        Image(painter = painterResource(
            id = R.drawable.mercury),
            contentDescription = null,
            modifier = Modifier.size(20.dp,20.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun VenusCompose(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Venus",
            color = Color.White,
            fontSize = FONT_SIZE,
            fontWeight = FONT_WEIGHT
        )
        Image(painter = painterResource(
            id = R.drawable.venus),
            contentDescription = null,
            modifier = Modifier.size(40.dp,40.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun EarthCompose(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Earth",
            color = Color.White,
            fontSize = FONT_SIZE,
            fontWeight = FONT_WEIGHT
        )
        Image(
            painter = painterResource(id = R.drawable.earth),
            contentDescription = null,
            modifier = Modifier.size(60.dp,60.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun MarsCompose(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mars",
            color = Color.White,
            fontSize = FONT_SIZE,
            fontWeight = FONT_WEIGHT
        )
        Image(painter = painterResource(
            id = R.drawable.mars),
            contentDescription = null,
            modifier = Modifier.size(40.dp,40.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun JupiterCompose(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Jupiter",
            color = Color.White,
            fontSize = FONT_SIZE,
            fontWeight = FONT_WEIGHT
        )
        Image(painter = painterResource(
            id = R.drawable.jupiter),
            contentDescription = null,
            modifier = Modifier.size(120.dp,120.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun SaturnCompose(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Saturn",
            color = Color.White,
            fontSize = FONT_SIZE,
            fontWeight = FONT_WEIGHT
        )
        Image(painter = painterResource(
            id = R.drawable.saturn),
            contentDescription = null,
            modifier = Modifier.size(150.dp,100.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun UranusCompose(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Uranus",
            color = Color.White,
            fontSize = FONT_SIZE,
            fontWeight = FONT_WEIGHT
        )
        Image(painter = painterResource(
            id = R.drawable.uranus),
            contentDescription = null,
            modifier = Modifier.size(80.dp,80.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun NeptuneCompose(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Neptune",
            color = Color.White,
            fontSize = FONT_SIZE,
            fontWeight = FONT_WEIGHT
        )
        Image(painter = painterResource(
            id = R.drawable.neptune),
            contentDescription = null,
            modifier = Modifier.size(80.dp,80.dp),
            contentScale = ContentScale.Fit
        )
    }
}