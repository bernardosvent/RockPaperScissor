package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // Envolvemos o jogo em um Box para aplicar o innerPadding do Scaffold.
                    // Isso garante que o jogo não fique escondido atrás da barra de status do celular.
                    Box(modifier = Modifier.padding(innerPadding)) {
                        JogoPedraPapelTesoura()
                    }

                }
            }
        }
    }
}
@Composable
fun JogoPedraPapelTesoura() {
    // Escopo de coroutine para rodar a animação sem travar a tela
    val scope = rememberCoroutineScope()

    // Lista de referências das imagens (lembre-se de adicionar pedra, papel e tesoura no res/drawable)
    val imagens = listOf(
        R.drawable.pedra,
        R.drawable.papel,
        R.drawable.tesoura
    )

    // Estados do aplicativo
    var imagemAtual by remember { mutableIntStateOf(R.drawable.pedra) } // Imagem que aparece na tela
    var isSorteando by remember { mutableStateOf(false) } // Controla se o sorteio está acontecendo

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Título
        Text(
            text = "Pedra, Papel e Tesoura",
            fontSize = 28.sp
        )

        // Imagem central que vai alternar e mostrar o resultado
        Image(
            painter = painterResource(id = imagemAtual),
            contentDescription = "Resultado da Jogada",
            modifier = Modifier.size(200.dp)
        )

        // Botão Jogar
        Button(
            onClick = {
                // Só permite clicar se não estiver sorteando no momento
                if (!isSorteando) {
                    scope.launch {
                        isSorteando = true

                        // Animação de Sorteio (Alternando imagens rapidamente)
                        val tempoSorteio = 2000L // 2 segundos totais de animação
                        val intervaloPausa = 100L // Troca a imagem a cada 0.1 segundo
                        var tempoDecorrido = 0L

                        while (tempoDecorrido < tempoSorteio) {
                            imagemAtual = imagens.random() // Escolhe uma imagem aleatória
                            delay(intervaloPausa)          // Pausa a coroutine brevemente
                            tempoDecorrido += intervaloPausa
                        }

                        // Resultado Final
                        imagemAtual = imagens.random()
                        isSorteando = false
                    }
                }
            },
            // Desabilita o botão enquanto a animação ocorre
            enabled = !isSorteando,
            modifier = Modifier.size(width = 200.dp, height = 60.dp)
        ) {
            Text(text = "JOGAR", fontSize = 20.sp)
        }
    }
}

