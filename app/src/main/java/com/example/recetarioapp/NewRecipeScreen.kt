package com.example.recetarioapp

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recetarioapp.ui.theme.RecetarioAppTheme

@Composable
fun NewRecipeScreen() {
    val context = LocalContext.current

    // Campos del formulario
    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var ingredientes by remember { mutableStateOf(TextFieldValue("")) }
    var preparacion by remember { mutableStateOf(TextFieldValue("")) }
    var tiempo by remember { mutableStateOf(TextFieldValue("")) }
    var porciones by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Subir nueva receta",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre de la receta") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = ingredientes,
            onValueChange = { ingredientes = it },
            label = { Text("Ingredientes") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            singleLine = false,
            maxLines = 5
        )

        OutlinedTextField(
            value = preparacion,
            onValueChange = { preparacion = it },
            label = { Text("Preparación") },
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            singleLine = false,
            maxLines = 8
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = tiempo,
                onValueChange = { tiempo = it },
                label = { Text("Tiempo (min)") },
                modifier = Modifier.weight(1f)
            )

            OutlinedTextField(
                value = porciones,
                onValueChange = { porciones = it },
                label = { Text("Porciones") },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (nombre.text.isNotEmpty() && ingredientes.text.isNotEmpty()) {
                    Toast.makeText(context, "Receta subida con éxito", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text("Guardar receta")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewRecipeScreenPreview() {
    RecetarioAppTheme {
        NewRecipeScreen()
    }
}
