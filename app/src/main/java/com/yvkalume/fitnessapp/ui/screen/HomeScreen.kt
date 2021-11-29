package com.yvkalume.fitnessapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yvkalume.fitnessapp.R
import com.yvkalume.fitnessapp.ui.theme.*
import compose.icons.AllIcons
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Running

@Composable
fun HomeScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            HeaderItem()
        }

        item {
            TextHeaderItem(text = "Muscle group exercises")
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(24.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(10) {
                        ExerciseItem(icon = {
                            Icon(
                                modifier = Modifier.size(40.dp),
                                imageVector = FontAwesomeIcons.Solid.Running,
                                contentDescription = null
                            )
                        }, text = {
                            Text(text = "Running")
                        })
                    }
                })
        }

        item {
            TextHeaderItem(text = "Stretching Exercises")
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(24.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(10) {
                        ExerciseItem(icon = {
                            Icon(
                                modifier = Modifier.size(40.dp),
                                imageVector = FontAwesomeIcons.Solid.Running,
                                contentDescription = null
                            )
                        }, text = {
                            Text(text = "Running")
                        })
                    }
                })
        }


        item {
            TextHeaderItem(text = "Training programs")
        }

        items(4) {
            ProgramItem()
        }

    }
}

@Composable
fun HeaderItem() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(bottom = 12.dp),
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_header_img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Choose your workout!",
                    color = White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(0.6f)
                )
                Spacer(modifier = Modifier.weight(0.4f))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Your regular weekly exercise routine should include both aerobic exercise...",
                    color = Gray300,
                    modifier = Modifier.weight(0.65f)
                )
                Spacer(modifier = Modifier.weight(0.35f))
            }
        }
    }
}

@Composable
fun TextHeaderItem(text: String) {
    Text(
        text = text, fontSize = 16.sp, color = White, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    )
}

@Composable
fun ExerciseItem(icon: @Composable () -> Unit, text: @Composable () -> Unit) {
    Surface(
        shape = RoundedCornerShape(topEnd = 16.dp, bottomStart = 16.dp),
        modifier = Modifier.size(100.dp),
        color = Black500,
        contentColor = White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            icon()
            Spacer(modifier = Modifier.height(2.dp))
            text()
        }
    }
}

@Composable
fun ProgramItem() {
    Row(
        modifier = Modifier
            .height(100.dp)
            .padding(horizontal = 24.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.weight(0.4f),
            shape = RoundedCornerShape(16.dp),
            elevation = 4.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_work_out),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = BlackTransparent, blendMode = BlendMode.Overlay),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(modifier = Modifier.fillMaxSize()) {
                Surface(modifier = Modifier.size(33.dp).align(Alignment.TopEnd).padding(8.dp), color = White, shape = CircleShape) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.fillMaxSize().padding(3.dp))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = "Workout", color = Gray300, fontWeight = FontWeight.SemiBold)
                    Text(text = "45:15", color = Gray300)
                }
            }
        }
        Spacer(modifier = Modifier.weight(0.03f))
        Text(
            text = "Highly trained athletes often train according to the \"hard-easy\" pr...",
            color = Black500,
            modifier = Modifier.weight(0.57f)
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}