package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClickEvent(view: View) {
        val selectedButton:Button = view as Button
        var cellId = 0
        when(selectedButton.id){
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }

        playGames(cellId,selectedButton)
        checkWinner()
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    private fun playGames(cellId: Int, selectedButton: Button) {
        if(activePlayer == 1){
            selectedButton.text = "X"
            selectedButton.setBackgroundResource(R.color.red)
            player1.add(cellId)
            activePlayer = 2
            AutoPlay()
        }else{
            selectedButton.text = "O"
            selectedButton.setBackgroundResource(R.color.blue)
            player2.add(cellId)
            activePlayer = 1
        }
        selectedButton.isEnabled = false
    }

    private fun checkWinner(){
        var winner = -1

        //ROW1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        //ROW2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //ROW3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //Column1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //Column2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //Column3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if(winner != -1){
            if (winner == 1){
                Toast.makeText(this,"Player 1 Wins the game", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this,"Player 2 Wins the game", Toast.LENGTH_LONG).show()
            }

        }
    }
    fun AutoPlay(){
        var emptyCell = ArrayList<Int>()

        for (cellId in 1..9){
            if(!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCell.add(cellId)
            }
        }

        val random = Random()
        val randomIndex = random.nextInt(emptyCell.size - 0) + 0
        val cellId = emptyCell.get(randomIndex)

        var selectedButton:Button?
        when(cellId){
            1 -> selectedButton = bu1
            2 -> selectedButton = bu2
            3 -> selectedButton = bu3
            4 -> selectedButton = bu4
            5 -> selectedButton = bu5
            6 -> selectedButton = bu6
            7 -> selectedButton = bu7
            8 -> selectedButton = bu8
            9 -> selectedButton = bu9
            else -> {selectedButton = bu1}
        }

        playGames(cellId,selectedButton)

    }
}
