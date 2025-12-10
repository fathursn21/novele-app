package id.ac.pnm.novele.view.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.diary.DiaryChapterData
import id.ac.pnm.novele.data.model.novel.ChapterData

class DiaryChapterAdapter : RecyclerView.Adapter<DiaryChapterAdapter.DiaryChapterViewHolder>() {
    private var daftarChapterDiary : List<DiaryChapterData> = emptyList()

    class DiaryChapterViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textViewDiaryChapter = view.findViewById<TextView>(R.id.textViewDiaryChapter)
        val textViewJudulDiaryChapter = view.findViewById<TextView>(R.id.textViewJudulDiaryChapter)
        val textViewWaktuDiaryChapter = view.findViewById<TextView>(R.id.textViewWaktuDiaryChapter)

        fun bind(chapterDiary : DiaryChapterData){
            val chapter = chapterDiary.chapter
            textViewDiaryChapter.text = "Chapter $chapter"
            textViewJudulDiaryChapter.text = chapterDiary.title
            textViewWaktuDiaryChapter.text = itemView.context.getString(R.string.jam, chapterDiary.waktu)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiaryChapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_diary_chapter,
            parent,
            false
        )
        return DiaryChapterViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: DiaryChapterViewHolder,
        position: Int
    ) {
        val chapter = daftarChapterDiary[position]
        holder.bind(chapter)
    }

    override fun getItemCount(): Int {
        return daftarChapterDiary.size
    }

    fun updateData(newDaftarChapter: List<DiaryChapterData>) {
        val diffResult = DiffUtil.calculateDiff(
            DaftarChapterDiffCallback(this.daftarChapterDiary, newDaftarChapter)
        )

        this.daftarChapterDiary = newDaftarChapter

        diffResult.dispatchUpdatesTo(this)
    }

    class DaftarChapterDiffCallback(
        private val daftarLama: List<DiaryChapterData>,
        private val daftarBaru: List<DiaryChapterData>
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