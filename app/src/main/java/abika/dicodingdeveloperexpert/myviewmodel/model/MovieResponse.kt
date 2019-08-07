package abika.dicodingdeveloperexpert.myviewmodel.model

import abika.dicodingdeveloperexpert.myviewmodel.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

data class MovieResponse ( val data: List<MovieItem>): RecyclerView.Adapter<MovieResponse.MyHolder>(){
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(get: MovieItem){
            itemView.iv_movie_title.text = get.title
            Picasso.get().load(get.poster_path)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(itemView.iv_movie_poster)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun getItemCount(): Int {
        return data.size ?: 0
        //ketika data sizenya null isinya akan 0
        //terneri function
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindView(data.get(position))
    }
}