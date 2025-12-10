package id.ac.pnm.novele.view.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.user.UserDataSource
import id.ac.pnm.novele.view.HomeActivity
import id.ac.pnm.novele.view.LoginActivity
import id.ac.pnm.novele.viewmodel.login.AuthViewModel
import id.ac.pnm.novele.viewmodel.login.AuthViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

///**
// * A simple [Fragment] subclass.
// * Use the [ProfileFragment.newInstance] factory method to
// * create an instance of this fragment.
// */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

    private var displayName: String? = null
    private lateinit var textViewDisplayName: TextView
    private lateinit var layoutLogout: LinearLayout
    private lateinit var layoutFavorit: LinearLayout
    private lateinit var layoutHistory: LinearLayout
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
        //getExtra dari LoginActivity
        val getExtraDisplayName = requireActivity().intent.getStringExtra(HomeActivity.DISPLAY_NAME)
        displayName = getExtraDisplayName
        authViewModel = ViewModelProvider(requireActivity(), AuthViewModelFactory())[AuthViewModel::class.java]


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        layoutLogout = view.findViewById(R.id.layoutLogout)
        layoutFavorit = view.findViewById(R.id.layoutFavorit)
        layoutHistory = view.findViewById(R.id.layoutHistory)
        textViewDisplayName = view.findViewById(R.id.textViewDisplayName)
        return view
    }


    //    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment ProfileFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            ProfileFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewDisplayName.text = displayName

        //pindah ke halaman login
        layoutLogout.setOnClickListener {
            logout()
        }
        layoutHistory.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_profileFragment_to_historyFragment)
        }
        layoutFavorit.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_profileFragment_to_favoritFragment)
        }
    }
    private fun logout() {
        //menghapus sesi login, fungsinya ada di file AuthViewModel
        authViewModel.logout()

        //untuk pindah ke halaman login
        val intent = Intent(requireActivity(), LoginActivity::class.java)

        //membersihkan task yang sebelumnya sambil membuka task baru untuk pindah activity
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        //eksekusi intentnya
        startActivity(intent)
    }
}