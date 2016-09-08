package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Computer on 8/27/2016.
 */
public class IcyRain {
    public static final String TAG = Icicles.class.getName();

    //List<Icicle> rain;
    DelayedRemovalArray<Icicle> rain;
    Viewport viewport;
    int numIceOffScreen;

    public IcyRain(Viewport viewport) {
        this.viewport = viewport;
        this.numIceOffScreen = 0;
        init();
    }

    public void init() {
        //rain = new ArrayList<Icicle>(Constants.NUM_ICE_PER_SEC);
        numIceOffScreen = 0;
        rain = new DelayedRemovalArray<Icicle>(false, 100);
    }

    public void update(float delta, Constants.Difficulty difficulty) {
        if (MathUtils.random() < delta * difficulty.numIcePerSec) {
            rain.add(new Icicle(this.viewport));
        }

        for (Icicle ice : rain) {
            ice.update(delta);
        }

        rain.begin();
        for (int i = 0; i < rain.size; i++) {
            if (rain.get(i).isOutOfScreen()) {
                rain.removeIndex(i);
                numIceOffScreen++;
            }

        }
        rain.end();

    }

    public void render(ShapeRenderer renderer) {
        for (Icicle ice : rain) {
            ice.render(renderer);
        }
    }
}
