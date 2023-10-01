package com.example.rngapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.app.ActivityOptionsCompat

class ConnectActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                CenterAlignedTopAppBar(title = { Text(text = "Casino Predictor" , maxLines = 1,
                    overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(top=30.dp, bottom = 20.dp)) },
                    navigationIcon = {
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
                        .padding(start = 20.dp, end = 20.dp, top = 120.dp).fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(R.drawable.logo), contentDescription = "Logo", modifier = Modifier
                        .width(100.dp)
                        .height(100.dp))
                    Spacer(modifier = Modifier.height(100.dp))
                    Button(onClick = { displayRandom()}, colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow, contentColor = Color.White)) {
                        Text("CONNECT", color=Color.Gray)
                    }

                }
            }
        }
    }
    private fun displayRandom() {
        // Implement your login logic here
        val intent = Intent(this@ConnectActivity, RandomActivity::class.java)
        val options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.activity_enter, R.anim.activity_exit)
        startActivity(intent, options.toBundle())
    }
}
