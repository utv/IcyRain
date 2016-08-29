package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Computer on 8/27/2016.
 */
public class IcyRain {
    public static final String TAG = Icicles.class.getName();

    List<Icicle> rain;
    Viewport viewport;

    public IcyRain(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        rain = new ArrayList<Icicle>(Constants.NUM_ICE_PER_SEC);
    }

    public void update(float delta) {
        if (rain.isEmpty()) {
            for (int i = 0; i < Constants.NUM_ICE_PER_SEC; i++) {
                rain.add(new Icicle(this.viewport));
            }
        }

        for (Icicle ice : rain) {
            ice.update(delta);
        }
    }

    public void render(ShapeRenderer renderer) {
        for (Icicle ice : rain) {
            ice.render(renderer);
        }
    }
}
