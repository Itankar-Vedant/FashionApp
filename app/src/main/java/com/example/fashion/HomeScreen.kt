package com.example.fashion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.model3),
            contentDescription = "Fashion Background",
            modifier = Modifier
                .fillMaxSize()
                .blur(0.5.dp),
            contentScale = ContentScale.Crop
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80000000))
        )

        Box(
            modifier = Modifier
                .fillMaxSize(),  //
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "Discover Your Style",
                fontSize = 59.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color(0x40FFFFFF), RoundedCornerShape(16.dp))
                    .padding(16.dp)
            )
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.model2),
                contentDescription = "Stylish Outfits",
                modifier = Modifier
                    .size(155.dp)
                    .offset(x = 25.dp, y = 70.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.model4),
                contentDescription = "Latest Trends",
                modifier = Modifier
                    .size(160.dp)
                    .offset(x = 210.dp, y = 170.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.model5),
                contentDescription = "Casual Looks",
                modifier = Modifier
                    .size(160.dp)
                    .offset(x = (25).dp, y = 520.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.model6),
                contentDescription = "Elegant Styles",
                modifier = Modifier
                    .size(160.dp)
                    .offset(x = 220.dp, y = 580.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .padding(bottom=15.dp)
        ) {
            Button(onClick = { navController.navigate("dash") }) {
                Text(text = "Explore Now", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
