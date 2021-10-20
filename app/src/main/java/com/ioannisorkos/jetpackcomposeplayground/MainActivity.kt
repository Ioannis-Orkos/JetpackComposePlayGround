package com.ioannisorkos.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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
                    //Test3()

                    //This is about state, change state form another fun, random color
                    //Test4State()

                    //Test5 Scaffold, using coroutine, scope, Snack bar, keyboard close,
                    //Test5()

                    //Test6:- LazyColumn, scrollable, scrollState
                    //Test6_1() //column with vertical state
                    //Test6()

                    //Test7 is about different effects sideEffect, disposableEffect, normal operation
                    //also example on on back press with custom call back, hide the system navigation
                    //use of break point recommended to understand better
                    //dependency implementation "com.google.accompanist:accompanist-systemuicontroller:0.20.0"
                    //used for the nav
                    //Test7SysNavBar()
                    //Test7BackCustom()
                    //Test7()

                    //Test8 simple animation animateDpAsState with different effect, color transition
                    //Test8()

                    //Test9 custom circular and line progressbar with animation
                    Test9()












                }
            }
        }
    }
}



