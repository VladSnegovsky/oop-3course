package com.snake.game;

import com.badlogic.gdx.math.MathUtils;

public class Food {
    private int x;
    private int y;
    private int boardSize;

    public Food(int boardSize){
        this.boardSize = boardSize;
        randomisePos();
    }

    public void randomisePos(){
        x = MathUtils.random(boardSize-1);
        y = MathUtils.random(boardSize-1);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
