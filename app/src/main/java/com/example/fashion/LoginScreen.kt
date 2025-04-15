package com.example.fashion

import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fashionapp.screens.DashboardScreen

data class User(val email: String, val password: String)

@Composable
fun LoginScreen(navController: NavController,users: List<User>) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.mod17),
            contentDescription = "Login Page",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .background(Color.White.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
                        .border(2.dp, Color.DarkGray, RoundedCornerShape(16.dp))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Fashion Icon",
                            modifier = Modifier
                                .size(65.dp) //
                        )

                        Text(
                            text = "StyleSnap",
                            fontSize = 57.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(50.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Welcome",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Normal,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(40.dp))


                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = "Email Icon",
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Email Address",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    },
                    isError = emailError.isNotEmpty(),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
                )
                if (emailError.isNotEmpty()) {
                    Text(text = emailError, color = Color.Red, fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.pass),
                                contentDescription = "Password Icon",
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Password",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = passwordError.isNotEmpty(),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
                )
                if (passwordError.isNotEmpty()) {
                    Text(text = passwordError, color = Color.Red, fontSize = 12.sp)
                }


                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(onClick = {
                        emailError = ""
                        passwordError = ""

                        val user = users.find { it.email == email && it.password == password }

                        if (email.isBlank()) {
                            emailError = "Email cannot be blank"
                        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                            emailError = "Invalid email format"
                        } else if (user == null) {
                            emailError = "No account found for this email"
                        }

                        if (password.isBlank()) {
                            passwordError = "Password cannot be blank"
                        } else if (password.length < 8) {
                            passwordError = "Password must be at least 8 characters long"
                        }

                        if (emailError.isEmpty() && passwordError.isEmpty() && user != null) {
                            navController.navigate("home")
                        }
                    }) {
                        Text(text = "Login", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Don't have an account? Create one!",
                        modifier = Modifier.clickable { navController.navigate("create_account") },
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Or sign in with",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))


                Image(
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = "Google Sign-In",
                    modifier = Modifier
                        .size(55.dp)
                        .clickable { }
                )


            }
        }
    }
}



@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var users by remember { mutableStateOf(emptyList<User>()) }

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, users) }
        composable("create_account") { CreateAccountScreen(navController) { newUser ->
            users = users + newUser
        }}
        composable("home") { HomeScreen(navController) }
        composable("dash"){
            DashboardScreen(navController = navController)
        }
        composable("product_screen/{imageId}/{productName}/{productPrice}") { backStackEntry ->
            val imageId = backStackEntry.arguments?.getString("imageId")?.toIntOrNull()
            val productName = backStackEntry.arguments?.getString("productName") ?: ""
            val productPrice = backStackEntry.arguments?.getString("productPrice")?.toFloatOrNull() ?: 0f
            imageId?.let {
                ProductScreen(imageId, productName, productPrice)
            }

    }
}}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    AppNavigation()
}


