package com.learn.learnviewmodel.presentation.ui.screens.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Column {
                    Banner()
                    ProfileCard()
                }
            }
            item {
                BasicInformation()
            }
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
        CommonInfoItem(
            title = "Address Details",
            subtitle = "+ Add Address Details",
            isButton = true
        )
        CommonInfoItem(
            title = "Transportation Mode",
            subtitle = "+ Add Transportation Mode",
            isButton = true
        )
        CommonInfoItem(
            title = "Assistant Names",
            subtitle = "+ Add Assistant Names",
            isButton = true
        )
        CommonInfoItem(
            title = "Preferences",
            subtitle = "These fields can only be updated by contacting support."
        )
        TicketFilterScreen()
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
    isButton: Boolean = false
) {
    Box(
        modifier = Modifier
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



@Composable
fun TicketFilterScreen() {
    var isExpanded by remember { mutableStateOf(false) }
    var selectedAppliances by remember { mutableStateOf(setOf("Aircon", "Refrigerator")) }
    var selectedServices by remember { mutableStateOf(setOf("Cleaning", "Repair")) }
    var selectedBrands by remember { mutableStateOf(setOf("Carrier", "Condura", "Kelvinator")) }
    var selectedCities by remember { mutableStateOf(setOf("Las Piñas", "Mandaluyong")) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE3F2FD))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isExpanded = !isExpanded }
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "Ticket Type",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ZCSC",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1976D2)
                )
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = Color(0xFF1976D2)
                )
            }
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                FilterSection(
                    title = "Appliance",
                    items = listOf("Aircon", "Refrigerator"),
                    selectedItems = selectedAppliances,
                    onItemToggle = { item ->
                        selectedAppliances = if (selectedAppliances.contains(item)) {
                            selectedAppliances - item
                        } else {
                            selectedAppliances + item
                        }
                    }
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 16.dp),
                    thickness = DividerDefaults.Thickness, color = Color(0xFFBBDEFB)
                )
                FilterSection(
                    title = "Service Type",
                    items = listOf("Cleaning", "Repair"),
                    selectedItems = selectedServices,
                    onItemToggle = { item ->
                        selectedServices = if (selectedServices.contains(item)) {
                            selectedServices - item
                        } else {
                            selectedServices + item
                        }
                    }
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 16.dp),
                    thickness = DividerDefaults.Thickness, color = Color(0xFFBBDEFB)
                )
                FilterSection(
                    title = "Brand",
                    items = listOf("Carrier", "Condura", "Kelvinator"),
                    selectedItems = selectedBrands,
                    onItemToggle = { item ->
                        selectedBrands = if (selectedBrands.contains(item)) {
                            selectedBrands - item
                        } else {
                            selectedBrands + item
                        }
                    }
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 16.dp),
                    thickness = DividerDefaults.Thickness, color = Color(0xFFBBDEFB)
                )
                FilterSection(
                    title = "Cities",
                    items = listOf("Las Piñas", "Mandaluyong"),
                    selectedItems = selectedCities,
                    onItemToggle = { item ->
                        selectedCities = if (selectedCities.contains(item)) {
                            selectedCities - item
                        } else {
                            selectedCities + item
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun FilterSection(
    title: String,
    items: List<String>,
    selectedItems: Set<String>,
    onItemToggle: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color(0xFF1976D2),
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        items.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowItems.forEach { item ->
                    CheckboxItem(
                        text = item,
                        isChecked = selectedItems.contains(item),
                        onCheckedChange = { onItemToggle(item) },
                        modifier = Modifier.weight(1f)
                    )
                }
                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun CheckboxItem(
    text: String,
    isChecked: Boolean,
    onCheckedChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable { onCheckedChange() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
        )
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF424242),
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}
