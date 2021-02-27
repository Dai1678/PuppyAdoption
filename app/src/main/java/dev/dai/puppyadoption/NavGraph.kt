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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.dai.puppyadoption.MainDestination.KEY_PUPPY
import dev.dai.puppyadoption.data.Puppy

object MainDestination {
    const val PUPPY_LIST_ROUTE = "puppy_list"
    const val PUPPY_DETAIL_ROUTE = "puppy_detail"
    const val KEY_PUPPY = "puppy"
}

@Composable
fun NavGraph(startDestination: String = MainDestination.PUPPY_LIST_ROUTE) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(navController = navController, startDestination = startDestination) {
        composable(MainDestination.PUPPY_LIST_ROUTE) {
            PuppyListScreen(actions.actionToPuppyDetail)
        }
        composable(MainDestination.PUPPY_DETAIL_ROUTE) {
            val puppy =
                navController.previousBackStackEntry?.arguments?.getParcelable<Puppy>(KEY_PUPPY)
                    ?: throw IllegalArgumentException()
            PuppyDetailScreen(puppy)
        }
    }
}

class MainActions(navController: NavController) {
    val actionToPuppyDetail: (Puppy) -> Unit = { puppy ->
        navController.currentBackStackEntry?.arguments?.putParcelable(KEY_PUPPY, puppy)
        navController.navigate(MainDestination.PUPPY_DETAIL_ROUTE)
    }
}
