
package com.example.flora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.R
import com.example.flora.data.Datasource
import com.example.flora.model.Flora
import com.example.flora.ui.theme.FlorasTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configuración de la IU con Jetpack Compose
        setContent {
            FlorasTheme { // Aplicar el tema personalizado
                // Contenedor principal de la IU
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa todo el espacio disponible
                    color = MaterialTheme.colorScheme.background // Color de fondo del tema
                ) {
                    FlorasApp() // Llama a la función que representa la IU de la aplicación
                }
            }
        }
    }
}

@Composable
fun FlorasApp() {
    FloraList( // Llama a la función que muestra la lista de elementos Flora
        floraList = Datasource().loadFloras(), // Carga la lista de datos de Flora
    )
}

@Composable
fun FloraList(floraList: List<Flora>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) { // Columna que permite el reciclaje de elementos
        items(floraList) { flora -> // Muestra cada elemento de la lista
            FloraCard( // Muestra una tarjeta para cada elemento Flora
                flora = flora, // Elemento Flora actual
                modifier = Modifier.padding(8.dp) // Espaciado entre las tarjetas
            )
        }
    }
}

@Composable
fun FloraCard(flora: Flora, modifier: Modifier = Modifier) {
    Card(modifier = modifier) { // Tarjeta que contiene la imagen y el texto de Flora
        Column {
            Image(
                painter = painterResource(flora.imageResourceId), // Carga la imagen de recursos
                contentDescription = stringResource(flora.stringResourceId), // Descripción de la imagen
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp), // Tamaño de la imagen
                contentScale = ContentScale.Crop // Escala de contenido de la imagen
            )
            Text(
                text = LocalContext.current.getString(flora.stringResourceId), // Texto de Flora
                modifier = Modifier.padding(16.dp), // Espaciado del texto
                style = MaterialTheme.typography.headlineSmall // Estilo de texto
            )
        }
    }
}

@Preview
@Composable
private fun FloraCardPreview() {
    FloraCard(Flora (R.string.flora1, R.drawable.image1)) // Vista previa de la tarjeta Flora
}
