package com.example.rngapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0, 185, 185, 255))
                        .padding(start = 40.dp, end = 40.dp, top = 40.dp, bottom = 120.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var isLoading by mutableStateOf(false)
                    Text(
                        text = "Casino Predictor",
                        style= TextStyle(
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(R.drawable.logo_white), contentDescription = "Logo", modifier = Modifier
                        .width(100.dp)
                        .height(100.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = {
                            val intent = Intent(this@MainActivity, LoginActivity::class.java)
                            isLoading = true
                            startActivity(intent)
                            finish();
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, start = 80.dp, end = 80.dp),
                        colors = ButtonDefaults.buttonColors(contentColor = Color(0,185,185,255), containerColor = Color.White),
                        content = {
                            if (isLoading) CircularProgressIndicator(modifier = Modifier
                                .width(20.dp)
                                .height(20.dp),color = Color(0,185,185,255))
                            else Text("Next")
                        }
                    )
                }
            }
        }
    }
}