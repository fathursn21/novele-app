package id.ac.pnm.novele.data.model.user

import id.ac.pnm.novele.data.model.auth.LoggedInUser

// id.ac.pnm.novele.data.source/UserLocalDataSource.kt

//untuk sekarang pakai object biar mudah nge test nya di activity lain tapi ya gitulah keamanan e kurang
object UserDataSource {

    // Implementasi penyimpanan di memory
    private val daftarUser: MutableList<LoggedInUser> = mutableListOf()
    //nyimpen user
    fun saveUser(user: LoggedInUser) {
        daftarUser.add(user)
    }
    //memakai it biar lebih ringkas saja sih karena cuma ada satu parameter di lamda nya
    //nyari username user
    fun findUserByUsername(username: String): LoggedInUser? {
        return daftarUser.find { it.displayName.equals(username, ignoreCase = true) }
    }
    //cek user sudah ada atau belum
    fun isUsernameRegistered(username: String): Boolean {
        return daftarUser.any { it.displayName.equals(username, ignoreCase = true) }
    }

    //nyari email user
    fun findUserByEmail(email: String): LoggedInUser? {
        //tidak case sensitive biar mudah nge test nya
        return daftarUser.find { it.email.equals(email, ignoreCase = true) }
    }

    //Cek email sudah terdaftar atau belum
    fun isEmailRegistered(email: String): Boolean {
        //tidak case sensitive biar mudah nge test nya
        return daftarUser.any { it.email.equals(email, ignoreCase = true) }
    }

}