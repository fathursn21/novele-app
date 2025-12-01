package id.ac.pnm.novele.data.repository.auth

import id.ac.pnm.novele.data.model.auth.AuthDataSource
import id.ac.pnm.novele.data.model.auth.LoggedInUser
import id.ac.pnm.novele.data.model.auth.Result

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class AuthRepository(val dataSource: AuthDataSource) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }
    //menghampus sesi login dengan user = null
    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    //handle register
    fun register(username: String, email: String, tanggalLahir: String, password: String, konfirmasiPassword: String): Result<LoggedInUser> {
        val result = dataSource.register(username, email, tanggalLahir,password, konfirmasiPassword)

        // Setelah register sukses, secara otomatis pengguna dianggap sudah login
        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    //menyimpan data user yang di private tapi nanti dulu
    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}