package com.example.recepies.ui.main_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.recepies.model.Dish
import com.example.recepies.ui.theme.RecepiesTheme
import coil.compose.rememberAsyncImagePainter

class MainScreen : ComponentActivity() {

    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyAppScreen {
                Column {
                    Title(name = "Our Recipes")
                    LazyGridContainers(list = viewModel.dishesData())
                }
            }
        }
    }
}

@Composable
fun Title(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name",
        modifier = modifier.padding(15.dp),
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun MyAppScreen(content: @Composable () -> Unit) {
    RecepiesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            content()
        }
    }
}

@Composable
fun LazyGridContainers(list: List<Dish>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(list.size) { index ->
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
                Text(text = list[index].name, fontWeight = FontWeight.Bold, fontSize = 25.sp, textAlign = TextAlign.Center)
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
                Dish(image = "image2", name = "Name2")
            )
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
