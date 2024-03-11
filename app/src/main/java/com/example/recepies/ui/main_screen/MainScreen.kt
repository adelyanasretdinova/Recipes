package com.example.recepies.ui.main_screen

import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.recepies.model.Dish
import com.example.recepies.ui.theme.RecepiesTheme
import coil.compose.rememberAsyncImagePainter
import com.example.recepies.Screen

//@Composable
//fun MainScreen(navController: NavController) {
//
//    val viewModel: MainScreenViewModel by viewModels()
//
//            MyAppScreen {
//
//            }
//        }

@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel) {

    RecepiesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Column {
                Title(name = "Our Recipes")
                LazyGridContainers(list = viewModel.dishesData(), navController = navController)
            }
        }
    }
}

@Composable
fun Title(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier.padding(15.dp),
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun LazyGridContainers(list: List<Dish>, navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(list.size) { index ->
            Button(
                onClick = {
                    navController.navigate(Screen.PdpScreen.withArgs(list[index].name))
                })
            {
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .size(width = 240.dp, height = 240.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(list[index].image),
                        contentDescription = null,
                        modifier = Modifier
                            .testTag("Image")
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop,
                        alpha = 0.5F
                    )
                    Text(
                        text = list[index].name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyGridContainersPreview() {
    RecepiesTheme {
        LazyGridContainers(
            listOf(
                Dish(image = "image1", name = "Name1"),
                Dish(image = "image2", name = "Name2"),
            ),
            navController = rememberNavController()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecepiesTheme {
        Title("Our Recipes")
    }
}
