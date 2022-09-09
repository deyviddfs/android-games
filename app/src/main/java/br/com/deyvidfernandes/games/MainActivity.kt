package br.com.deyvidfernandes.games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import br.com.deyvidfernandes.games.adapter.GameAdapter
import br.com.deyvidfernandes.games.databinding.ActivityMainBinding
import br.com.deyvidfernandes.games.network.Game
import br.com.deyvidfernandes.games.network.GameApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadGames()
    }

    private fun loadGames(){
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            try {
                val service = GameApi.RETROFIT_SERVICE.getGames()

                withContext(Dispatchers.Main){
                    updateUI(service)
                }
            }catch (e: Exception){
                Log.e("RETROFIT", "Falha: ${e.message}")
            }
        }
    }

    private fun updateUI(result: List<Game>){
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerView.adapter = GameAdapter(result)
    }
}