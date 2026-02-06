package com.gautam.userlist.userInterface.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gautam.userlist.data.remote.api.RetrofitInstance
import com.gautam.userlist.data.remote.model.User
import com.gautam.userlist.util.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<User>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<User>>> = _uiState.asStateFlow()

    init {
        getData()
    }

    fun getData(){
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = UiState.Loading

            try {
                val result = RetrofitInstance.api.fetchData()
                Log.d("Debug", "Success: Received ${result.size} users")
                _uiState.value = UiState.Success(result)
            }catch (e: Exception){
                _uiState.value = UiState.Failure(e.localizedMessage ?: "Unknown Error")

            }
        }
    }
}