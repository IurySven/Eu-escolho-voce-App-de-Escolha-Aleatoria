package com.example.meuapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meuapp.ui.theme.MeuAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Terror(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Filmes de Terror", fontSize = 30.sp, fontWeight = Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fundo1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = (-50).dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "O Que Vamos Assistir?",
                        fontSize = 30.sp,
                        fontWeight = Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(65.dp))

                    var sorteio by remember { mutableIntStateOf(1) }
                    val imagescolha = if (sorteio == 1) {
                        R.drawable.terror1
                    } else {
                        when (sorteio) {
                            2 -> R.drawable.terror2
                            3 -> R.drawable.terror3
                            4 -> R.drawable.terror4
                            5 -> R.drawable.terror5
                            6 -> R.drawable.terror6
                            7 -> R.drawable.terror7
                            8 -> R.drawable.terror8
                            9 -> R.drawable.terror9
                            10 -> R.drawable.terror10
                            else -> R.drawable.terror11
                        }
                    }
                    val textEscolha = when (sorteio) {
                        1 -> ""
                        2 -> "It A Coisa"
                        3 -> "Corra"
                        4 -> "Invocação do Mal"
                        5 -> "Halloween"
                        6 -> "O Iluminado"
                        7 -> "O Exosrcista"
                        8 -> "Pânico"
                        9 -> "A Bruxa de Blair"
                        10 -> "O Telefone Preto"
                        else -> "Jogos Mortais X"
                    }
                    val imageModifier = if (sorteio == 1) {
                        Modifier.size(width = 250.dp, height = 250.dp)
                    } else {
                        Modifier
                            .size(width = 170.dp, height = 250.dp)
                            .border(
                                width = 3.dp,
                                color = Color.White,
                            )
                    }
                    Image(
                        painter = painterResource(imagescolha),
                        contentDescription = null,
                        modifier = imageModifier,
                    )

                        if (sorteio != 1) {
                        Box{
                            Text(
                                text = textEscolha,
                                fontSize = 35.sp,
                                fontWeight = Bold,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 20.dp)
                            )
                            Text(
                                text = textEscolha,
                                fontSize = 35.sp,
                                color = Color(0xFFF54558),
                                modifier = Modifier.padding(top = 20.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(65.dp))
                    Button(
                        onClick = { sorteio = (2..11).random() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF54558),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .size(width = 180.dp, height = 60.dp)
                            .border(
                                width = 2.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(30.dp)
                            )
                    ) {
                        Text(
                            text = "Escolher",
                            fontSize = 30.sp
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TerrorPreview() {
    MeuAppTheme {
        Terror(navController = rememberNavController())
    }
}