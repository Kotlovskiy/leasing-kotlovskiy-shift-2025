package com.unewexp.leasingapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unewexp.leasingapp.R
import com.unewexp.leasingapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CarScreen(
    carId: String = "123",
    onToBack: () -> Unit = {},
    onToBook: () -> Unit = {}
){
    if(carId.isBlank()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text("404 Not Found")
        }
    }else{
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton( onClick = { onToBack() } ){
                            Icon(ImageVector.vectorResource(R.drawable.ic_left), "Назад")
                        }
                    },
                    title = { Text(stringResource(R.string.cars)) }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize().padding(horizontal = 16.dp)
                    .padding(top = paddingValues.calculateTopPadding())
            ){
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ){
                            Image(
                                bitmap = ImageBitmap.imageResource(R.drawable.car),
                                contentDescription = "Изображение машины",
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                            )
                        }
                    }
                    item {
                        Text("Название автомобиля", style = Typography.titleLarge)
                    }
                    item {
                        Text(stringResource(R.string.specifications), style = Typography.titleMedium)
                    }
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Text(
                                stringResource(R.string.transmission_box),
                                style = Typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                stringResource(R.string.automatic),
                                style = Typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    item {
                        HorizontalDivider()
                    }
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Text(
                                stringResource(R.string.steering_side),
                                style = Typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                stringResource(R.string.left),
                                style = Typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    item {
                        HorizontalDivider()
                    }
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Text(
                                stringResource(R.string.body_type),
                                style = Typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                stringResource(R.string.crossover),
                                style = Typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    item {
                        HorizontalDivider()
                    }
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Text(
                                stringResource(R.string.color),
                                style = Typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                stringResource(R.string.black),
                                style = Typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    item { /*Пустой item для доп.пространства*/}
                    item {
                        Text(stringResource(R.string.cost), style = Typography.titleMedium)
                    }
                    item {
                        HorizontalDivider()
                    }
                    item {
                        Text(stringResource(R.string.total) + ": 35 000", style = Typography.titleLarge)
                    }
                    item {
                        Text(stringResource(R.string.rent) + ": 3 - 5 июля 2025 года (2 дня)", style = Typography.bodyMedium)
                    }
                    item {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                modifier = Modifier.fillMaxWidth().height(64.dp),
                                onClick = { onToBack() },
                                shape = RoundedCornerShape(16)
                            ){
                                Text(stringResource(R.string.back))
                            }
                            Button(
                                modifier = Modifier.fillMaxWidth().height(64.dp),
                                onClick = { onToBook() },
                                shape = RoundedCornerShape(16)
                            ){
                                Text(stringResource(R.string.to_book))
                            }
                        }
                    }
                }
            }
        }
    }
}

