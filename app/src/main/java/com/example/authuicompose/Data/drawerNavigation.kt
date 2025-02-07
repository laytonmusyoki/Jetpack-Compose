package com.example.authuicompose.Data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector

data class drawerNavigation(
    val icon:ImageVector,
    val title:String
)


val drawerItems= listOf(
    drawerNavigation(
        icon = Icons.Rounded.Home,
        title = "Home"
    ),drawerNavigation(
        icon = Icons.Rounded.Settings,
        title = "Settings"
    ),drawerNavigation(
        icon = Icons.Rounded.Notifications,
        title = "Notifications"
    ),
)

@Composable
fun Screen(){
    val drawerState= rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope= rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState=drawerState,
        drawerContent = {}) {
        ModalDrawerSheet {
            drawerContent()
        }

    }
}

@Composable
fun drawerContent() {

}
