package id.ac.pnm.novele.view.library

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.novel.NovelData

class LibraryAdapterHorizontal : RecyclerView.Adapter<LibraryAdapterHorizontal.LibraryViewHolder>() {
    private var listNovelLibrary: List<NovelData> = emptyList()

    class  LibraryViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageViewCoverNovelLibrary : ImageView = view.findViewById(R.id.imageViewCoverNovelLibrary)

        fun bind(novel: NovelData) {
            imageViewCoverNovelLibrary.setImageResource(novel.coverNovel)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LibraryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_library,
            parent,
            false)
        return LibraryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: LibraryViewHolder,
        position: Int
    ) {
        val row = listNovelLibrary[position]
        holder.bind(row)
    }

    override fun getItemCount(): Int {
        return listNovelLibrary.size
    }

    fun adapterListenerData(newListNovelLibrary: List<NovelData>) {
        val diffResult = DiffUtil.calculateDiff(
            ListNovelDiffCallback(this.listNovelLibrary, newListNovelLibrary)
        )

        this.listNovelLibrary = newListNovelLibrary

        diffResult.dispatchUpdatesTo(this)
    }

    class ListNovelDiffCallback(
        private val oldList: List<NovelData>,
        private val newList: List<NovelData>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }
        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldRow = oldList[oldItemPosition]
            val newRow = newList[newItemPosition]
            val isEquals = oldRow.id == newRow.id
            return isEquals
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}