package com.example.recepies.ui.pdp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.recepies.ui.theme.RecepiesTheme


//class Pdp : ComponentActivity() {
//
//    private val viewModel: PdpViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContent {
////            OneDishCard(id = )
//        }
//    }
//}

@Composable
fun Pdp(id: String, viewModel: PdpViewModel) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberAsyncImagePainter("http://t3.gstatic.com/licensed-image?q=tbn:ANd9GcRfcwEgXgk8f5BjnHpeLQYXYKZdjWDOJ_c5AY78C-mkkN0rkPTG2IduEiHJKeGQae5BhuCliCbJBWxibtn-BYw"),
            contentDescription = null,
            modifier = Modifier
                .testTag("Image")
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        Text(text = "Title", fontSize = 15.sp, textAlign = TextAlign.Center)
        Text(text = "Ingredients", fontSize = 10.sp)
        Text(text = "Description", fontSize = 10.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PdpPreview() {
    RecepiesTheme {
        Pdp(
            id = "0",
            viewModel = PdpViewModel()
        )
    }
}