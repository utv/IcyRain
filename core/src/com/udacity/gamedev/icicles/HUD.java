package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by Computer on 8/31/2016.
 */
public class HUD {
    ScreenViewport hudViewport;
    SpriteBatch batch;
    BitmapFont font;

    int topScore;

    public HUD() {
        this.topScore = 0;
        hudViewport = new ScreenViewport();
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    }

    public void update(int width, int height) {
        hudViewport.update(width, height, true);
        font.getData().setScale(Math.min(width, height) / Constants.HUD_FONT_REFERENCE_SCREEN_SIZE);
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public void render(int deaths, int score, Constants.Difficulty difficulty) {
        this.topScore = Math.max(score, this.topScore);
        hudViewport.apply();
        batch.setProjectionMatrix(hudViewport.getCamera().combined);
        batch.begin();
        font.draw(batch,"Deaths: " + deaths + "\nDifficulty: " + difficulty.label,
                Constants.HUD_MARGIN,
                hudViewport.getWorldHeight() - Constants.HUD_MARGIN);

        font.draw(batch, "Score: " + score + "\nTop Score: " + this.topScore,
                hudViewport.getWorldWidth() - Constants.HUD_MARGIN, hudViewport.getWorldHeight() - Constants.HUD_MARGIN,
                0, Align.right, false);
        batch.end();
    }

}
