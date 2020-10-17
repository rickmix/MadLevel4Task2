package com.example.madlevel4task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        played_icon_player.setImageResource(0)
        played_icon_computer.setImageResource(0)
        tv_computer.setVisibility(View.INVISIBLE)
        tv_player.setVisibility(View.INVISIBLE)
        tv_vs.setVisibility(View.INVISIBLE)

        rock_img.setOnClickListener {
            checkWhoWon(selectRock(), computerMove())
        }

        paper_img.setOnClickListener {
            checkWhoWon(selectPaper(), computerMove())
        }

        scissors_img.setOnClickListener {
            checkWhoWon(selectScissors(), computerMove())
        }
    }

    private fun checkWhoWon(player: Move, computer: Move):Boolean {


        tv_computer.setVisibility(View.VISIBLE)
        tv_player.setVisibility(View.VISIBLE)
        tv_vs.setVisibility(View.VISIBLE)

        if(player == computer) {
            //DRAW
            game_finish_txt.text = "DRAW"
            return true
        }

        if(player == Move.Rock && computer == Move.Scissors) {
            //PLAYER WINS
            game_finish_txt.text = "WIN!"
            return true
        }

        if(player == Move.Paper && computer == Move.Rock) {
            //PLAYER WINS
            game_finish_txt.text = "WIN!"
            return true
        }

        if(player == Move.Scissors && computer == Move.Paper) {
            //PLAYER WINS
            game_finish_txt.text = "WIN!"
            return true
        }

        //PLAYER LOSE
        game_finish_txt.text = "LOSE!"
        return false

    }

    private fun selectRock(): Move {
        played_icon_player.setImageResource(R.drawable.rock)
        return Move.Rock
    }

    private fun selectPaper(): Move {
        played_icon_player.setImageResource(R.drawable.paper)
        return Move.Paper
    }

    private fun selectScissors(): Move {
        played_icon_player.setImageResource(R.drawable.scissors)
        return Move.Scissors
    }

    private fun computerMove(): Move {

        val move = Move.values().random()

        when(move) {
            Move.Rock -> played_icon_computer.setImageResource(R.drawable.rock)
            Move.Paper -> played_icon_computer.setImageResource(R.drawable.paper)
            Move.Scissors -> played_icon_computer.setImageResource(R.drawable.scissors)
        }

        return move
    }
}