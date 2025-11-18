package com.learn.learnviewmodel.presentation.ui.screens.homescreen

import androidx.annotation.StringRes
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.learn.learnviewmodel.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onClick: () -> Unit) {
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
                text = stringResource(R.string.sample_name),
                fontSize = 16.sp,
                fontWeight = FontWeight.W700,
                color = Color(0XFF202325)
            )
        }
    }
}

@Composable
fun SwitchDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    isTurningOn: Boolean = false
) {
    Dialog(onDismissRequest = onDismiss) {
        Card {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_question_mark),
                        contentDescription = null
                    )
                    Text(
                        text = if (isTurningOn) {
                            stringResource(R.string.turn_on_your_tech_status)
                        } else {
                            stringResource(R.string.turn_off_your_tech_status)
                        },
                        modifier = Modifier.padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            drawLine(
                                color = Color(0xFF2023250D),
                                start = Offset(0f, 0f),
                                end = Offset(size.width, 0f),
                                strokeWidth = strokeWidth
                            )
                        }
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onDismiss() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                stringResource(R.string.no),
                                modifier = Modifier.padding(vertical = 14.dp),
                                color = Color(0xFF285EA6),
                                fontWeight = FontWeight.W600
                            )
                        }

                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight()
                                .background(Color(0xFF2023250D))
                        )

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onConfirm() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                stringResource(R.string.yes),
                                modifier = Modifier.padding(vertical = 14.dp),
                                color = Color(0xFF285EA6),
                                fontWeight = FontWeight.W600
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDialog() {
    SwitchDialog(onDismiss = {}, onConfirm = {}, isTurningOn = false)
}

@Composable
fun BasicInformation() {
    Column {
        CommonInfoWSwitch(
            title = R.string.tech_status
        )

        basicInformationData().forEach {
            CommonInfoItem(
                title = it.title,
                subtitle = it.subtitle,
                hasIcon = it.hasIcon,
                hasButton = it.hasButton
            )
        }

        Box(modifier = Modifier.padding(bottom = 16.dp)) {
            TicketFilterScreen()
        }
    }
}

@Composable
fun Banner() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
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
                stringResource(R.string.complete_your_profile),
                fontSize = 14.sp,
                fontWeight = FontWeight.W700,
                color = Color(0XFF296293)
            )

            Text(
                stringResource(R.string.almost_done),
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = Color(0XFF296293)
            )
        }
    }
}

@Composable
fun CommonInfoItem(
    @StringRes title: Int,
    @StringRes subtitle: Int,
    hasIcon: Boolean = false,
    icon: Int = R.drawable.ic_check,
    hasButton: Boolean = false
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
                Text(stringResource(title), color = Color(0XFF74777E))

                if (hasButton) {
                    CommonOutlineButton(text = "+ ${stringResource(subtitle)}")
                } else {
                    Text(
                        stringResource(subtitle),
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
    @StringRes title: Int,
) {
    var turnSwitch by remember { mutableStateOf(false) }
    var showSwitchDialog by remember { mutableStateOf(false) }
    var isTurningOn by remember { mutableStateOf(false) }

    if (showSwitchDialog) {
        SwitchDialog(
            onDismiss = {
                showSwitchDialog = false
            },
            onConfirm = {
                turnSwitch = !turnSwitch
                showSwitchDialog = false
            },
            isTurningOn = isTurningOn
        )
    }

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
                Text(stringResource(title), color = Color(0XFF74777E))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            if (turnSwitch) {
                                Color(0XFFD4F1C7)
                            } else {
                                Color(0xFFE3F2FD)
                            }
                        )
                        .padding(vertical = 3.dp, horizontal = 9.dp)
                ) {
                    Text(
                        if (turnSwitch) stringResource(R.string.on) else stringResource(R.string.off)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Switch(
                checked = turnSwitch,
                onCheckedChange = {
                    // Determine if turning on or off
                    isTurningOn = !turnSwitch
                    // Always show dialog for confirmation
                    showSwitchDialog = true
                }
            )
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

                Text(stringResource(R.string.profile))
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
                text = stringResource(R.string.ticket_type),
                fontSize = 14.sp,
                color = Color.Gray
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.zcsc),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1976D2)
                )

                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = stringResource(R.string.expand_collapse),
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

data class BasicInformation(
    @StringRes val title: Int,
    @StringRes val subtitle: Int,
    val hasButton: Boolean = false,
    val hasIcon: Boolean = false,
)

fun basicInformationData(): List<BasicInformation> {
    return listOf(
        BasicInformation(
            title = R.string.email_address,
            subtitle = R.string.sample_email
        ),
        BasicInformation(
            title = R.string.email_address,
            subtitle = R.string.add_contact_number,
            hasButton = true
        ),
        BasicInformation(
            title = R.string.address,
            subtitle = R.string.sample_address,
            hasIcon = true
        ),
        BasicInformation(
            title = R.string.address_details,
            subtitle = R.string.add_address_details,
            hasButton = true
        ),
        BasicInformation(
            title = R.string.transportation_mode,
            subtitle = R.string.add_transportation_mode,
            hasButton = true
        ),
        BasicInformation(
            title = R.string.assistant_names,
            subtitle = R.string.add_assistant_names,
            hasButton = true
        ),
        BasicInformation(
            title = R.string.preferences,
            subtitle = R.string.these_fields
        )
    )
}