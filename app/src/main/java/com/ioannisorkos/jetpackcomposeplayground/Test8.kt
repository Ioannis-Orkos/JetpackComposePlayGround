package com.ioannisorkos.jetpackcomposeplayground

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ioannisorkos.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme
import kotlinx.coroutines.delay


@Composable
fun Test8(){

    var sizeState by remember {
        mutableStateOf(value = 200.dp)
    }

    val size by animateDpAsState(
        targetValue = sizeState,

//        keyframes {
//            durationMillis = 5000
//            sizeState at 0 with LinearEasing
//            sizeState * 1.5f at 1000 with FastOutLinearInEasing
//            sizeState * 2f at 5000
//        }

        spring(
            Spring.DampingRatioHighBouncy
            )

//        tween(
//            durationMillis = 3000,
//            delayMillis = 300,
//            easing = LinearEasing
//        )
    )


    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue =  Color.Green,
        animationSpec = infiniteRepeatable(
            tween( durationMillis = 3000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .background(color)
            .size(size),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = {
            sizeState+=200.dp
        }) {
            Text("Increase size")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun Test8Preview() {
    JetpackComposePlayGroundTheme{
        Test8()
    }
}