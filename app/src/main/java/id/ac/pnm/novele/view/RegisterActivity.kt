package id.ac.pnm.novele.view

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import id.ac.pnm.novele.databinding.ActivityRegisterBinding
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.auth.LoggedInUserView
import id.ac.pnm.novele.viewmodel.login.AuthViewModel
import id.ac.pnm.novele.viewmodel.login.AuthViewModelFactory

class RegisterActivity : AppCompatActivity() {

    private lateinit var authViewModel: AuthViewModel
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.editTextEmail
        val username = binding.editTextUsername
        val password = binding.editTextPassword
        val konfirmasiPassword = binding.editTextKonfirmasiPassword
        val tanggalLahir =  binding.editTextTanggalLahir
        val daftar = binding.buttonDaftar
        val kembali = binding.buttonKembali
        val loading = binding.loading

        authViewModel = ViewModelProvider(this, AuthViewModelFactory())[AuthViewModel::class.java]

        authViewModel.registerFormState.observe(this@RegisterActivity, Observer {
            val registerState = it ?: return@Observer

            // disable button daftar biar harus ngisi dlu baru bisa aktif
            daftar.isEnabled = registerState.isDataValid

            if (registerState.usernameError != null) {
                username.error = getString(registerState.usernameError)
            }
            if (registerState.emailError != null) {
                email.error = getString(registerState.emailError)
            }
            if (registerState.passwordError != null) {
                password.error = getString(registerState.passwordError)
            }
            if (registerState.konfirmasiPasswordError != null) {
                konfirmasiPassword.error = getString(registerState.konfirmasiPasswordError)
            }
        })

        authViewModel.registerResult.observe(this@RegisterActivity, Observer {
            val registerResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (registerResult.error != null) {
                showLoginFailed(registerResult.error)
            }
            if (registerResult.success != null) {
                updateUiWithUser(registerResult.success)
                //kalau sukses langsung panggil fungsinya
                registerHome(registerResult.success.displayName)
            }
            setResult(RESULT_OK)

            //Complete and destroy login activity once successful
        })

        tanggalLahir.setOnClickListener {
            showDatePickerDialog()
        }

        username.afterTextChanged {
            authViewModel.registerDataChanged(
                username.text.toString(),
                email.text.toString(),
                tanggalLahir.text.toString(),
                password.text.toString(),
                konfirmasiPassword.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                authViewModel.registerDataChanged(
                    username.text.toString(),
                    email.text.toString(),
                    tanggalLahir.text.toString(),
                    password.text.toString(),
                    konfirmasiPassword.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        authViewModel.register(
                            username.text.toString(),
                            email.text.toString(),
                            tanggalLahir.text.toString(),
                            password.text.toString(),
                            konfirmasiPassword.text.toString()
                        )
                }
                false
            }
        }

        daftar.setOnClickListener {
            loading.visibility = View.VISIBLE
            authViewModel.register(
                username.text.toString(),
                email.text.toString(),
                tanggalLahir.text.toString(),
                password.text.toString(),
                konfirmasiPassword.text.toString())
        }

        kembali.setOnClickListener {
            registerLogin()
        }
    }

    //kalender
    private fun showDatePickerDialog() {
        val calendar = java.util.Calendar.getInstance()
        val year = calendar.get(java.util.Calendar.YEAR)
        val month = calendar.get(java.util.Calendar.MONTH)
        val day = calendar.get(java.util.Calendar.DAY_OF_MONTH)

        val datePickerDialog = android.app.DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Format tanggal yang nya (DD/MM/YYYY)
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.editTextTanggalLahir.setText(date)

            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    //menuju ke halaman home
    private fun registerHome(displayName : String){
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("DISPLAY_NAME", displayName)
        startActivity(intent)
        finish()
    }
    //menuju ke halaman login
    private fun registerLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
            applicationContext,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */

//di comment karena udah ada di LoginActivity biar ga tabrakan karena object e harus ada satu
//fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
//    this.addTextChangedListener(object : TextWatcher {
//        override fun afterTextChanged(editable: Editable?) {
//            afterTextChanged.invoke(editable.toString())
//        }
//
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//
//        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
//    })
//}