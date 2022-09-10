package br.com.deyvidfernandes.games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.deyvidfernandes.games.adapter.GameAdapter
import br.com.deyvidfernandes.games.databinding.ActivityMainBinding
import br.com.deyvidfernandes.games.network.Game

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val result = listOf(Game("521", "Diablo Immortal", "https://www.freetogame.com/g/521/thumbnail.jpg"),
                        Game("521", "Diablo Immortal", "https://www.freetogame.com/g/521/thumbnail.jpg"),
                        Game("521", "Diablo Immortal", "https://www.freetogame.com/g/521/thumbnail.jpg"),
                        Game("521", "Diablo Immortal", "https://www.freetogame.com/g/521/thumbnail.jpg"),
                        Game("521", "Diablo Immortal", "https://www.freetogame.com/g/521/thumbnail.jpg"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerView.adapter = GameAdapter(result)
    }
}