package com.example.rngapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.app.ActivityOptionsCompat
import kotlinx.coroutines.launch

class GamesActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                CenterAlignedTopAppBar(title = { Text(text = "Casino Predictor" , maxLines = 1,
                    overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(top=30.dp, bottom = 20.dp)) },
                    actions = {
                        IconButton(onClick = { /* doSomething() */ },modifier = Modifier.padding(top=30.dp, bottom = 20.dp)) {
                            Icon(
                                imageVector = Icons.Filled.Send,
                                contentDescription = "Localized description"
                            )
                        }
                    }, colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color(0,185,185,255), titleContentColor = Color.White, actionIconContentColor = Color.White, navigationIconContentColor = Color.White)
                )
                val imageIds = listOf(
                    R.drawable.win,
                    R.drawable.mstbet,
                    R.drawable.bet,
                    R.drawable.pinup,
                    R.drawable.bw,
                    R.drawable.premier,
                    R.drawable.sportybet,
                    R.drawable.casinozer,
                    R.drawable.xbet,
                    R.drawable.bitcasino,
                    R.drawable.rabet,
                    R.drawable.happywood,
                    R.drawable.betand,
                    R.drawable.bet365,
                    R.drawable.bluechip
                )
                val columnScrollState = rememberScrollState()
                val coroutineScope = rememberCoroutineScope()
                Column(
                    modifier = Modifier
                        .padding(start = 60.dp, end = 60.dp, top = 60.dp)
                        .verticalScroll(columnScrollState)
                        .onRotaryScrollEvent {
                            coroutineScope.launch {
                                columnScrollState.scrollBy(it.verticalScrollPixels)
                            }
                            true
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    imageIds.forEach { resId ->
                        Image(
                            painter = painterResource(resId),
                            contentDescription = "Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp).clip(shape = RoundedCornerShape(20.dp)).clickable { connect() }
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                    Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)) {
                        Text("CONTACT SUPPORT")
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(modifier=Modifier.padding(start=20.dp, end=20.dp, bottom=20.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                        IconButton(onClick = { logout()}) {
                            Icon(
                                imageVector = Icons.Filled.ExitToApp,
                                contentDescription = "Localized description"
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text("LOGOUT", modifier=Modifier.clickable { logout() })
                    }
                }
            }
        }
    }
    private fun logout() {
        val intent = Intent(this@GamesActivity, MainActivity::class.java)
        val options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.activity_enter, R.anim.activity_exit)
        startActivity(intent, options.toBundle())
    }
    private fun connect() {
        val intent = Intent(this@GamesActivity, ConnectActivity::class.java)
        val options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.activity_enter, R.anim.activity_exit)
        startActivity(intent, options.toBundle())
    }
}
