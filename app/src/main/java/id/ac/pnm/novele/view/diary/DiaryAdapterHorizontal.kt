package id.ac.pnm.novele.view.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnm.novele.R
import id.ac.pnm.novele.data.model.diary.DiaryData

class DiaryAdapterHorizontal : RecyclerView.Adapter<DiaryAdapterHorizontal.DiaryHorizontalViewHolder>() {
    private var listDiary: List<DiaryData> = emptyList()

    class  DiaryHorizontalViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val imageViewCoverNovelHorizontal = view.findViewById<ImageView>(R.id.imageViewCoverNovelHorizontal)

        fun bind(novel : DiaryData){
            imageViewCoverNovelHorizontal.setImageResource(novel.coverDiary)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiaryHorizontalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_horizontal_novel, parent, false)
        return DiaryHorizontalViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: DiaryHorizontalViewHolder,
        position: Int
    ) {
        val row = listDiary[position]
        holder.bind(row)
    }

    override fun getItemCount(): Int {
        return listDiary.size
    }

    fun adapterListenerData(newListNovelLibrary: List<DiaryData>) {
        val diffResult = DiffUtil.calculateDiff(
            ListDiaryDiffCallback(this.listDiary, newListNovelLibrary)
        )

        this.listDiary = newListNovelLibrary

        diffResult.dispatchUpdatesTo(this)
    }

    class ListDiaryDiffCallback(
        private val oldList: List<DiaryData>,
        private val newList: List<DiaryData>
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