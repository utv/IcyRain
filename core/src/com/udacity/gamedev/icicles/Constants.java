package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;


public class Constants {
    public static final float WORLD_SIZE = 10.0f;
    public static final Color BACKGROUND_COLOR = Color.BLUE;

    // TODO: Add constant for player head radius
    public static final float PLAYER_HEAD_RADIUS = 0.5f;


    // TODO: Add constant for player head height
    public static final float PLAYER_HEAD_HEIGHT =  4.0f * PLAYER_HEAD_RADIUS;

    public static final float PLAYER_ARMS_LENGTH = 2 * PLAYER_HEAD_RADIUS;


    // TODO: Add constant for player limb width
    public static final float PLAYER_LIMB_WIDTH = 0.1f;


    // TODO: Add constant for circle segments for the player's head
    public static final int PLAYER_HEAD_SEGMENTS = 30;


    // TODO: Add constant for the player's color
    public static final Color PLAYER_COLOR = Color.BLACK;

    public static final float PLAYER_VELOCITY = 10.0f;


    public static final float ICICLES_HEIGHT = 1.0f;
    public static final float ICICLES_WIDTH = 0.5f;
    public static final Color ICICLE_COLOR = Color.WHITE;
    public static final float ICICLE_VELOCITY = 2.0f;
    public static final Vector2 ICICLES_ACCELERATION = new Vector2(0, -5.0f);

    public static final float NUM_ICE_PER_SEC = 10.0f;
    public static final float EASY_ICE_PER_SEC = 10.0f;
    public static final float MEDIUM_ICE_PER_SEC = 15.0f;
    public static final float HARD_ICE_PER_SEC = 20.0f;
    public static final String EASY_LABEL = "Easy";
    public static final String MEDIUM_LABEL = "Medium";
    public static final String HARD_LABEL = "Hard";

    // TODO: Add screen reference size for scaling the HUD (480 works well)
    public static final float HUD_FONT_REFERENCE_SCREEN_SIZE = 480.0f;

    // TODO: Add constant for the margin between the HUD and screen edge
    public static final float HUD_MARGIN = 20.0f;

    // Difficulty screen
    public static final float DIFFICULTY_WORLD_SIZE = 480.0f;
    public static final Vector2 EASY_CENTER =  new Vector2(DIFFICULTY_WORLD_SIZE / 4, DIFFICULTY_WORLD_SIZE / 2);
    public static final float DIFFICULTY_LABEL_SCALE = 1.5f;
    public static final float BUTTON_RADIUS = DIFFICULTY_WORLD_SIZE / 9;
    public static final int BUTTON_SEGMENTS = 30;
    public enum Difficulty {
        EASY(EASY_ICE_PER_SEC, EASY_LABEL),
        MEDIUM(MEDIUM_ICE_PER_SEC, MEDIUM_LABEL),
        HARD(HARD_ICE_PER_SEC, HARD_LABEL);

        float numIcePerSec;
        String label;

        Difficulty(float rate, String label) {
            numIcePerSec = rate;
            this.label = label;
        }
    }

}
