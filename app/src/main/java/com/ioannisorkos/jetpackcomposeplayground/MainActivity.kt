package com.ioannisorkos.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ioannisorkos.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlayGroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    //Test1 Column, Row, spacer, border, padding, margin(offset)
                    //Test1()

                    //Test2 is  ImageCard, Box, gradient, Painter, Modifier, weight
                    //Test2Box()
                    //Test2Row()

                    //Test3 is about Text, font, decoration, style
                    Test3()



                }
            }
        }
    }
}



