package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buClick(View view) throws InterruptedException {
        Button btn = (Button) view;

        int cellID = 0;
        switch (btn.getId()){
            case R.id.btn1:
                cellID=1;
                break;
            case R.id.btn2:
                cellID=2;
                break;
            case R.id.btn3:
                cellID=3;
                break;
            case R.id.btn4:
                cellID=4;
                break;
            case R.id.btn5:
                cellID=5;
                break;
            case R.id.btn6:
                cellID=6;
                break;
            case R.id.btn7:
                cellID=7;
                break;
            case R.id.btn8:
                cellID=8;
                break;
            case R.id.btn9:
                cellID=9;
                break;

        }
        System.out.println(cellID);
        playGame(cellID,btn);
    }
    int activePlayer = 1;
    ArrayList<Integer> Player1 = new ArrayList<>();
    ArrayList<Integer> Player2 = new ArrayList<>();
    public void playGame(int cellId, Button buSelected) throws InterruptedException {


        if(activePlayer == 1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.BLUE);
            Player1.add(cellId);
            System.out.println(Player1.toString());
            activePlayer = 2;
            AutoPlay();

        }
        else if (activePlayer == 2){
            buSelected.setText("O");
            Player2.add(cellId);
            System.out.println(Player2.toString());
            buSelected.setBackgroundColor(Color.GREEN);
            activePlayer = 1;
        }
        buSelected.setEnabled(false);
        CheckWinner();
    }
    public void CheckWinner() throws InterruptedException {
        int Winner =-1;
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3))
            Winner =1;
        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3))
            Winner =2;
        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6))
            Winner =1;
        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6))
            Winner =2;
        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9))
            Winner =1;
        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9))
            Winner =2;
        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7))
            Winner =1;
        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7))
            Winner =2;
        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8))
            Winner =1;
        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8))
            Winner =2;
        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9))
            Winner =1;
        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9))
            Winner =2;

    if(Winner != -1){

        if(Winner == 1){
            System.out.println("1 Wins");
            Toast.makeText(this,"Player 1 Wins",Toast.LENGTH_LONG).show();
          //  Thread.sleep(3000);
            this.recreate();
        }

        if(Winner == 2){
            System.out.println("2 Wins");
            Toast.makeText(this,"Player 2 Wins",Toast.LENGTH_LONG).show();
            //Thread.sleep(3000);
            this.recreate();
        }

    }


    }

    public void AutoPlay() throws InterruptedException {
        ArrayList<Integer> emptyCells = new ArrayList<>();
        for(int i =1 ; i<10;i++){
            if(!(Player1.contains(i) || Player2.contains(i))){
                emptyCells.add(i);
            }
        }
        if(emptyCells.size() == 0){
            this.recreate();
            return;
        }
        Button buSelected;
        Random  r = new Random();
        int RandIndex = r.nextInt(emptyCells.size()-0)+0;
        int cellId = emptyCells.get(RandIndex);

        switch (cellId){
            case 1:
                buSelected = (Button)findViewById(R.id.btn1);
                break;
            case 2:
                buSelected = (Button)findViewById(R.id.btn2);
                break;
            case 3:
                buSelected = (Button)findViewById(R.id.btn3);
                break;
            case 4:
                buSelected = (Button)findViewById(R.id.btn4);
                break;
            case 5:
                buSelected = (Button)findViewById(R.id.btn5);
                break;
            case 6:
                buSelected = (Button)findViewById(R.id.btn6);
                break;
            case 7:
                buSelected = (Button)findViewById(R.id.btn7);
                break;
            case 8:
                buSelected = (Button)findViewById(R.id.btn8);
                break;
            case 9:
                buSelected = (Button)findViewById(R.id.btn9);
                break;
              default:
                  buSelected = (Button)findViewById(R.id.btn1);
        }
        playGame(cellId,buSelected);
    }

}
