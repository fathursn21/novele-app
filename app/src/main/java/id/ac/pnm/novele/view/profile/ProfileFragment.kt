package id.ac.pnm.novele.view.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.view.DetailActivity
import id.ac.pnm.novele.view.HomeActivity
import id.ac.pnm.novele.view.LoginActivity
import id.ac.pnm.novele.viewmodel.login.AuthViewModel
import id.ac.pnm.novele.viewmodel.login.AuthViewModelFactory
import id.ac.pnm.novele.viewmodel.novel.NovelViewModel

class ProfileFragment : Fragment() {

    private var displayName: String? = null
    private lateinit var textViewDisplayName: TextView
    private lateinit var layoutLogout: LinearLayout
    private lateinit var layoutFavorit: LinearLayout
    private lateinit var layoutHistory: LinearLayout
    private lateinit var authViewModel: AuthViewModel
    private lateinit var novelViewModel: NovelViewModel

    private lateinit var historyHorizontalAdapter: HistoryHorizontalAdapter
    private lateinit var recyclerViewHistoryHorizontal : RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        recyclerViewHistoryHorizontal = view.findViewById(R.id.recyclerViewHistoryHorizontal)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewDisplayName.text = displayName
        novelViewModel = ViewModelProvider(requireActivity())[NovelViewModel::class.java]
        //pindah ke halaman login
        layoutLogout.setOnClickListener {
            logout()
        }

        historyHorizontalAdapter = HistoryHorizontalAdapter{ id ->
            val intent = Intent(requireActivity(), DetailActivity::class.java)
            intent.putExtra("ID_NOVEL", id)
            startActivity(intent)
        }

        recyclerViewHistoryHorizontal.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false)
            adapter = historyHorizontalAdapter
        }

        novelViewModel.novelData.observe(viewLifecycleOwner){ daftarNovel ->
            if (daftarNovel.isNotEmpty()){
                val daftarNovelHorizontal = daftarNovel.take(5)
                historyHorizontalAdapter.updateData(daftarNovelHorizontal)
            } else {
                historyHorizontalAdapter.updateData(emptyList())
            }
        }
        //ambil daftar novelnya biar ga kosong
        novelViewModel.getNovelData()
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