package co.kr.parkjonghun.deeplinkplayground

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import co.kr.parkjonghun.deeplinkplayground.ui.theme.DeepLinkPlayGroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data: Uri? = intent?.data
        if (data != null) {
            val path = data.path
            val query = data.query
            Log.d("deepLink", "$path $query")
        }

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
                        navigation(
                            route = "app/screenb",
                            startDestination = "app/screenb/a",
                            deepLinks = listOf(navDeepLink {
                                uriPattern = "custom://example.com/{binfo}"
                            }),
                        ) {
                            composable("app/screenb/a") {
                                ScreenBA()
                            }

                            composable(
                                route = "app/screenb/b/{id}",
                                deepLinks = listOf(navDeepLink {
                                    uriPattern = "custom://example.com/b/{id}"
                                }),
                            ) { navBackStackEntry ->
                                val id = navBackStackEntry.arguments?.getString("id")
                                    ?: throw IllegalStateException("ID not found.")
                                ScreenBB(id)
                            }

                            composable(
                                route = "app/screenb/c",
                                deepLinks = listOf(navDeepLink {
                                    uriPattern = "custom://example.com/b"
                                }),
                            ) {
                                ScreenBC()
                            }
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
