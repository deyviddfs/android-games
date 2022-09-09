package br.com.deyvidfernandes.games.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.deyvidfernandes.games.GameInfoActivity
import br.com.deyvidfernandes.games.R
import br.com.deyvidfernandes.games.network.Game
import com.squareup.picasso.Picasso

class GameAdapter(private val dataSet: List<Game>): RecyclerView.Adapter<GameAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var textViewTitle: TextView
        var imageViewDemo: ImageView

        init {
            textViewTitle = view.findViewById(R.id.textViewTitle)
            imageViewDemo = view.findViewById(R.id.imageViewDemo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_games_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = dataSet[position]
        holder.textViewTitle.text = item.title
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, GameInfoActivity::class.java).apply {
                putExtra("EXTRA_GAME_ID", item.id)
            }
            holder.itemView.context.startActivity(intent)
        }
        Log.i("PICASSO", item.pathImg)
        Picasso.get().load(item.pathImg).into(holder.imageViewDemo)
    }

    override fun getItemCount() = dataSet.size
}