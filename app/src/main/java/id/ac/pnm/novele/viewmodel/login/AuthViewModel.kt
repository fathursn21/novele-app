package id.ac.pnm.novele.viewmodel.login

//import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.pnm.novele.data.repository.auth.AuthRepository
import id.ac.pnm.novele.data.model.auth.Result

import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.auth.LoggedInUserView
import id.ac.pnm.novele.data.model.auth.LoginFormState
import id.ac.pnm.novele.data.model.auth.LoginResult

import id.ac.pnm.novele.data.model.auth.RegisterFormState
import id.ac.pnm.novele.data.model.auth.RegisterResult

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    //form login
    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm
    //result login
    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    //form register
    private val _registerForm = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _registerForm
    //result register
    private val _registerResult = MutableLiveData<RegisterResult>()
    val registerResult: LiveData<RegisterResult> = _registerResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = authRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isEmailValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    fun register(username: String, email: String, tanggalLahir: String, password: String, konfirmasiPassword: String) {
        val result = authRepository.register(username, email, tanggalLahir, password, konfirmasiPassword)

        if (result is Result.Success) {
            // Jika register sukses, kita bisa menganggapnya sebagai login sukses juga
            _registerResult.value =
                RegisterResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _registerResult.value = RegisterResult(error = R.string.register_failed)
        }
    }

    fun registerDataChanged(username: String, email: String,tanggalLahir: String, password: String, konfirmasiPassword: String) {
        if (!isUsernameValid(username)) { // Re-use username validation
            _registerForm.value = RegisterFormState(usernameError = R.string.invalid_username)
        } else if (!isEmailValid(email)) { // Validasi email baru
            _registerForm.value = RegisterFormState(emailError = R.string.invalid_email)
        } else if (!isTanggalLahirValid(tanggalLahir)) { // Validasi email baru
            _registerForm.value = RegisterFormState(emailError = R.string.invalid_email)
        } else if (!isPasswordValid(password)) { // Validasi email baru
            _registerForm.value = RegisterFormState(emailError = R.string.invalid_email)
        } else if (!isPasswordValid(konfirmasiPassword)) { // Re-use password validation
            _registerForm.value = RegisterFormState(passwordError = R.string.invalid_password)
        } else {
            _registerForm.value = RegisterFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isEmailValid(email: String): Boolean {
//        tak comment dulu biar mudah masuk ke home
//        return if (email.contains('@')) {
//            Patterns.EMAIL_ADDRESS.matcher(email).matches()
//        } else {
//            email.isNotBlank()
//        }
        return true
    }

    private fun isTanggalLahirValid(tanggalLahir: String): Boolean {
        return true
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
//        biar mudah masuk ke home
//        return password.isNotEmpty()
        return true
    }

    private fun isUsernameValid(username: String): Boolean {
//        return username.length > 0
        return true
    }

    fun logout(){
        authRepository.logout()
    }
}