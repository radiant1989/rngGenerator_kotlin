package com.example.rngapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityOptionsCompat

class LoginActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ComposeView(this).apply {
            setContent {
                Column(modifier= Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(start = 60.dp, end = 60.dp, top = 100.dp, bottom = 200.dp), verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    val emailState = remember { mutableStateOf("") }
                    val passwordState = remember { mutableStateOf("") }
                    val isEmailEmptyVisible = remember {mutableStateOf(false)}
                    val isPasswordEmptyVisible = remember {mutableStateOf(false)}
                    val isEmailErrorVisible = remember {mutableStateOf(false)}
                    val isPasswordErrorVisible = remember {mutableStateOf(false)}
                    val isLoading = remember {mutableStateOf(false)}
                    Image(painterResource(R.drawable.logo), contentDescription = "Logo", modifier = Modifier
                        .width(100.dp)
                        .height(100.dp))
                    Spacer(modifier = Modifier.height(50.dp))
                    OutlinedTextField(
                        value = emailState.value,
                        onValueChange = { emailState.value = it },
                        label = { Text("Email") },
                        isError = isEmailErrorVisible.value || isEmailEmptyVisible.value,
                        colors = TextFieldDefaults.textFieldColors(errorIndicatorColor = Color.Red),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Email
                        ),
                        modifier=Modifier.fillMaxWidth()
                    )
                    if (isEmailEmptyVisible.value) {
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "This field is required",
                            color = Color.Red,
                            style = TextStyle(fontSize = 12.sp)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(
                        value = passwordState.value,
                        onValueChange = { passwordState.value = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        isError = isPasswordErrorVisible.value || isPasswordEmptyVisible.value,
                        colors = TextFieldDefaults.textFieldColors(errorIndicatorColor = Color.Red),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password
                        ),
                        modifier=Modifier.fillMaxWidth()
                    )
                    if (isPasswordEmptyVisible.value) {
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "This field is required",
                            color = Color.Red,
                            style = TextStyle(fontSize = 12.sp)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        onClick = {
                            isEmailEmptyVisible.value = emailState.value.isEmpty()
                            isPasswordEmptyVisible.value = passwordState.value.isEmpty()
                            isEmailErrorVisible.value = emailState.value != "casino@p.com"
                            isPasswordErrorVisible.value = passwordState.value != "casino"
                            if (isEmailErrorVisible.value || isPasswordErrorVisible.value || isEmailEmptyVisible.value || isPasswordEmptyVisible.value){
                                return@Button
                            }
                            else {
                                isLoading.value = true
                                performLogin(emailState.value, passwordState.value)
                                finish()
                            }
                          },
                        content = { if (isLoading.value){
                            CircularProgressIndicator(modifier = Modifier
                                .width(20.dp)
                                .height(20.dp),color = Color.White)
                        }else{Text("Log in")} },
                        modifier = Modifier.fillMaxWidth(),
                        colors=ButtonDefaults.buttonColors(containerColor = Color(0,185,185,255), contentColor = Color.White)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "CREATE AN ACCOUNT",
                        style= TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
        }.also {
            setContentView(it)
        }
    }

    private fun performLogin(email: String, password: String) {
        // Implement your login logic here
        val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
        val options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.activity_enter, R.anim.activity_exit)
        startActivity(intent, options.toBundle())
    }
}