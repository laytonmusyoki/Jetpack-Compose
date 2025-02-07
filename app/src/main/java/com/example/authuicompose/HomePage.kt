package com.example.authuicompose

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource // Assuming you have icons in resources
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var expanded by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(modifier = Modifier
                        .padding(start = 15.dp, end = 10.dp)
                        .size(28.dp),onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                title = { Text(text = "Home", color = Color.White) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF007AFF) // Example blue color
                )
            )
        },
        bottomBar = {
            BottomAppBar {
                BottomNavigation()
            }
        }
    ) { innerPadding ->
        var names = listOf(
            Names("Layton","Musyoki"),
            Names("Benjamin","Musyoki"),
            Names("David","Musyoki"),
            Names("Nelson","Musyoki"),
            Names("Tobias","Musyoki"),
        )
        var isOpen by remember {
            mutableStateOf(false)
        }
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
                .clip(RoundedCornerShape(10.dp))
        ) {
            items (names){name->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp, horizontal = 15.dp)
                        .background(Color.White)
                        .height(if (isOpen) 100.dp else 50.dp)
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
//
                    ) {
                        Text(text = name.fname)
                        Text(text = "0")
                        if (isOpen){
                            Text(text = name.lname)
                        }
                    }
                    Button(onClick = {
                        if (isOpen){
                            isOpen=false
                        }
                        else{
                            isOpen=true
                        }
                    }) {
                        if(isOpen)androidx.compose.material3.Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "" ) else androidx.compose.material3.Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "" )
                    }
                }
            }
        }
    }
}

