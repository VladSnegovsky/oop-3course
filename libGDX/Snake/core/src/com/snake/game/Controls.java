package com.snake.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Controls{
    private int currentState = 0;//0 1 2 3 up down left right
    private int nextState = 0;

    private Vector2 touch = new Vector2();

    private Rectangle upBox = new Rectangle(235, 265, 130, 130);
    private Rectangle downBox = new Rectangle(235, 5, 130, 130);
    private Rectangle leftBox = new Rectangle(105, 135, 130, 130);
    private Rectangle rightBox = new Rectangle(365, 135, 130, 130);

    private Rectangle AIBox = new Rectangle(0, 330, 120, 60);
    private boolean AI_play = false;
    private boolean next_changed = false;

    public void update(Viewport viewport, float accelX, int body_x, int body_y, int food_x, int food_y, int body_lenght, Queue<BodyPart> mBody){
        if (Gdx.input.isTouched()){
            touch.x = Gdx.input.getX();
            touch.y = Gdx.input.getY();
            viewport.unproject(touch);
        }

        next_changed = false;

        if (AI_play){
            if (currentState == 1){
                for (int i = 0; i < mBody.size-1; i++){
                    if (mBody.get(i).getX() == mBody.last().getX() && mBody.get(i).getY() == mBody.last().getY()-2){
                        nextState = 3;
                        next_changed = true;
                    }
                }
                if(!next_changed){
                    if (body_y == food_y){
                        if (body_x < food_x){ nextState = 3; }
                        else if (body_x > food_x) { nextState = 2; }
                    }
                }
            }
            else if (currentState == 0){
                for (int i = 0; i < mBody.size-1; i++){
                    if (mBody.get(i).getX() == mBody.last().getX() && mBody.get(i).getY() == mBody.last().getY()+2){
                        nextState = 2;
                        next_changed = true;
                    }
                }
                if (!next_changed){
                    if (body_y == food_y){
                        if (body_x < food_x){ nextState = 3; }
                        else if (body_x > food_x) { nextState = 2; }
                    }
                }
            }
            else if (currentState == 2){
                for (int i = 0; i < mBody.size-1; i++){
                    if (mBody.get(i).getX() == mBody.last().getX()-2 && mBody.get(i).getY() == mBody.last().getY()+2){
                        nextState = 0;
                        next_changed = true;
                    }
                }
                if (!next_changed){
                    if (body_x == food_x){
                        if (body_y < food_y){ nextState = 0; }
                        else if (body_y > food_y){ nextState = 1; }
                    }
                }
            }
            else if (currentState == 3){
                for (int i = 0; i < mBody.size-1; i++){
                    if (mBody.get(i).getX() == mBody.last().getX()+2 && mBody.get(i).getY() == mBody.last().getY()+2){
                        nextState = 1;
                        next_changed = true;
                    }
                }
                if (!next_changed){
                    if (body_x == food_x){
                        if (body_y < food_y){ nextState = 0; }
                        else if (body_y > food_y){ nextState = 1; }
                    }
                }
            }
        }
        else {
            if (accelX < -3f){
                if (currentState == 0)
                    nextState = 3;
                else if (currentState == 1)
                    nextState = 2;
                else if (currentState == 2)
                    nextState = 0;
                else if (currentState == 3)
                    nextState = 1;
            }
            else if (accelX > 3f){
                if (currentState == 0)
                    nextState = 2;
                else if (currentState == 1)
                    nextState = 3;
                else if (currentState == 2)
                    nextState = 1;
                else if (currentState == 3)
                    nextState = 0;
            }
            else {
                if ((Gdx.input.isKeyPressed(Input.Keys.UP) || upBox.contains(touch))
                        && currentState != 1) nextState = 0;
                else if ((Gdx.input.isKeyPressed(Input.Keys.DOWN) || downBox.contains(touch))
                        && currentState != 0) nextState = 1;
                else if ((Gdx.input.isKeyPressed(Input.Keys.LEFT) || leftBox.contains(touch))
                        && currentState != 3) nextState = 2;
                else if ((Gdx.input.isKeyPressed(Input.Keys.RIGHT) || rightBox.contains(touch))
                        && currentState != 2) nextState = 3;
                else if (AIBox.contains(touch)){
                    AI_play = true;
                }
            }
        }
    }

    public int getNextState(){
        currentState = nextState;
        return nextState;
    }
}
