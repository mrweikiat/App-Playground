package com.example.myapplication.landingpage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LandingPageScreen(
    miniApps: List<LandingPageItemType>,
    onMiniAppClick: (LandingPageItemType) -> Unit,
    padding: PaddingValues,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mini App Playground",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = padding.calculateTopPadding(),
                )
        )

        LazyColumn {
            items(miniApps) { app ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight(0.5f)
                        .padding(top = padding.calculateTopPadding())
                        .clickable { onMiniAppClick(app) },
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Text(
                        text = app.displayName,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .padding(padding)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}
