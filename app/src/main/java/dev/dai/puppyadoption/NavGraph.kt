package dev.dai.puppyadoption

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

object MainDestination {
    const val PUPPY_LIST_ROUTE = "puppy_list"
    const val PUPPY_DETAIL_ROUTE = "puppy_detail"
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
            PuppyDetailScreen()
        }
    }
}

class MainActions(navController: NavController) {
    val actionToPuppyDetail: () -> Unit = {
        navController.navigate(MainDestination.PUPPY_DETAIL_ROUTE)
    }
}
