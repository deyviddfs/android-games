package br.com.deyvidfernandes.games.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.deyvidfernandes.games.R
import br.com.deyvidfernandes.games.network.Game

class GameAdapter(private val dataSet: List<Game>): RecyclerView.Adapter<GameAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        //TODO: criar referencia dos objetos do recyclerview
        init {
            //TODO: instanciar os objetos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_games_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = dataSet[position]
        //Implementar De/Para
    }

    override fun getItemCount() = dataSet.size
}