package co.kr.parkjonghun.deeplinkplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import co.kr.parkjonghun.deeplinkplayground.ui.theme.DeepLinkPlayGroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeepLinkPlayGroundTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "app/screena"
                    ) {
                        composable("app/screena") {
                            ScreenA()
                        }
                        composable(
                            route = "app/screenb",
//                            deepLinks = listOf(navDeepLink {
//                                uriPattern = "https://www.example.com/*"
//                            }),
                        ) {
                            ScreenB()
                        }
                        composable("app/screenc") {
                            ScreenC()
                        }
                        composable("app/screend") {
                            ScreenD()
                        }
                    }
                }
            }
        }
    }
}
