package com.ioannisorkos.jetpackcomposeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ioannisorkos.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@Composable
fun Test3(){

    //For downloading Fonts
    //https://fonts.google.com/
    //copy res new-dir font folder add font-family files
    //make sure all font files are in small letters and dashes replaced with underscore
    val font = FontFamily(
        Font(R.font.festive_regular)
    )

    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Top,
        ){

        Text(
            text = "Jetpack compose",
            color = Color.White,
            fontSize = 30.sp,
            //fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            //textDecoration = TextDecoration.LineThrough
        )
        
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 30.sp
                    )
                ){
                    append("J")
                }
                append("etpack")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 30.sp
                    )
                ){
                    append("C")
                }
                append("ompose")

            },
            color = Color.Red,
            fontSize = 30.sp,
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            //textDecoration = TextDecoration.LineThrough
        )

    }

}


@Preview(showBackground = true)
@Composable
fun Test3Preview() {
    JetpackComposePlayGroundTheme{
        Test3()
    }
}