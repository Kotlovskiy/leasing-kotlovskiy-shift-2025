package com.unewexp.leasingapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unewexp.leasingapp.R
import com.unewexp.leasingapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CarsScreen(onCardClick: (String) -> Unit = {}) {
    Scaffold(
        topBar = {TopAppBar(
            title = { Text(stringResource(R.string.cars)) }
        )}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize().padding(horizontal = 16.dp)
                .padding(top = paddingValues.calculateTopPadding())
        ){
            SearchBlock()
            val list = mutableListOf(1,2,3,4,5,6,7,8)
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(list){ it ->
                    Card({ onCardClick("a") })
                }
            }
        }
    }
}

@Composable
fun SearchBlock(){

    var value by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.fillMaxWidth().height(260.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Text(stringResource(R.string.search))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = { newValue ->
                    value = newValue
                },
                shape = RoundedCornerShape(16)
            )
        }
        Column {
            Text(stringResource(R.string.dates))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16),
                value = value,
                onValueChange = { newValue ->
                    value = newValue
                }
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth().height(64.dp),
            onClick = {},
            shape = RoundedCornerShape(16)
        ){
            Row(
                modifier = Modifier.width(90.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(ImageVector.vectorResource(R.drawable.ic_sliders), "sliders")
                Text(stringResource(R.string.filters))
            }
        }

    }
}

@Composable
fun Card(onCardClick: () -> Unit = {}){
    Row(
        modifier = Modifier
            .height(128.dp)
            .fillMaxWidth()
            .clickable { onCardClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.fillMaxHeight(0.9f).weight(1f),
            contentAlignment = Alignment.Center
        ){
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.car),
                contentDescription = "Изображение машины",
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .weight(1f)
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Chery Arrizo 8", style = Typography.titleMedium)
                Text("Автомат, 2.5л", style = Typography.bodyMedium)
            }
            Column {
                Text("5 000", style = Typography.titleMedium)
                Text("70 000", style = Typography.bodyMedium)
            }
        }
    }
}