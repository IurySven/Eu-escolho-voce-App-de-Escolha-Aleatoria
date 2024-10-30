package com.example.meuapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meuapp.ui.theme.MeuAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeuAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { Home(navController) }
                    composable("terror") { Terror(navController) }
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = (-50).dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "O Que Vamos Decidir?",
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontWeight = Bold,
                    )
                    Spacer(modifier = Modifier.height(65.dp))
                    Button(
                        onClick = { navController.navigate("terror") },
                        colors = ButtonDefaults.buttonColors(
                        ),
                        modifier = Modifier
                            .size(width = 130.dp, height = 60.dp)
                            .border(
                                width = 2.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(30.dp)
                            ),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Text(
                            text = "Filmes",
                            textAlign = TextAlign.Center,
                            fontSize = 25.sp,
                        )
                    }
                }
            }
        }
    )
}
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    MeuAppTheme {
        Home(navController = rememberNavController())
    }
}