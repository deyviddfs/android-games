package br.com.deyvidfernandes.games

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.deyvidfernandes.games.databinding.ActivityGameInfoBinding

class GameInfoActivity : AppCompatActivity(){
    lateinit var binding: ActivityGameInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}