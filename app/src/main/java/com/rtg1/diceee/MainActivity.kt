package com.rtg1.diceee

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rtg1.diceee.ui.theme.DiceeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceeeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceeeApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DiceeeApp(modifier: Modifier = Modifier){

    var currentValue by remember {
      mutableStateOf(1)
    }


    val imagePainter = painterResource(id =when(currentValue){
        1-> R.drawable.dice_1
        2-> R.drawable.dice_2
        3-> R.drawable.dice_3
        4-> R.drawable.dice_4
        5-> R.drawable.dice_5
        else -> R.drawable.dice_6
    })


    Scaffold {
        Column(verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = imagePainter, contentDescription = "Dice image wiht value: $currentValue")
            Spacer(modifier = modifier.height(32.dp))
            Button(onClick = {
                currentValue = (1..6).random()
            }) {
                Text(text = stringResource(R.string.roll_dice))
            }
        }
    }
}



