package com.example.easyprint.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.easyprint.R
import com.example.easyprint.data.StoreUserSettings
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen() {

    //context
    val context = LocalContext.current
    // scope
    val scope = rememberCoroutineScope()
    // datastore
    val dataStore = StoreUserSettings(context)
    // get saved IP
    val savedIP = dataStore.getIP.collectAsState(initial = "")
    val savedAPI = dataStore.getAPI.collectAsState(initial = "")

    var ip by remember { mutableStateOf("") }
    var api by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    Column() {
        Card(
            modifier = Modifier
                .padding(8.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier.padding(8.dp),
                    value = ip,
                    onValueChange = { ip = it },
                    label = { Text(text = stringResource(id = R.string.ip_user_info)) },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedLabelColor = MaterialTheme.colors.onSurface,
                        focusedLabelColor = MaterialTheme.colors.onSurface
                    ),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {focusManager.clearFocus()})
                )
                Button(
                    onClick = {
                        //launch the class in a coroutine scope
                        scope.launch {
                            dataStore.saveIP(ip)
                        }
                    }
                ) {
                    Text(text = stringResource(id = R.string.save_ip))
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(
                            BorderStroke(1.dp, MaterialTheme.colors.primary),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(id = R.string.saved_ip))
                    Text(text = savedIP.value!!)
                }
            }
        }

        Card(
            modifier = Modifier
                .padding(8.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier.padding(8.dp),
                    value = api,
                    onValueChange = { api = it },
                    label = { Text(text = stringResource(id = R.string.api_user_info)) },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedLabelColor = MaterialTheme.colors.onSurface,
                        focusedLabelColor = MaterialTheme.colors.onSurface
                    ),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {focusManager.clearFocus()})
                )
                Button(
                    onClick = {
                        //launch the class in a coroutine scope
                        scope.launch {
                            dataStore.saveAPI(api)
                        }
                    }
                ) {
                    Text(text = stringResource(id = R.string.save_api))
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(
                            BorderStroke(1.dp, MaterialTheme.colors.primary),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(id = R.string.saved_api))
                    Text(text = savedAPI.value!!)
                }
            }
        }
    }
}