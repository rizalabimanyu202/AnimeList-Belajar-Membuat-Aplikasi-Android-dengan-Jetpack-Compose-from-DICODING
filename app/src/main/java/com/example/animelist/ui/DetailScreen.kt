package com.example.animelist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animelist.R
import com.example.animelist.data.AnimeData

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    id: Long
) {
    val anime = AnimeData.anime.find { it.id == id.toInt() }
    val listState = rememberLazyListState()
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(state = listState) {
            items (1){ index ->
                Column{
                    Image(
                        painter = painterResource(anime?.photoUrl ?:R.drawable.logo),
                        contentDescription = "Logo Jetpack Compose",
                        modifier = Modifier.fillMaxWidth()
                            .background(color = Color.Black)
                    )
                    Text(
                        text = anime?.name ?: "Unknown",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
                    )
                    Text(
                        text = anime?.rating ?: "Unknown",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp)
                    )
                    Text(
                        text = anime?.description ?: "Unknown",
                        modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)
                    )
                }
            }
        }
    }
}