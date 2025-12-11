package id.ac.pnm.novele.data.model.auth

import id.ac.pnm.novele.data.model.user.UserDataSource
import java.io.IOException
import java.util.UUID
import kotlin.random.Random

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class AuthDataSource(private val userDataSource: UserDataSource) {
    //handle login, yang nentuin sukses atau engganya
    fun login(usernameEmail: String, password: String): Result<LoggedInUser> {
        try {
        //aku comment dulu biar mudah masuk ke home
//            val user = if (usernameEmail.contains("@")){
//                userDataSource.findUserByEmail(usernameEmail)
//            } else{
//                userDataSource.findUserByUsername(usernameEmail)
//            }
//            // TODO: handle loggedInUser authentication
//            return if (user != null && user.password == password ){
//                Result.Success(user)
//            }else{
//                Result.Error(IOException("Username atau password salah."))
            //pakai fake user dulu
            val fakeUser = LoggedInUser("","", "","","")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }
    //handle register yang nentuin sukses atau engganya
    fun register(username: String, email: String, tanggalLahir: String, password: String): Result<LoggedInUser> {
        try {
            if (userDataSource.isUsernameRegistered(username) || (userDataSource.isEmailRegistered(email))){
                return Result.Error(IOException("Username atau email sudah terdaftar"))
            } else {
                //aku comment dulu biar mudah masuk ke home
//                if (password == konfirmasiPassword){
                    val newUser = LoggedInUser(
                        userId = UUID.randomUUID().toString(),
                        displayName = username,
                        email = email,
                        tanggalLahir = tanggalLahir,
                        password = password
                    )
                    userDataSource.saveUser(newUser)
                    val user = LoggedInUser(UUID.randomUUID().toString(), username, email,tanggalLahir,password)
                    return Result.Success(user)
//                }
            }
            // TODO: handle loggedInUser authentication
//            return Result.Error(IOException("Pendaftaran Gagal"))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error Pendaftaran Gagal", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}