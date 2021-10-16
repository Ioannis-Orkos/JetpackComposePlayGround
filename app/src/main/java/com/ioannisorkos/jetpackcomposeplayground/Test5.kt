package com.ioannisorkos.jetpackcomposeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ioannisorkos.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme
import kotlinx.coroutines.launch


@Composable
fun Test5(){
    Snackbar(
        shape = RoundedCornerShape(15.dp) ,
        elevation = 5.dp,
        contentColor = Color.Gray
    ) {
        Text(text = "This is default snackbar")
    }

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    //val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current


    var textFieldState by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        backgroundColor = Color.Magenta
    ) {

        Column(
            horizontalAlignment = Alignment
                .CenterHorizontally
        ) {
            TextField(
                value = textFieldState ,
                label={

                    Text(text = "Enter message",color = Color.White,modifier = Modifier
                        .background(Color.Gray)) },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus()
                               //keyboardController?.hide()
                    }),
                onValueChange ={
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )


            OutlinedTextField(
                value = textFieldState,
                onValueChange = {
                    textFieldState = it
                },
                label={
                     Text(text ="Enter message label",
                         style = TextStyle(
                             color = Color.White,
                         )
                     )
                },
                placeholder = {
                    Text(
                        //text = stringResource(id = R.string.phone_placeholder),
                        text = "Enter message placeholder",
                        style = TextStyle(
                           // color = MaterialTheme.colors.primaryVariant,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                        )
                    )
                },

                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
            )

            Spacer(
                modifier = Modifier
                    .height(17.dp)
            )
            Button(
                onClick = {  
                    scope.launch {
                        //keyboardController?.hide()
                        focusManager.clearFocus()
                        if(textFieldState.isNotBlank()){
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = textFieldState
                            )
                        }

                    }
                }
            ) {
                Text(text = "This shows the message form the text field")
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun Test5Preview() {
    JetpackComposePlayGroundTheme{
        Test5()
    }
}
