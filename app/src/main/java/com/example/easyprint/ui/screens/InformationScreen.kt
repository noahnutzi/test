package com.example.easyprint.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.easyprint.R

@Composable
fun InformationScreen (){

    val operateURL = remember {Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))}
    val generalInfoURL = remember {Intent(Intent.ACTION_VIEW, Uri.parse("https://training.educanova.ch/"))}
    val appCreateURL = remember {Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))}

    Column() {
        LinkCard(title = R.string.operatevideotitle, URL = operateURL)
        LinkCard(title = R.string.generalvideotitle, URL = generalInfoURL)
        LinkCard(title = R.string.createvideotitle, URL = appCreateURL)
    }
}

@Composable
fun LinkCard (
    @StringRes title: Int,
    URL: Intent
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = title),
                modifier = Modifier
                    .padding(10.dp),
                textAlign = TextAlign.Center
            )
            Button(
                onClick = { context.startActivity(URL) },
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(text = stringResource(id = R.string.link))
            }
        }
    }
}
