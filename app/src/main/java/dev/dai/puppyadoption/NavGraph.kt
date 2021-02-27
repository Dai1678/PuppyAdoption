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
