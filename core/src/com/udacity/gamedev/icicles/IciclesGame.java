package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Game;


public class IciclesGame extends Game {

    IciclesScreen iciclesScreen;
    DifficultyScreen difficultyScreen;

    //TODO: call setScreen() with a new IciclesScreen()
    @Override
    public void create() {
        showDifficultyScreen();
    }

    public void showIcicleScreen(Constants.Difficulty difficulty) {
        setScreen(new IciclesScreen(this, difficulty));
    }

    public void showDifficultyScreen() {
        setScreen(new DifficultyScreen(this));
    }


}
