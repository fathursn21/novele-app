    package id.ac.pnm.novele.view.home

    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.recyclerview.widget.DiffUtil
    import androidx.recyclerview.widget.RecyclerView
    import id.ac.pnm.novele.R
    import id.ac.pnm.novele.model.NovelData


    class NovelVerticalUpdateAdapter :
        RecyclerView.Adapter<NovelVerticalUpdateAdapter.NovelViewHolder>() {

        private var daftarNovelVertical: List<NovelData> = emptyList()

        class NovelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val imageViewCoverNovelVerticalUpdate : ImageView = view.findViewById(R.id.imageViewCoverNovelVerticalUpdate)
            val textViewJudulNovelVerticalUpdate : TextView = view.findViewById(R.id.textViewJudulNovelVerticalUpdate)
            val textViewNovelChapterAtas : TextView = view.findViewById(R.id.textViewNovelChapterAtas)
            val textViewNovelWaktuAtas : TextView = view.findViewById(R.id.textViewNovelWaktuAtas)

            val textViewNovelChapterBawah : TextView = view.findViewById(R.id.textViewNovelChapterBawah)
            val textViewNovelWaktuBawah : TextView = view.findViewById(R.id.textViewNovelWaktuBawah)

            //pake itemView buat akses ke view nya langsung mirip kyk kontruktor view di kelas NovelViewHolder
            fun bind(novel: NovelData) {
                imageViewCoverNovelVerticalUpdate.setImageResource(novel.coverNovel)
                textViewJudulNovelVerticalUpdate.text = novel.judulNovel
                textViewNovelChapterAtas.text = itemView.context.getString(R.string.chapter, novel.chapterBaru)
                textViewNovelChapterBawah.text = itemView.context.getString(R.string.chapter, novel.chapterLama)
                textViewNovelWaktuAtas.text = itemView.context.getString(R.string.jam, novel.waktuChapterBaru)
                textViewNovelWaktuBawah.text = itemView.context.getString(R.string.jam, novel.waktuChapterLama)
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): NovelViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_home_vertical_novel,
                parent,
                false
            )
            return NovelViewHolder(view)
        }

        override fun onBindViewHolder(holder: NovelViewHolder, position: Int) {
            val novel = daftarNovelVertical[position]
            holder.bind(novel)
        }

        override fun getItemCount(): Int {
            return daftarNovelVertical.size
        }

        fun updateData(newDaftarNovel: List<NovelData>) {
            val diffResult = DiffUtil.calculateDiff(
                DaftarNovelDiffCallback(this.daftarNovelVertical, newDaftarNovel)
            )

            this.daftarNovelVertical = newDaftarNovel

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
