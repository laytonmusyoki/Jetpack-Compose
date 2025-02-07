package com.example.authuicompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.authuicompose.Data.BottomBarNavigation

val items= listOf(
    BottomBarNavigation(
        icon = Icons.Rounded.Home,
        title = "Home"
    ),
    BottomBarNavigation(
        icon = Icons.Rounded.Notifications,
        title = "Notification"
    ),
    BottomBarNavigation(
        icon = Icons.Rounded.Person,
        title = "Account"
    )
)

@Preview
@Composable
fun BottomNavigation(){
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseSurface)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index==0,
                    onClick = {  },
                    label = { Text(text = item.title, color = MaterialTheme.colorScheme.onPrimary)},
                    icon = { Icon(imageVector = item.icon, contentDescription = "icon", tint = MaterialTheme.colorScheme.onBackground) })
            }
        }
    }
}