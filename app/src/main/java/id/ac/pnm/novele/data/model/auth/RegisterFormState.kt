package id.ac.pnm.novele.data.model.auth

data class RegisterFormState(
    val usernameError: Int? = null,
    val emailError: Int? = null,
    val passwordError: Int? = null,
    val konfirmasiPasswordError: Int? = null,
    val isDataValid: Boolean = false
)