package com.gautam.userlist.userInterface.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gautam.userlist.userInterface.viewModel.UserViewModel
import com.gautam.userlist.util.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(id: Int, viewModel: UserViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(topBar = { TopAppBar(
        title = { Text("User Detail") }
    ) }) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            contentAlignment = Alignment.Center) {
            when(val state = uiState){
                is UiState.Loading -> {
                    CircularProgressIndicator()
                }
                is UiState.Success -> {
                    val user = state.data.firstOrNull(){it.id == id}

                    user?.let {
                        Column(modifier = Modifier
                            .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Card(modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 8.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
                                Column(Modifier.padding(start = 16.dp)){
                                    Text(
                                        text = user.name,
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                    Text(
                                        text = "UserName: ${user.username}",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Text(
                                        text = "Email: ${user.email}",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Text(
                                        text = "PhoneNumber: ${user.phone}",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Text(
                                        text = "Website: ${user.website}",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
                            }
                        }
                    }
                }
                is UiState.Failure -> {
                    Column(Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = state.msg, color = Color.Red)
                        Spacer(Modifier.height(16.dp))
                        Button(onClick = {viewModel.getData()}) {
                            Text("Retry")
                        }
                    }
                }
            }

        }
    }
}