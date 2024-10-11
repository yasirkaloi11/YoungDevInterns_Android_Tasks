package com.example.basiccalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.remember as remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculator()
        }
    }
}

@Composable
fun Calculator() {

    var firstvalue by remember {
        mutableStateOf("")
    }
    var secondvalue by remember {
        mutableStateOf("")
    }

val double1=firstvalue.toDoubleOrNull() ?: 0.0
    val double2=secondvalue.toDoubleOrNull() ?: 0.0
    val addition=double1+double2
    val subtraction=double1-double2
    val divion=double1/double2
    val multiplication=double1*double2


    var result by remember {
        mutableStateOf("")
    }
    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally ) {
        
        Text(text = "Basic Calculator", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(200.dp))
        
        
        TextField(value = firstvalue, onValueChange ={
            firstvalue=it
        } ,
            maxLines = 1,
            label = { Text(text = "Enter First Value")})
        Spacer(modifier = Modifier.height(10.dp))

        TextField(value = secondvalue, onValueChange ={
            secondvalue=it
        },
            maxLines = 1,
            label = { Text(text = "Enter Second Value")})
        
        Spacer(modifier = Modifier.height(46.dp))




        Row (modifier= Modifier
            .fillMaxWidth()
            .padding(5.dp)
            ,
            horizontalArrangement = Arrangement.SpaceAround){
            Button(onClick = {
                result = addition.toString()
            }
            ) {
                Text(text = "+", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            }
            Button(onClick = {
                   result=subtraction.toString()
            }) {
                Text(text = "-", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            }
            Button(onClick = {
                  result=divion.toString()
            }) {
                Text(text = "/", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            }
            Button(onClick = {
                result=multiplication.toString()

            }) {
                Text(text = "x", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            }

        }
      Spacer(modifier = Modifier.height(32.dp))

        Text(text ="The Result Is $result", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color.Blue)


    }

}

