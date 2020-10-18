package com.example.madlevel4task2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.game.view.*

class GameAdapter(private val reminders: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return reminders.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(reminders[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun dataBind(game: Game) {
            itemView.tvGameResult.text = game.gameStats
            itemView.tvGameTime.text = game.gameTime.toString()

            Log.d("IMG", game.computerMove.toString())
            Log.d("IMG", game.playerMove.toString())

            when(game.computerMove) {
                "Rock" -> itemView.img_computer.setImageResource(R.drawable.rock)
                "Paper" -> itemView.img_computer.setImageResource(R.drawable.paper)
                "Scissors" -> itemView.img_computer.setImageResource(R.drawable.scissors)
            }

            when(game.playerMove) {
                "Rock" -> itemView.img_player.setImageResource(R.drawable.rock)
                "Paper" -> itemView.img_player.setImageResource(R.drawable.paper)
                "Scissors" -> itemView.img_player.setImageResource(R.drawable.scissors)
            }
        }
    }

}