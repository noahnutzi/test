package com.example.easyprint.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.easyprint.data.DatasourceMainScreen
import com.example.easyprint.dataclass.DataForScreen
import com.example.easyprint.ui.theme.EasyPrintTheme
import com.example.easyprint.R

@Composable
fun MainScreen(navController: NavController) {
    EasyPrintTheme() {
        DataList(
            dataList = DatasourceMainScreen().loadData(),
            navController = navController)
    }
}

@Composable
fun DataList(
    dataList: List<DataForScreen>,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
    ) {
        items(dataList){ data ->
            PrintCard(data = data, navController = navController)
        }
    }
}

@Composable
fun PrintCard (
    data: DataForScreen,
    navController: NavController
){
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
        ) {
            Image(
                painter = painterResource(id = data.imageResourceId),
                contentDescription = stringResource(id = data.stringResourceId),
                modifier = Modifier
                    .height(194.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillHeight
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = data.stringResourceId),
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface
                )
                Button(
                    onClick =  { navController.navigate(data.route) },
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                ) {
                    Text(
                        text = stringResource(id = R.string.more_information),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        }
    }
}





