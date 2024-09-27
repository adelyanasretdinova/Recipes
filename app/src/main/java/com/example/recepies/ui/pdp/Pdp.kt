package com.example.recepies.ui.pdp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.recepies.R
import com.example.recepies.model.Dish
import com.example.recepies.ui.main_screen.LazyGridContainers
import com.example.recepies.ui.main_screen.MyAppScreen
import com.example.recepies.ui.main_screen.Title
import com.example.recepies.ui.theme.RecepiesTheme


class Pdp :  Fragment() {

//    private val viewModel: PdpViewModel by viewModels()
    private lateinit var viewModel: PdpViewModel
    companion object {
        const val PRODUCT_ID_ARG = "id"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val idProduct = arguments?.getString(PRODUCT_ID_ARG)

                if (idProduct != null) {
                    OneDishCard(id = idProduct)
                }
            }
        }
    }
}

@Composable
fun OneDishCard(id: String) {
    Box(
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
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterStart),
            contentScale = ContentScale.FillWidth,
            alpha = 0.5F
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
        ) {
            Text(text = "Title", fontSize = 20.sp)
            Text(text = "Ingredients", fontSize = 10.sp)
            Text(text = "Description", fontSize = 10.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OneDishCardPreview() {
        OneDishCard(id = "1"
        )
}