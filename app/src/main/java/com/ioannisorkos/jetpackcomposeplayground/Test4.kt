package com.ioannisorkos.jetpackcomposeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ioannisorkos.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme
import kotlin.random.Random

@Composable
fun Test4State(){

    val passColor = remember {
        mutableStateOf(Color.White)
    }

    val myColor = remember {
        mutableStateOf(Color.Cyan)
    }

    //delegation
    var myColor2 by remember {
        mutableStateOf(Color.Yellow)
    }

    val myColorList = remember {
        mutableStateListOf(Color.Yellow,Color.Red, Color.Green)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        Arrangement.Top
    ) {

        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(passColor.value),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Box1: This value changed by box 4",
                color = Color.Black
            )
        }

        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()

                // .fillMaxWidth()
                .background(myColor.value)
                .clickable {
                    myColor.value = Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                },
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Box2",
                color = Color.White
            )
        }

        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .fillMaxWidth()
                .background(
                    myColor2
                )
                .clickable {
                    myColor2 = myColorList.random()
                },
            contentAlignment = Alignment.Center
        ){
        Text(
            text = "Box3",
            color = Color.Black
        )
    }

        Spacer(
            modifier = Modifier
                .weight(1.0f) )


        AnotherColorBox{
            passColor.value = it
        }


    }

}


@Composable
fun AnotherColorBox(changeColor:(thisColor:Color)->Unit){
    Box(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .fillMaxWidth()
            .background(
                Color.LightGray
            )
            .clickable {
                changeColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            },
        Alignment.Center
    ){
        Text(
            text = "Box4: This changes value Box1",
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Test4Preview() {
    JetpackComposePlayGroundTheme{
        Test4State()
    }
}