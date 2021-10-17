package com.ioannisorkos.jetpackcomposeplayground

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

var i:Int  = 0
var j:Int  = 0
var x:Int  = 0
var d  by mutableStateOf(0)
var d2  by mutableStateOf(0)

//we can use condition check to  customize the functions
@Composable
fun Test7(){

    var produceVariable = produceState(initialValue = 0 ){

        while(true)
        {
            delay(3000L)
            value += 4
        }

    }

    //this invoiced every time the composition happens
    ++j

    //this launched after successful composition
    SideEffect {
        ++x
    }

    //this will fun on successful composition and after it the key changes ex if mutable updates
    //the coroutine is canceled when the value updated and called again
    //in this case we can use  if() to have control to the process before called again
    LaunchedEffect(key1 = d2) {
       ++x
    }

    //this launched after successful composition call dispose before destroyed
    //this will fun on successful composition and after it the key changes ex if mutable updates

    DisposableEffect(key1 = d2){

        ++d

        onDispose {
            d=0
        }
    }

Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier.fillMaxSize()
)
    {
        Text(
            text = "This is val: ${j} updated normal",
            modifier = Modifier
                .background(Color.Red)
                .height(30.dp)
        )

        Text(
            text = "This is val: $x updated on sideEffect",
            modifier = Modifier
                .background(Color.Red)
                .height(30.dp)
        )

        Text(
            text = "This is val: $d updated on disposableEffect",
            modifier = Modifier
                .clickable { ++d }
                .background(Color.Red)
                .height(30.dp)
        )
        Text(
            text = "This is val: ${produceVariable.value} updated on disposableEffect",

        )
    }


}


@Composable
fun Test7SysNavBar(){

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight


    Box( Modifier
        .fillMaxSize()
        .clickable {
            if(systemUiController.isNavigationBarVisible){
                systemUiController.isNavigationBarVisible = false
            }
        })

    SideEffect {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
        systemUiController.isNavigationBarVisible = false
        systemUiController.isStatusBarVisible = false
        systemUiController.isSystemBarsVisible = false
        systemUiController.isNavigationBarContrastEnforced = false
        systemUiController.isNavigationBarContrastEnforced = false
    }

}


@Composable
fun Test7BackCustom(){

    val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher

    val callback = object:OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            if(x>=9)
                dispatcher.onBackPressed()
        }

    }

    Button(
        onClick = {
            //dispatcher.addCallback(callback);
            dispatcher.addCallback(object:OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                   // add to do here
                    if(x>=9)
                        dispatcher.onBackPressed()
                }
            }
            )
    }
    ) {
        Text(text = "Click me to add call callback to the back_pressed!")
    }
}