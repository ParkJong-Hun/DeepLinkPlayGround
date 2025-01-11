package co.kr.parkjonghun.deeplinkplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink

@Composable
fun ScreenA() {
    Column {
        Text("ScreenA")
    }
}

@Composable
fun ScreenBA() {
    Text("ScreenBA")
}

@Composable
fun ScreenBB(
    id: String,
) {
    Text("ScreenBB $id")
}

@Composable
fun ScreenBC() {
    Text("ScreenBC")
}

@Composable
fun ScreenC() {
    Column {
        Text("ScreenC")
    }
}

@Composable
fun ScreenD() {
    Column {
        Text("ScreenD")
    }
}