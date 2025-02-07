package com.example.authuicompose


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Register(onNavigateToLogin:()->Unit,onNavigateToHome:()->Unit){
    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var showData by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.background(Color.Black)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight(0.35f)
                .fillMaxWidth()
        ){
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription ="", modifier = Modifier.clip(
                RoundedCornerShape(topStart = 10.dp, topEnd = 30.dp, bottomStart = 30.dp, bottomEnd = 10.dp)
            ) )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Color.White)
                .padding(20.dp)
        ) {
            Text(
                text = "Create Your Account !!",
                color = colorResource(id = R.color.pink),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Column {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Username") },
                    placeholder = { Text(text = "Enter your username") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = colorResource(id = R.color.pink),
                        cursorColor = Color.Blue,
                        focusedLabelColor = Color.Blue,
                        unfocusedLabelColor = colorResource(id = R.color.pink)
                    ),
                    value = username, onValueChange = {test->
                        username=test
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Email") },
                    placeholder = { Text(text = "Enter your email") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = colorResource(id = R.color.pink),
                        cursorColor = Color.Blue,
                        focusedLabelColor = Color.Blue,
                        unfocusedLabelColor = colorResource(id = R.color.pink)
                    ),
                    value = email, onValueChange = {test->
                        email=test
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Phone") },
                    placeholder = { Text(text = "Enter your Phone") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = colorResource(id = R.color.pink),
                        cursorColor = Color.Blue,
                        focusedLabelColor = Color.Blue,
                        unfocusedLabelColor = colorResource(id = R.color.pink)
                    ),
                    value = phone, onValueChange = {test->
                        phone=test
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),onClick = {
                    showData=true
                }) {
                    Text(text = "Register")

                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Already have an Account?",
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Login",
                        fontSize = 20.sp,
                        color = Color.Blue,
                        modifier = Modifier.clickable {
                            onNavigateToLogin()
                        }

                    )
                }
                if(showData){
                    AlertDialog(onDismissRequest = { showData=false }, title = { Text(text = "Entered Data") }, text = {
                        Column {
                            Text(text = "Username: $username")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Email: $email")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Phone: $phone")
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }, confirmButton = {
                        Button(onClick = {showData=false}) {
                            Text(text = "Ok")
                        }
                    })
                }
//                if(showData){
//                    ModalBottomSheet(onDismissRequest = { showData=false }) {
//                        Column {
//                            Text(text = "Username: $username")
//                            Spacer(modifier = Modifier.height(10.dp))
//                            Text(text = "Email: $email")
//                            Spacer(modifier = Modifier.height(10.dp))
//                            Text(text = "Phone: $phone")
//                            Spacer(modifier = Modifier.height(10.dp))
//                        }
//                    }
//                }
            }
        }
    }
}
