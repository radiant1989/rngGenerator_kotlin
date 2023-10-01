package com.example.rngapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.ui.text.rememberTextMeasurer
import kotlinx.coroutines.delay

class RandomActivity : ComponentActivity() {
    @OptIn(ExperimentalTextApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CenterAlignedTopAppBar(title = { Text(text = "main realtime screen" , maxLines = 1,
                    overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(top=30.dp, bottom = 20.dp)) }, navigationIcon = {
                    IconButton(onClick = { onBackPressed() }, modifier = Modifier.padding(top=30.dp, bottom = 20.dp)) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }, colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color(0,185,185,255), titleContentColor = Color.White, actionIconContentColor = Color.White, navigationIconContentColor = Color.White)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 120.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val textMeasurer = rememberTextMeasurer(cacheSize = 0)

                    val coroutineScope = rememberCoroutineScope()
                    val textValue = remember { mutableStateOf(0) }
                    LaunchedEffect(UInt){
                        coroutineScope.launch {
                            while (true) {
                                delay(2000)
                                textValue.value = (0..10000).random()

                            }
                        }
                    }
                    Image(painterResource(R.drawable.display), contentDescription = "Logo", modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .drawWithContent {
                            drawContent()
                            val formattedText =
                                String.format("%.2fX", ((textValue.value).toFloat() / 100.0))
                            val textLayoutResult = textMeasurer.measure(
                                text = formattedText,
                                style = TextStyle(
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                overflow = TextOverflow.Ellipsis

                            )
                            drawText(
                                textLayoutResult,
                                color = Color.Red,
                                topLeft = Offset(
                                    (size.width - textLayoutResult.size.width) / 2,
                                    (size.height - textLayoutResult.size.height) / 2,
                                )
                            )
                        })
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = { }, colors = ButtonDefaults.buttonColors(containerColor = Color.Green, contentColor = Color.White)) {
                        Text("CONNECTED", color=Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(60.dp))
                    Button(onClick = { }, colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black), modifier = Modifier.padding(start=20.dp, end=20.dp, bottom=20.dp)) {
                        Text("Manage App", color=Color.Gray)
                    }
                }
            }
        }
    }

}
