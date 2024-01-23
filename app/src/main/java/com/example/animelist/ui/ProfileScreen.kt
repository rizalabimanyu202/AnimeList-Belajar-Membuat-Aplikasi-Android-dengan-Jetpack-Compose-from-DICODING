package com.example.animelist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animelist.R

@Composable
@Preview(showBackground = true)
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box {
            Column{
                Row{
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = "Logo Jetpack Compose",
                        modifier = Modifier
                            .width(200.dp)
                            .clip(RoundedCornerShape(0.dp))
                    )
                    Image(
                        painter = painterResource(R.drawable.me),
                        contentDescription = "Logo Jetpack Compose",
                        modifier = Modifier
                            .padding(25.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(100.dp)),
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                ){
                    Text(
                        text = "Rizal Abimanyu",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(
                        text = "rizalabimanyu2002@gmail.com",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(
                        text = "Welcome to My App is Anime List where this app is recommmendation anime by me",
                        color = Color.Red,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                }
            }
        }
    }
}