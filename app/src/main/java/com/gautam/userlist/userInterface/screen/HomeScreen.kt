package com.gautam.userlist.userInterface.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gautam.userlist.userInterface.viewModel.UserViewModel
import com.gautam.userlist.userInterface.screen.uiComponents.UserList
import com.gautam.userlist.util.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: UserViewModel = viewModel(),
               navController: NavController){

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(topBar = {
        TopAppBar(
        title = { Text("HomeScreen") }
    )
    }) {paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            contentAlignment = Alignment.Center){
            when (val state = uiState){
                is UiState.Loading ->{
                    CircularProgressIndicator()
                }
                is UiState.Success -> {
                    UserList(users = state.data,navController)
                }
                is UiState.Failure ->{
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(Modifier.padding(16.dp)){
                            Text(
                                text = "Error : ${state.msg}",
                                color = androidx.compose.ui.graphics.Color.Red
                            )
                        }
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