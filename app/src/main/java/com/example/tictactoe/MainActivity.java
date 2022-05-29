package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClicked=-1;
    int player=1;//player1 is hammer
    int[][] winningStates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[] gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void reset(View view){
        androidx.gridlayout.widget.GridLayout gridLayout=findViewById(R.id.gridLayout);
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v=(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
            gameState[i]=-1;
        }
        isWinner=false;
        imageClicked=-1;
        player=1;
    }

    public void load(View view){
        ImageView v=(ImageView) view;
        int tag=Integer.parseInt(v.getTag().toString());
        imageClicked=gameState[tag];
        if(isWinner==false && imageClicked==-1){
        if(player==1){
        v.setImageResource(R.drawable.hammer);
        gameState[tag]=player;
        player=0;
            Toast.makeText(this, tag+" cross",Toast.LENGTH_SHORT).show();
        }
        else{
            v.setImageResource(R.drawable.ss);
            gameState[tag]=player;
            player=1;
            Toast.makeText(this, tag+" zero",Toast.LENGTH_SHORT).show();
        }
        for(int i=0;i<winningStates.length;i++){
            if(gameState[winningStates[i][0]]==gameState[winningStates[i][1]] && gameState[winningStates[i][1]]==gameState[winningStates[i][2]] && gameState[winningStates[i][0]]>-1){
                Toast.makeText(this,"Winner is "+(player==0?1:2),Toast.LENGTH_SHORT).show();
                isWinner=true;
        }}
    }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}