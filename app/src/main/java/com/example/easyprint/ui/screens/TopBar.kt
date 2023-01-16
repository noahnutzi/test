package com.example.easyprint.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.easyprint.AppScreens
import com.example.easyprint.R

@Composable
fun EasyPrintTopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colors.primary)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(25))
                .clickable { navController.navigate(AppScreens.Main.name) }
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .padding(6.dp)
                    .clip(RoundedCornerShape(30)),
                painter = painterResource(id = R.drawable.easyprint),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onPrimary
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.navigate(AppScreens.Main.name) },
            ) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = stringResource(id = R.string.home),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
            IconButton(
                onClick = { navController.navigate(AppScreens.Settings.name) }
            ) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = stringResource(id = R.string.settings),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
            IconButton(
                onClick = { navController.navigate(AppScreens.Information.name) }
            ) {
                Icon(
                    Icons.Default.Info,
                    contentDescription = stringResource(id = R.string.info),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}
