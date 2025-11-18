package com.learn.learnviewmodel.presentation.ui.screens.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.learn.learnviewmodel.R

@Composable
fun HomeScreen(navController: NavHostController) {
    ProfileScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        containerColor = Color(0xFFF3F4FA),
        topBar = {
            AppBar()
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column {
                Banner()
                ProfileCard()
            }
            BasicInformation()
        }
    }
}

@Preview
@Composable
fun PreviewJobDetailsScreen() {
    ProfileScreen()
}

@Composable
fun ProfileCard() {
    Box(
        modifier = Modifier.background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.avatar_male),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
            )
            Text(
                text = "Juan Sebastian Dela Cruz",
                fontSize = 16.sp,
                fontWeight = FontWeight.W700,
                color = Color(0XFF202325)
            )
        }
    }

}

@Composable
fun BasicInformation() {
    Column(
    ) {
        CommonInfoWSwitch(
            title = "Tech Status",
            subtitle = "ON"
        )
        CommonInfoItem(
            title = "Email Address",
            subtitle = "tech@email.com"
        )
        CommonInfoItem(
            title = "Email Address",
            subtitle = "Add Contact Number",
            isButton = true
        )
        CommonInfoItem(
            title = "Address",
            subtitle = "401 Hercules Village, Makati, 1209 Metro Manila",
            hasIcon = true
        )
    }
}

@Composable
fun Banner() {
    Row(
        modifier = Modifier
            .background(Color(0XFFD1E4FD))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_check),
            contentDescription = null
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                "Complete your profile",
                fontSize = 14.sp,
                fontWeight = FontWeight.W700,
                color = Color(0XFF296293)
            )
            Text(
                "You're almost done! Please complete your technician profile now to start receiving jobs.",
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = Color(0XFF296293)
            )
        }
    }
}

@Composable
fun CommonInfoItem(
    title: String,
    subtitle: String,
    hasIcon : Boolean = false,
    icon : Int = R.drawable.ic_check,
    isButton: Boolean = false,
    modifier : Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(BorderStroke(1.dp, Color(0XFFDCDFE7)))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // ⭐ Text wraps properly and never hides the icon
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(title, color = Color(0XFF74777E))

                if (isButton) {
                    CommonOutlineButton(text = "+ Add Contact Number")
                } else {
                    Text(
                        subtitle,
                        maxLines = Int.MAX_VALUE,
                        overflow = TextOverflow.Visible
                    )
                }
            }

            if (hasIcon) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = null
                )
            }
        }
    }
}


@Composable
fun CommonOutlineButton(text: String) {
    OutlinedButton(
        onClick = { },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0XFF285EA6)),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color(0XFF285EA6)
        )
    ) {
        Text(text)
    }
}

@Composable
fun CommonInfoWSwitch(
    title: String,
    subtitle: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(
                border = BorderStroke(1.dp, Color(0XFFDCDFE7)),
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(title, color = Color(0XFF74777E))

                Box(
                    modifier = Modifier
                        .background(Color(0XFFD4F1C7))
                        .padding(vertical = 3.dp, horizontal = 9.dp)
                        .clip(RoundedCornerShape(5.dp))
                ) {
                    Text(subtitle)
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Switch(checked = true, onCheckedChange = {})
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
                Text("Profile")
            }
        }
    )
}