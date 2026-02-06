package com.gautam.userlist.userInterface.screen.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gautam.userlist.data.remote.model.User

@Composable
fun UserList(
    users: List<User>,
    navController: NavController
){
    LazyColumn(Modifier.fillMaxSize()) {
        items(users){user->
            UserCard(user,navController)
        }
    }
}

@Composable
fun UserCard(user: User,navController: NavController){
    Card(modifier = Modifier.fillMaxWidth()
        .padding(8.dp)
        .clickable(onClick = {navController.navigate("detail/${user.id}")}),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = user.username, style = MaterialTheme.typography.titleLarge)
            Text(text = user.email, style = MaterialTheme.typography.bodySmall)
        }
    }
}