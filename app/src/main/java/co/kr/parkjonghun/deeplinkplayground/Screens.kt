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
fun ScreenB() {
    val screenANavController = rememberNavController()

    Column {
        NavHost(
            navController = screenANavController,
            startDestination = "app/screena/a",
        ) {
            composable("app/screena/a") {
                ScreenBA()
            }

            composable(
                route = "app/screena/b/{id}",
                deepLinks = listOf(navDeepLink { uriPattern = "custom://example.com/b/{id}" }),
            ) { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getString("id")
                    ?: throw IllegalStateException("ID not found.")
                ScreenBB(id)
            }

            composable(
                route = "app/screena/c",
                deepLinks = listOf(navDeepLink { uriPattern = "custom://example.com/b" }),
            ) {
                ScreenBC()
            }
        }
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