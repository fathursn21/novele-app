package id.ac.pnm.novele.view.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.model.NovelData


class NovelHorizontalAdapter :
    RecyclerView.Adapter<NovelHorizontalAdapter.NovelViewHolder>() {

    private var daftarNovelHorizontal: List<NovelData> = emptyList()

    class NovelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewCoverNovelHorizontal : ImageView = view.findViewById(R.id.imageViewCoverNovelHorizontal)

        fun bind(novel: NovelData) {
            imageViewCoverNovelHorizontal.setImageResource(novel.coverNovel)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NovelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_home_horizontal_novel,
            parent,
            false
        )
        return NovelViewHolder(view)
    }

    override fun onBindViewHolder(holder: NovelViewHolder, position: Int) {
        val novel = daftarNovelHorizontal[position]
        holder.bind(novel)
    }

    override fun getItemCount(): Int {
        return daftarNovelHorizontal.size
    }

    fun updateData(newDaftarNovel: List<NovelData>) {
        val diffResult = DiffUtil.calculateDiff(
            DaftarNovelDiffCallback(this.daftarNovelHorizontal, newDaftarNovel)
        )

        this.daftarNovelHorizontal = newDaftarNovel

        diffResult.dispatchUpdatesTo(this)
    }

    class DaftarNovelDiffCallback(
        private val daftarLama: List<NovelData>,
        private val daftarBaru: List<NovelData>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return daftarLama.size
        }
        override fun getNewListSize(): Int {
            return daftarBaru.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val itemLama = daftarLama[oldItemPosition]
            val itemBaru = daftarBaru[newItemPosition]
            val cekItemSama = itemLama.id == itemBaru.id
            return cekItemSama
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return daftarLama[oldItemPosition] == daftarBaru[newItemPosition]
        }
    }
}
