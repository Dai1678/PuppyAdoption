/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.dai.puppyadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.dai.puppyadoption.data.Puppy
import dev.dai.puppyadoption.ui.theme.MyTheme

private const val PUPPY_LIST_ROUTE = "puppy_list"
private const val PUPPY_DETAIL_ROUTE = "puppy_detail"
private const val KEY_PUPPY_ID = "puppy_id"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                AppContent()
            }
        }
    }

    @Composable
    fun AppContent(startDestination: String = PUPPY_LIST_ROUTE) {
        val navController = rememberNavController()

        val actions = remember(navController) { AppActions(navController) }
        NavHost(navController = navController, startDestination = startDestination) {
            composable(PUPPY_LIST_ROUTE) {
                PuppyListScreen(actions.actionToPuppyDetail)
            }
            composable(
                route = "$PUPPY_DETAIL_ROUTE/{$KEY_PUPPY_ID}",
                arguments = listOf(navArgument(KEY_PUPPY_ID) { type = NavType.IntType }),
            ) { navBackStackEntry ->
                val puppyId = requireNotNull(navBackStackEntry.arguments?.getInt(KEY_PUPPY_ID))
                PuppyDetailScreen(puppyId)
            }
        }
    }
}

private class AppActions(navController: NavController) {
    val actionToPuppyDetail: (Puppy) -> Unit = { puppy ->
        navController.navigate("$PUPPY_DETAIL_ROUTE/${puppy.id}")
    }
}
