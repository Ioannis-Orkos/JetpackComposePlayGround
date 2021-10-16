package com.ioannisorkos.jetpackcomposeplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ioannisorkos.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@Composable
fun Test2Row(){

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(30.dp),
        //Arrangement.Center
    ){
        ImageCard(
            modifier=Modifier.weight(0.4f),
            painter = painterResource(R.drawable.spider_man),
            contentDescription = "Image of spider man",
            title = "Spider man" )

        Spacer(modifier = Modifier.weight(0.1f))

        ImageCard(
            modifier=Modifier.weight(0.4f),
            painter = painterResource(R.drawable.spider_man),
            contentDescription = "Image of spider man",
            title = "Spider man" )
    }
}

@Composable
fun Test2Box(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(35.dp)
    ){
        ImageCard(
            modifier=Modifier.fillMaxWidth(0.4f),
            painter = painterResource(R.drawable.spider_man),
            contentDescription = "Image of spider man",
            title = "Spider man" )
    }
}




@Composable
fun ImageCard(
    painter: Painter,
    contentDescription:String,
    title:String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .aspectRatio(0.7f),
        shape = RoundedCornerShape(15.dp),
        elevation =  5.dp
    ) {
        Box(
            modifier = Modifier
                //.height(200.dp)
                .fillMaxHeight()){


            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )


            //Gradient
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 200f
                        )
                    )
            )

            //Text
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(
                    text = title,
                    style = TextStyle(Color.White),
                    fontSize = 16.sp)
            }

        }

    }

}


@Preview(showBackground = true)
@Composable
fun Test2PreviewRow() {
    JetpackComposePlayGroundTheme {
        Test2Row()
    }
}

@Preview(showBackground = true)
@Composable
fun Test2PreviewBox() {
    JetpackComposePlayGroundTheme {
        Test2Box()
    }
}