package com.example.paradisecrossfit.paradisecf.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paradisecrossfit.paradisecf.domain.a.repository.usecase.FirebaseSignUpUseCase
import com.example.paradisecrossfit.paradisecf.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: FirebaseSignUpUseCase
) :  ViewModel() {

    private val _passwordSent: MutableLiveData<Resource<Boolean>> = MutableLiveData()
    val signUpState: LiveData<Resource<Boolean>>
        get() = _passwordSent

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            signUpUseCase(email, password).onEach { state ->
                _passwordSent.value = state
            }.launchIn(viewModelScope)
        }
    }

}