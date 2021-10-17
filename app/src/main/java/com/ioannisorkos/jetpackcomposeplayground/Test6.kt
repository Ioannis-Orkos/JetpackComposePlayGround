package com.ioannisorkos.jetpackcomposeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun Test6(){

    //survive process death
    var clickedId by rememberSaveable {  mutableStateOf(-1) }

    LazyColumn{
        itemsIndexed(
            listOf("hello","how","are","you")
        ){
                index, value ->

                Text(
                    "List $index "+"    "+" $value",
                    modifier = Modifier
                        .clickable { clickedId = index}
                )

                if(index== clickedId ){
                        Text("$value") }
                    }

                }

//This is with just items
//        LazyColumn{
//                items(500){
//                    Text("List $it")
//
//                }
//            }

    }



//forloop list with normal column
@Composable
fun Test6_1(){
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()


    Column(){
        Text(
            text = "${scrollState.value}",
            modifier = Modifier
                .clickable { scope.launch {  scrollState
                    .animateScrollTo(value = 645) }}
        )
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            for (i in 1 .. 50){
                Text("List $i")

            }
        }
    }
}