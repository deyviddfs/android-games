package br.com.deyvidfernandes.games

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.deyvidfernandes.games.databinding.ActivityGameInfoBinding
import br.com.deyvidfernandes.games.model.GameInfo
import br.com.deyvidfernandes.games.network.GameApi
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GameInfoActivity : AppCompatActivity(){
    lateinit var binding: ActivityGameInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("EXTRA_GAME_ID")

        if (id != null){
            loadGameInfo(id)
        }
    }

    private fun loadGameInfo(id: String){
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            try {
                val result = GameApi.RETROFIT_SERVICE.getGame(id)

                withContext(Dispatchers.Main){
                    updateUI(result)
                }
            }catch (e: Exception){
                Log.e("Error", "Falha: ${e.message}")
            }
        }
    }

    private fun updateUI(gameInfo: GameInfo){
        binding.textViewTitle.text = gameInfo.title
        Picasso.get().load(gameInfo.pathImg).resize(800, 500).into(binding.imageViewDemo)
        binding.textViewShortDescription.text = gameInfo.shorDescription
        binding.textViewDescription.text = gameInfo.description
        binding.textViewPlatform.text = gameInfo.platform
        binding.textViewDeveloper.text = gameInfo.developer
        binding.textViewReleaseDate.text = gameInfo.releaseDate
    }
}