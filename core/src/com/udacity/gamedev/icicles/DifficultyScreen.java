package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

import javafx.scene.paint.Color;

import static com.udacity.gamedev.icicles.Constants.*;


public class DifficultyScreen extends InputAdapter implements Screen {

    public static final String TAG = DifficultyScreen.class.getName();
    FitViewport viewport;
    ShapeRenderer renderer;

    SpriteBatch batch;
    BitmapFont font;
    IciclesGame game;

    public DifficultyScreen(IciclesGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        renderer = new ShapeRenderer();

        viewport = new FitViewport(DIFFICULTY_WORLD_SIZE, DIFFICULTY_WORLD_SIZE);
        Gdx.input.setInputProcessor(this);

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(DIFFICULTY_LABEL_SCALE);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.setColor(com.badlogic.gdx.graphics.Color.BLACK);
    }

    @Override
    public void render(float delta) {
        viewport.apply(true);
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r, BACKGROUND_COLOR.g, BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        
        renderer.setColor(ICICLE_COLOR);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.circle(EASY_CENTER.x, EASY_CENTER.y, BUTTON_RADIUS, BUTTON_SEGMENTS);
        renderer.end();

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        final GlyphLayout easyLayout = new GlyphLayout(font, EASY_LABEL);
        font.draw(batch,EASY_LABEL,EASY_CENTER.x, EASY_CENTER.y + easyLayout.height / 2, 0,Align.center, false);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);

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
        batch.dispose();
        font.dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 clickPoint = new Vector2(screenX, screenY);
        Vector2 worldTouch = viewport.unproject(clickPoint);
        if (worldTouch.dst(EASY_CENTER) < BUTTON_RADIUS)
            game.showIcicleScreen(Difficulty.EASY);
        return true;
    }
}
