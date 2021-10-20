package com.ioannisorkos.jetpackcomposeplayground

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ioannisorkos.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme
import kotlinx.coroutines.delay

@Composable
fun Test9(){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


    val p = produceState(initialValue = 5f){
        while(value<90f)
        {
            delay(100L)
            value += 1
        }
    }

    CircularProgressBar(
        progress = p.value,
        backgroundProgressBarColor = Color.Transparent,
        modifier = Modifier
            .fillMaxHeight(0.4f)
            .fillMaxWidth(0.8f)

    )



   CircularProgressBar2(
       percentage = 0.75f,
       number = 100,
       modifier = Modifier
           .fillMaxHeight(0.8f)
           .fillMaxWidth(0.8f)

   )


    }
}

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    progress: Float = 0f,
    progressMax: Float = 100f,
    progressBarColor: Color = Color.Black,
    progressBarWidth: Dp = 7.dp,
    backgroundProgressBarColor: Color = Color.Gray,
    backgroundProgressBarWidth: Dp = 3.dp,
    roundBorder: Boolean = false,
    startAngle: Float = 0f
) {
    Canvas(modifier = modifier.aspectRatio(1f)) {

        val canvasSize = size.minDimension

        val radius = canvasSize / 2 - maxOf(backgroundProgressBarWidth, progressBarWidth).toPx() / 2

        drawCircle(
            color = backgroundProgressBarColor,
            radius = radius,
            center = size.center,
            style = Stroke(width = backgroundProgressBarWidth.toPx())
        )

        drawArc(
            color = progressBarColor,
            startAngle = 270f + startAngle,
            sweepAngle = (progress / progressMax) * 360f,
            useCenter = false,
            topLeft = size.center - Offset(radius, radius),
            size = Size(radius * 2, radius * 2),
            style = Stroke(
                width = progressBarWidth.toPx(),
                cap = if (roundBorder) StrokeCap.Round else StrokeCap.Butt
            )
        )
    }
}


@Composable
fun CircularProgressBar2(
    modifier: Modifier = Modifier,
    percentage:Float,
    number:Int,
    fontSize: TextUnit = 28.sp,
    //radius:Dp = 50.dp,
    color:Color = Color.Green,
    strokeWidth:Dp = 8.dp,
    animaDuration:Int=1000,
    animDelay:Int=0
){
    var animationPlayed by remember {
         mutableStateOf(false)
    }


    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        tween(
            durationMillis = animaDuration,
            delayMillis = animDelay
        )
    )

    //run only once
    LaunchedEffect(key1 = true){
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.aspectRatio(1f)
        //modifier = Modifier.size(radius*2f)
    ){
        Canvas(modifier = modifier){
        //Canvas(modifier = Modifier.size(radius*2f)){
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(),cap = StrokeCap.Round)
            )
            drawLine(
                start = Offset(x = 0f, y = (size.height/2f)),
                end = Offset(x =((size.width/2f)*2f*curPercentage.value), y = (size.height/2f)),
                //start = Offset(x = 0f, y = radius.toPx()),
                //end = Offset(x =(radius*2f*curPercentage.value).toPx(), y = radius.toPx()),
                color = color,
                strokeWidth = strokeWidth.toPx(),
                cap =  StrokeCap.Round
            )

        }
        Text(
            text = (curPercentage.value*number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold

        )

    }

}



@Preview(showBackground = true)
@Composable
fun Test9Preview() {
    JetpackComposePlayGroundTheme{
        Test9()
    }
}