package id.ac.pnm.novele.viewmodel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.pnm.novele.data.model.auth.AuthDataSource
import id.ac.pnm.novele.data.model.user.UserDataSource
import id.ac.pnm.novele.data.repository.auth.AuthRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class AuthViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(
                authRepository = AuthRepository(
                    dataSource = AuthDataSource(userDataSource = UserDataSource)
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}