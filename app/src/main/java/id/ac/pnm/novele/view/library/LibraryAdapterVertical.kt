package id.ac.pnm.novele.view.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.novel.NovelData

class LibraryAdapterVertical(
    private val onItemClick: (String) -> Unit
) :
    RecyclerView.Adapter<LibraryAdapterVertical.LibraryViewHolder>() {

    private var listNovelLibrary: List<NovelData> = emptyList()

    inner class LibraryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewCoverNovelLibrary: ImageView =
            view.findViewById(R.id.imageViewCoverNovelLibrary)

        fun bind(novel: NovelData) {
            imageViewCoverNovelLibrary.setImageResource(novel.coverNovel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_library, parent, false)
        return LibraryViewHolder(view)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val novel = listNovelLibrary[position]
        holder.bind(novel)
        holder.itemView.setOnClickListener {
            onItemClick(novel.id)
        }
    }

    override fun getItemCount(): Int = listNovelLibrary.size

    fun adapterListenerData(newListNovelLibrary: List<NovelData>) {
        val oldList = listNovelLibrary

        // copy list novel library
        val newListCopy = newListNovelLibrary.toList()

        val diffResult = DiffUtil.calculateDiff(
            ListNovelDiffCallback(oldList, newListCopy)
        )

        listNovelLibrary = newListCopy
        diffResult.dispatchUpdatesTo(this)
    }

    class ListNovelDiffCallback(
        private val daftarLama: List<NovelData>,
        private val daftarBaru: List<NovelData>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = daftarLama.size
        override fun getNewListSize(): Int = daftarBaru.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return daftarLama[oldItemPosition].id == daftarBaru[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return daftarLama[oldItemPosition] == daftarBaru[newItemPosition]
        }
    }
}