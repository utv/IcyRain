package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;



public class IciclesScreen extends InputAdapter implements Screen {

    public static final String TAG = IciclesScreen.class.getName();

    ExtendViewport iciclesViewport;
    ShapeRenderer renderer;

    // TODO: Add a Player (complete Player.java first)
    Player player;
    IcyRain icyRain;
    HUD hud;
    Constants.Difficulty difficulty;

    IciclesGame game;

    public IciclesScreen(IciclesGame game, Constants.Difficulty difficulty) {
        this.game = game;
        this.difficulty = difficulty;
    }

    @Override
    public void show() {
        iciclesViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        Gdx.input.setInputProcessor(this);

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        // TODO: Initialize the player
        player = new Player(iciclesViewport);
        icyRain = new IcyRain(iciclesViewport);
        hud = new HUD();

    }

    @Override
    public void resize(int width, int height) {
        iciclesViewport.update(width, height, true);
        hud.update(width, height);
        // TODO: Reset the player (using init())
        player.init();
        icyRain.init();
    }

    @Override
    public void dispose() {
        renderer.dispose();
        hud.dispose();
    }


    @Override
    public void render(float delta) {
        player.update(delta);
        icyRain.update(delta, this.difficulty);
        if (player.isHit(icyRain)) {
            icyRain.init();
        }
        

        iciclesViewport.apply(true);
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(iciclesViewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);

        hud.render(player.deaths, icyRain.numIceOffScreen, this.difficulty);
        icyRain.render(renderer);
        player.render(renderer);
        renderer.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        renderer.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.showDifficultyScreen();
        return true;
    }
}
