package com.example.recepies.ui.pdp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import coil.compose.rememberAsyncImagePainter
import com.example.recepies.model.Dish
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
                    viewModel.loadOneDish(idProduct)
                    OneDishCard(dish = viewModel.oneDishData()!!)}
                }

            }
        }
    }

@Composable
fun OneDishCard(dish: Dish) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = rememberAsyncImagePainter(dish.image),
            contentDescription = "dishImage",
            modifier = Modifier
                .testTag("Image")
                .fillMaxWidth()
//                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.TopCenter),
        contentScale = ContentScale.FillWidth,
        alpha = 0.5F
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter),
        ) {

            Text(text = dish.name, fontSize = 20.sp)
            Text(text = dish.ingredients, fontSize = 10.sp)
            Text(text = dish.description, fontSize = 10.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OneDishCardPreview() {
        OneDishCard(dish = Dish(name = "Name1", ingredients = "Der Standardteil von Lorem Ipsum, genutzt seit 1500, ist reproduziert für die, die es interessiert. Sektion 1.10.32 und 1.10.33 von \"de Finibus Bonorum et Malroum\" von Cicero sind auch reproduziert in ihrer Originalform, abgeleitet von der Englischen Version aus von 1914 (H. Rackham)", description = "Glauben oder nicht glauben, Lorem Ipsum ist nicht nur ein zufälliger Text. Er hat Wurzeln aus der Lateinischen Literatur von 45 v. Chr, was ihn über 2000 Jahre alt macht. Richar McClintock, ein Lateinprofessor des Hampden-Sydney College in Virgnia untersuche einige undeutliche Worte, \"consectetur\", einer Lorem Ipsum Passage und fand eine unwiederlegbare Quelle. Lorem Ipsum komm aus der Sektion 1.10.32 und 1.10.33 des \"de Finibus Bonorum et Malorum\" (Die Extreme von Gut und Böse) von Cicero, geschrieben 45 v. Chr. Dieses Buch ist Abhandlung der Ethiktheorien, sehr bekannt wärend der Renaissance. Die erste Zeile des Lorem Ipsum, \"Lorem ipsum dolor sit amet...\", kommt aus einer Zeile der Sektion 1.10.32.", image = "http://t3.gstatic.com/licensed-image?q=tbn:ANd9GcRfcwEgXgk8f5BjnHpeLQYXYKZdjWDOJ_c5AY78C-mkkN0rkPTG2IduEiHJKeGQae5BhuCliCbJBWxibtn-BYw"))
}