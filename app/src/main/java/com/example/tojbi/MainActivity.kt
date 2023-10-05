package com.example.tojbi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tojbi.ui.theme.TojbiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TojbiTheme {
                // A surface container using the 'background' color from the theme
               MyApp()
            }
        }
    }
}
@Preview
@Composable
fun MyApp()
{      var jikirCounter= remember {
    mutableStateOf(0)
}
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        color = Color(color = 0xFF36F4F4))
    {
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
          Text("${jikirCounter.value}", style = TextStyle(color = Color(color = 0xFF1B1B1B), fontSize = 35.sp,
              fontWeight = FontWeight.ExtraBold

          ))
             Spacer(modifier = Modifier.height(85.dp))
            CreateCircle(jikirCounter=jikirCounter.value){
                jikirCounter.value=it+1
            }
            ResetButton(jikirCounter = jikirCounter.value) {
                jikirCounter.value = 0
            }

        }

    }
}
//@Preview
@Composable
fun CreateCircle(jikirCounter:Int=0,updatejikirCounter:(Int)->Unit)
{




//    var jikirCounter by remember {
//    mutableStateOf(0)
//}
    Card(modifier = Modifier
        .padding(3.dp)
        .size(120.dp)
        .clickable {
            updatejikirCounter(jikirCounter)
        },
        shape = CircleShape,
    elevation =CardDefaults.cardElevation(4.dp)){
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()) {
            Text(text = "Tap", modifier = Modifier)

        }


    }
}
@Composable
fun ResetButton(jikirCounter: Int, resetCounter: () -> Unit) {
    Button(
        onClick = { resetCounter() },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Reset")
    }
}



//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TojbiTheme {
        MyApp()
    }
}