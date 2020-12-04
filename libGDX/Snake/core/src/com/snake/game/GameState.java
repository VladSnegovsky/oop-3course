package com.snake.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameState {
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Queue<BodyPart> mBody = new Queue<BodyPart>();

    private Controls controls = new Controls();

    private float mTimer = 0;

    private final int boardWidth;
    private final int boardSize = 30;
    private final int yStart = 400;

    private Food mFood;
    private int length = 20;

    public GameState(int width){
        this.boardWidth = width;
        mFood = new Food(boardSize);
        mBody.addLast(new BodyPart(15, 15, boardSize));
        mBody.addLast(new BodyPart(15, 16, boardSize));
        mBody.addLast(new BodyPart(15, 17, boardSize));
    }

    private void advance(){
        switch (controls.getNextState()){
            case 0: mBody.addLast(new BodyPart(mBody.last().getX(), mBody.last().getY()+1, boardSize));
                break;
            case 1: mBody.addLast(new BodyPart(mBody.last().getX(), mBody.last().getY()-1, boardSize));
                break;
            case 2: mBody.addLast(new BodyPart(mBody.last().getX()-1, mBody.last().getY(), boardSize));
                break;
            case 3: mBody.addLast(new BodyPart(mBody.last().getX()+1, mBody.last().getY(), boardSize));
                break;
            default: mBody.addLast(new BodyPart(mBody.last().getX(), mBody.last().getY()+1, boardSize));
                break;
        }

        if (mBody.last().getX() == mFood.getX() && mBody.last().getY() == mFood.getY()){
            mFood.randomisePos();
            this.length++;
        }

        for (int i = 0; i < mBody.size-1; i++){
            if (mBody.get(i).getX() == mBody.last().getX() && mBody.get(i).getY() == mBody.last().getY()){
                length = 3;
            }
        }

        while (mBody.size-1 >= length) {
            mBody.removeFirst();
        }
    }

    public void update(float delta, Viewport viewport, float accelX){
        mTimer += delta;
        controls.update(viewport, accelX, mBody.last().getX(), mBody.last().getY(), mFood.getX(), mFood.getY(), length, mBody);
        if (mTimer > 0.10f) {
            advance();
            mTimer = 0;
        }
    }

    public void draw(OrthographicCamera camera){
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(0, yStart, boardWidth, boardWidth);

        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(0+5, yStart+5, boardWidth-10, boardWidth-10);

        shapeRenderer.setColor(Color.WHITE);
        float scaleVal = boardWidth/boardSize;

        for (BodyPart bp : mBody){
            shapeRenderer.rect(bp.getX()*scaleVal, yStart+bp.getY()*scaleVal, scaleVal, scaleVal);
        }

        shapeRenderer.rect(mFood.getX()*scaleVal, yStart+mFood.getY()*scaleVal, scaleVal, scaleVal);

        shapeRenderer.rect(235, 265, 130, 130);
        shapeRenderer.rect(235, 5, 130, 130);
        shapeRenderer.rect(105, 135, 130, 130);
        shapeRenderer.rect(365, 135, 130, 130);

        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(0, 330, 120, 60);

        shapeRenderer.end();
    }
}
