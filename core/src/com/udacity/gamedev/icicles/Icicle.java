package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class Icicle {

    public static final String TAG = Icicle.class.getName();

    // TODO: Add a Vector2 position
    Vector2 position;
    Vector2 velocity;
    Viewport viewport;

    // TODO: Add a constructor that sets the position
    public Icicle(Viewport viewport) {
        this.velocity = new Vector2();
        this.viewport = viewport;
        this.position = initPosition();
    }

    private Vector2 initPosition() {
        Random random = new Random();
        return new Vector2(
                random.nextFloat() * (this.viewport.getWorldWidth() - (Constants.ICICLES_WIDTH / 2)),
                this.viewport.getWorldHeight());
    }

    public void update(float delta) {
        velocity.mulAdd(Constants.ICICLES_ACCELERATION, delta);
        position.mulAdd(velocity, delta);
    }

    public boolean isOutOfScreen() {
        if (position.y <= -Constants.ICICLES_HEIGHT) return true;
        return false;
    }

    // TODO: Add a render function that takes a ShapeRenderer

    public void render(ShapeRenderer renderer) {

        // TODO: Set the ShapeRenderer's color
        renderer.setColor(Constants.ICICLE_COLOR);

        // TODO: Set the ShapeType
        renderer.set(ShapeType.Filled);

        // TODO: Draw the icicle using the size constants
        renderer.triangle(
                position.x, position.y,
                position.x - Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT,
                position.x + Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT
        );
    }
}
