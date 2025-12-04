package id.ac.pnm.novele.data.model.auth

data class RegisterResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)