package id.ac.pnm.novele.view.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.novel.ChapterData


class DetailChapterAdapter() :
    RecyclerView.Adapter<DetailChapterAdapter.ChapterViewHolder>() {

    private var daftarChapterNovel: List<ChapterData> = emptyList()

    class ChapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val textViewNovelChapter: TextView = view.findViewById(R.id.textViewChapter)
        val textViewJudulChapter: TextView = view.findViewById(R.id.textViewJudulChapter)

        val textViewWaktuChapter: TextView = view.findViewById(R.id.textViewWaktuChapter)

        //pake itemView buat akses ke view nya langsung mirip kyk kontruktor view di kelas NovelViewHolder
        fun bind(chapterNovel: ChapterData) {
                textViewNovelChapter.text =
                    itemView.context.getString(R.string.chapter, chapterNovel.chapter)
                textViewWaktuChapter.text = itemView.context.getString(R.string.jam, chapterNovel.waktu)
                textViewJudulChapter.text = chapterNovel.title

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_chapter,
            parent,
            false
        )
        return ChapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val chapter = daftarChapterNovel[position]
        holder.bind(chapter)
    }

    override fun getItemCount(): Int {
        return daftarChapterNovel.size
    }

    fun updateData(newDaftarChapter: List<ChapterData>) {
        val diffResult = DiffUtil.calculateDiff(
            DaftarChapterDiffCallback(this.daftarChapterNovel, newDaftarChapter)
        )

        this.daftarChapterNovel = newDaftarChapter

        diffResult.dispatchUpdatesTo(this)
    }

    class DaftarChapterDiffCallback(
        private val daftarLama: List<ChapterData>,
        private val daftarBaru: List<ChapterData>
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
            val cekItemSama = itemLama.chapter == itemBaru.chapter
            return cekItemSama
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return daftarLama[oldItemPosition] == daftarBaru[newItemPosition]
        }
    }
}
