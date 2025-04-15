package com.example.fashionapp.screens

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fashion.R


@Composable
fun DashboardScreen(navController: NavController) {
    val searchState = remember { mutableStateOf("") }

    // Sample product list with more images
    val products = listOf(
        Product(R.drawable.model8, "Summer Shirt", 55.99f),
        Product(R.drawable.model9, "Sheath Shirt", 30.5f),
        Product(R.drawable.model10, "T-shirt", 47.58f),
        Product(R.drawable.model11, "Maxi", 12.85f),
        Product(R.drawable.mod3, "Blazer", 100f),
        Product(R.drawable.mod4, "Trench Coat", 57.55f),
        Product(R.drawable.mod5, "Hawaiian Shirt", 55.99f),
        Product(R.drawable.mod6, "Jeans", 55.99f),
        Product(R.drawable.model12, "Skirt", 89.65f),
        Product(R.drawable.model13, "Crop Top", 48.96f),
        Product(R.drawable.model14, "Floral Dress", 72.99f),
        Product(R.drawable.model15, "Casual Jacket", 65.00f),
        Product(R.drawable.mod7, "Cardigan", 55.99f),
        Product(R.drawable.mod8, "Polo T-shirts", 55.99f),
        Product(R.drawable.mod9, "Jacket", 55.99f),
        Product(R.drawable.mod10, "Suit", 55.99f),
        Product(R.drawable.model16, "Sporty Pants", 39.99f),
        Product(R.drawable.model17, "Elegant Shirt", 45.50f),
        Product(R.drawable.model18, "Trendy Shorts", 35.75f),
        Product(R.drawable.model19, "Classic Coat", 120.00f),
        Product(R.drawable.model20, "Stylish Tunic", 58.49f)
    )

    // Filtered product list based on search input
    val filteredProducts = products.filter {
        it.name.contains(searchState.value, ignoreCase = true)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            // Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(2.0f)
            ) {
                Text(
                    text = "Experience\nThe Difference",
                    textAlign = TextAlign.Center,
                    fontSize = 29.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp, bottom = 24.dp)
                )

                // Search Bar
                Row(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(24.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(24.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        value = searchState.value,
                        onValueChange = { searchState.value = it },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp),
                        singleLine = true,
                        decorationBox = { innerTextField ->
                            if (searchState.value.isEmpty()) {
                                Text(
                                    text = "Search",
                                    color = Color.Gray,
                                    modifier = Modifier
                                        .weight(1f)
                                        .wrapContentHeight()
                                )
                            } else {
                                innerTextField()
                            }
                        }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "ser",
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .size(30.dp)
                            .background(
                                Color(android.graphics.Color.parseColor("#000000")),
                                RoundedCornerShape(19.dp)
                            )
                            .padding(8.dp)
                            .clickable {
                                // Reset the search state if needed
                                searchState.value = searchState.value.trim()
                            },
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }

            // Product Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(android.graphics.Color.parseColor("#CBEBF7")),
                                Color(android.graphics.Color.parseColor("#F9F7F6"))
                            )
                        )
                    ),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(filteredProducts.size) { index ->
                    val product = filteredProducts[index]
                    ProductView(
                        image = product.image,
                        name = product.name,
                        price = product.price,
                        modifier = Modifier.padding(8.dp),
                        navController = navController,
                        onClick = {
                            navController.navigate("product_screen/${product.image}/${product.name}/${product.price}")


                        }
                    )
                }
            }
        }


    }
}

data class Product(val image: Int, val name: String, val price: Float)

@Composable
fun ProductView(
    image: Int,
    name: String,
    price: Float,
    modifier: Modifier,
    navController: NavController,
    onClick: () -> Unit // New onClick lambda
) {
    ElevatedCard(
        modifier = Modifier
            .clickable { onClick() } // Handle click
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            )
            Text(
                text = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "$${price.format(2)}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun Float.format(digits: Int) = "%.${digits}f".format(this)