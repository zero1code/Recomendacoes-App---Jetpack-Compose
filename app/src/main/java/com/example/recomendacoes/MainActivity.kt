package com.example.recomendacoes

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recomendacoes.ui.RecomendacoesApp
import com.example.recomendacoes.ui.theme.RecomendacoesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecomendacoesTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    RecomendacoesApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecomendacoesAppLightCompactPreview() {
    RecomendacoesTheme {
        RecomendacoesApp()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RecomendacoesAppDarkCompactPreview() {
    RecomendacoesTheme {
        RecomendacoesApp()
    }
}