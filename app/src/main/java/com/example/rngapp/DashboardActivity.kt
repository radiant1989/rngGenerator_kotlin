package com.example.rngapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.app.ActivityOptionsCompat

class DashboardActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                CenterAlignedTopAppBar(title = { Text(text = "Casino Predictor" , maxLines = 1,
                    overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(top=30.dp, bottom = 20.dp)) }, colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color(0,185,185,255), titleContentColor = Color.White, actionIconContentColor = Color.White, navigationIconContentColor = Color.White)
                )
                Column(
                    modifier = Modifier.padding(start=40.dp, end=40.dp, top=20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("All Games", modifier=Modifier.padding(top = 80.dp))
                    Spacer(modifier = Modifier.height(30.dp))
                     Row(
                         modifier=Modifier.fillMaxWidth(),
                         horizontalArrangement = Arrangement.SpaceBetween,
                         verticalAlignment = Alignment.CenterVertically
                     ){
                         Image(painterResource(R.drawable.aviator), contentDescription = "Aviator",modifier=Modifier.weight(1f).aspectRatio(1f).clip(MaterialTheme.shapes.large).border(
                             BorderStroke(1.dp, Color.Gray),
                             shape = MaterialTheme.shapes.large
                         ).clickable { displayGames() })
                         Spacer(modifier = Modifier.width(20.dp))
                         Image(painterResource(R.drawable.lucky), contentDescription = "Lucky",modifier=Modifier.weight(1f).aspectRatio(1f).clip(MaterialTheme.shapes.large).border(
                             BorderStroke(1.dp, Color.Gray),
                             shape = MaterialTheme.shapes.large
                         ).clickable { displayGames() })
                     }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(painterResource(R.drawable.jetx), contentDescription = "Jetx",modifier=Modifier.weight(1f).aspectRatio(1f).clip(MaterialTheme.shapes.large).border(
                            BorderStroke(1.dp, Color.Gray),
                            shape = MaterialTheme.shapes.large
                        ).clickable { displayGames() })
                        Spacer(modifier = Modifier.width(20.dp))
                        Image(painterResource(R.drawable.crash), contentDescription = "Crash",modifier=Modifier.weight(1f).aspectRatio(1f).clip(MaterialTheme.shapes.large).border(
                            BorderStroke(1.dp, Color.Gray),
                            shape = MaterialTheme.shapes.large
                        ).clickable { displayGames() })
                    }
                }
            }
        }
    }
    private fun displayGames() {
        // Implement your login logic here
        val intent = Intent(this@DashboardActivity, GamesActivity::class.java)
        val options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.activity_enter, R.anim.activity_exit)
        startActivity(intent, options.toBundle())
    }
}
