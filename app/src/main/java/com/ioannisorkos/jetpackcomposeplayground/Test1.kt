package com.ioannisorkos.jetpackcomposeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ioannisorkos.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@Composable
fun Test1(){

    Column(
        modifier = Modifier
            .border(13.dp, Color.Yellow)
            .padding(13.dp)
            .border(13.dp, Color.Red)
            .padding(13.dp)
            .fillMaxSize()
            .background(Color.Cyan),
        Arrangement.SpaceAround,
        Alignment.CenterHorizontally
    ) {

        Text(
            text="Hello",
            modifier= Modifier
                .clickable() {}
                .background(Color.Red))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.requiredHeight(30.dp) will not cropped
                .height(50.dp)
                .background(Color.Magenta),
            Arrangement.SpaceAround,
            Alignment.CenterVertically,
        ){

            Text(
                text="Hello",
                modifier= Modifier
                    .background(Color.Red)
                    .padding(15.dp))

            Spacer(
                modifier = Modifier
                    .background(Color.Magenta)
                    .width(30.dp))

            Text(
                text="world",
                modifier= Modifier
                    .background(Color.Blue)
                    .offset(8.dp, 8.dp)
                    .background(Color.Gray))
        }


        Text(
            text="world",
            modifier= Modifier
                .background(Color.Blue))

    }
}


@Preview(showBackground = true)
@Composable
fun Test1Preview() {
    JetpackComposePlayGroundTheme {
            Test1()
    }
}