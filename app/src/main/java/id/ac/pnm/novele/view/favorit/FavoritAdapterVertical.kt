package id.ac.pnm.novele.view.favorit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.novel.NovelData

class FavoritAdapterVertical(
    private val onItemClick: (String) -> Unit
) :
    RecyclerView.Adapter<FavoritAdapterVertical.FavoritViewHolder>() {

    private var listNovelFavorit: List<NovelData> = emptyList()

    inner class FavoritViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewCoverNovelFavorit: ImageView =
            view.findViewById(R.id.imageViewCoverNovelLibrary)

        fun bind(novel: NovelData) {
            imageViewCoverNovelFavorit.setImageResource(novel.coverNovel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_library, parent, false)
        return FavoritViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritViewHolder, position: Int) {
        val novel = listNovelFavorit[position]
        holder.bind(novel)
        holder.itemView.setOnClickListener {
            onItemClick(novel.id)
        }
    }

    override fun getItemCount(): Int = listNovelFavorit.size

    fun adapterListenerData(newListNovelFavorit: List<NovelData>) {
        val oldList = listNovelFavorit

        // copy list novel library
        val newListCopy = newListNovelFavorit.toList()

        val diffResult = DiffUtil.calculateDiff(
            ListNovelDiffCallback(oldList, newListCopy)
        )

        listNovelFavorit = newListCopy
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