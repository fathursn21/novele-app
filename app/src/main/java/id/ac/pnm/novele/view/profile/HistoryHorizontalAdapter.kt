package id.ac.pnm.novele.view.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.novel.NovelData


class HistoryHorizontalAdapter(
    private val onItemClick: (String) -> Unit
) :
    RecyclerView.Adapter<HistoryHorizontalAdapter.HistoryViewHolder>() {

    private var daftarHistoryHorizontal: List<NovelData> = emptyList()

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewCoverHistoryHorizontal : ImageView = view.findViewById(R.id.imageViewCoverNovelHorizontal)

        fun bind(novel: NovelData) {
            imageViewCoverHistoryHorizontal.setImageResource(novel.coverNovel)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_home_horizontal_novel,
            parent,
            false
        )
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val novel = daftarHistoryHorizontal[position]
        holder.bind(novel)
        holder.itemView.setOnClickListener {
            onItemClick(novel.id)
        }
    }

    override fun getItemCount(): Int {
        return daftarHistoryHorizontal.size
    }

    fun updateData(newDaftarNovel: List<NovelData>) {
        val diffResult = DiffUtil.calculateDiff(
            DaftarNovelDiffCallback(this.daftarHistoryHorizontal, newDaftarNovel)
        )

        this.daftarHistoryHorizontal = newDaftarNovel

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
