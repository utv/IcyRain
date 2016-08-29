package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player {

    public static final String TAG = Player.class.getName();

    // TODO: Add a position (add constants to Constants.java first)
    Vector2 position;

    // TODO: Add a viewport
    Viewport viewport;
    private float velocity = Constants.PLAYER_VELOCITY;

    // TODO: Add constructor that accepts and sets the viewport, then calls init()
    public Player(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    // TODO: Add init() function that moves the character to the bottom center of the screen
    public void init() {
//        position = new Vector2(Constants.WORLD_SIZE / 2, Constants.WORLD_SIZE / 10);
        position = new Vector2(viewport.getWorldWidth() / 2, Constants.PLAYER_HEAD_HEIGHT);
    }


    // TODO: Create a render function that accepts a ShapeRenderer and does the actual drawing
    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.PLAYER_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.circle(position.x, position.y, Constants.PLAYER_HEAD_RADIUS, Constants.PLAYER_HEAD_SEGMENTS);

        Vector2 torsoTop = new Vector2(position.x, position.y -  Constants.PLAYER_HEAD_RADIUS);
        Vector2 torsoBottom = new Vector2(torsoTop.x, torsoTop.y - 2 * Constants.PLAYER_HEAD_RADIUS);

        renderer.rectLine(torsoTop, torsoBottom, Constants.PLAYER_LIMB_WIDTH);

        float LIMB_LEN = torsoBottom.y;
        // Arms
        Vector2 leftHand = new Vector2(torsoTop.x - LIMB_LEN, torsoTop.y - LIMB_LEN);
        Vector2 rightHand = new Vector2(torsoBottom.x + LIMB_LEN, torsoTop.y - LIMB_LEN);
        renderer.rectLine(torsoTop, leftHand, Constants.PLAYER_LIMB_WIDTH);
        renderer.rectLine(torsoTop, rightHand, Constants.PLAYER_LIMB_WIDTH);
        // Legs
        Vector2 leftLeg = new Vector2(torsoBottom.x - torsoBottom.y, 0);
        Vector2 rightLeg = new Vector2(torsoBottom.x + torsoBottom.y, 0);
        renderer.rectLine(torsoBottom, leftLeg, Constants.PLAYER_LIMB_WIDTH);
        renderer.rectLine(torsoBottom, rightLeg, Constants.PLAYER_LIMB_WIDTH);

    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.position.x -= this.velocity * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.position.x += this.velocity * delta;
        }

        ensureInBounds();

    }

    private void ensureInBounds() {
        this.position.x = Math.min(this.position.x, viewport.getWorldWidth() - Constants.PLAYER_HEAD_RADIUS);
        this.position.x = Math.max(this.position.x, Constants.PLAYER_HEAD_RADIUS);
    }
}
