package id.ac.pnm.novele.data.model.login

import java.io.IOException
import java.util.UUID

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            if( username == "admin@gmail.com" && password == "admin"){
                val fakeUser = LoggedInUser(UUID.randomUUID().toString(), "admin")
                return Result.Success(fakeUser)
            } else {
                return Result.Error(IOException("aduh le salah isi"))
            }
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}