package com.yvkalume.fitnessapp.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yvkalume.fitnessapp.R
import com.yvkalume.fitnessapp.ui.theme.Black700
import com.yvkalume.fitnessapp.ui.theme.Blue700
import com.yvkalume.fitnessapp.ui.theme.Gray700
import com.yvkalume.fitnessapp.ui.theme.White
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Google

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .size(300.dp),
            shape = RoundedCornerShape(
                topStart = 24.dp,
                topEnd = 40.dp,
                bottomEnd = 24.dp,
                bottomStart = 40.dp
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.fitness_welcome_img),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = "Welcome to Fitness Home",
            fontSize = 28.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
        )

        Text(
            text = "Plan your train with app",
            color = Gray700,
            textAlign = TextAlign.Center,
        )

        LoginButton(
            onClick = { navController.navigate("home") },
            borderStroke = BorderStroke(1.dp, color = White),
            backgroundColor = Black700, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_google_logo), tint = Color.Unspecified, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Login with Gmail", color = White, style = MaterialTheme.typography.button)
        }

        LoginButton(
            onClick = { navController.navigate("home") },
            backgroundColor = Blue700,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(imageVector = Icons.Default.AccountCircle, tint = White, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Log In", color = White, style = MaterialTheme.typography.button)
        }

        SignUpCta()
    }
}

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    borderStroke: BorderStroke? = null,
    backgroundColor: Color,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    OutlinedButton(
        border = borderStroke,
        onClick = { onClick() },
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = backgroundColor),
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                content()
            }
        }
    )
}

@Composable
fun SignUpCta() {
    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 32.dp, vertical = 8.dp),
        color = Gray700,
        textAlign = TextAlign.Center,
        text = buildAnnotatedString {
            append("Not a member ? ")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = White,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Sign Up")
            }
        }
    )
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}