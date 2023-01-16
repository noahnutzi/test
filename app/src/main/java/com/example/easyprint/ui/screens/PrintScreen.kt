package com.example.easyprint.ui.screens

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.easyprint.R
import com.example.easyprint.data.StoreUserSettings
import com.example.easyprint.dataclass.UserData
import com.example.easyprint.functions.fileSelection
import com.example.easyprint.functions.stopBackground

@Composable
fun PrintScreen (
    @StringRes titleResourceId: Int,
    @DrawableRes imageResourceId: Int,
    @StringRes descriptionResourceId: Int,
    fileName: String,
    context: Context,
){
    //context
    val contextApi = LocalContext.current
    // datastore
    val dataStore = StoreUserSettings(contextApi)
    // get saved IP
    val savedIP = dataStore.getIP.collectAsState(initial = "")
    val savedAPI = dataStore.getAPI.collectAsState(initial = "")

    val userData = UserData(savedIP.value!!, savedAPI.value!!)


    Column() {
        Card(
            modifier = Modifier
                .padding(8.dp),
            elevation = 8.dp
        ) {
            Column() {
                Text(
                    text = stringResource(id = titleResourceId),
                    modifier = Modifier
                        .padding(8.dp)
                )
                Image(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = stringResource(id = titleResourceId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
        }

        Card(
            modifier = Modifier
                .padding(8.dp),
            elevation = 8.dp
        ) {
            Text(
                text = stringResource(id = descriptionResourceId),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            )
        }

        Card(
            modifier = Modifier
                .padding(8.dp),
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {fileSelection(fileName, context, userData)},
                ) {
                    Text(
                        text = stringResource(id = R.string.print),
                        color = MaterialTheme.colors.onPrimary)
                }
                Spacer(modifier = Modifier.width(100.dp))
                Button(
                    onClick = { stopBackground( userData,context ) }
                ) {
                    Text(
                        text = stringResource(id = R.string.cancel),
                        color = MaterialTheme.colors.onPrimary)
                }
            }
        }
    }
}

