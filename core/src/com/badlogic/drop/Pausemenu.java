package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class Pausemenu implements Screen {
    final Tankstars game;
    private Texture backgroundImage,

    resumegametexture, savegametexture, restartgametexture;
    private TextureRegion backgroundTexture, resumegametextureregion, savegametextureregion, restartgametextureregion;
    OrthographicCamera camera;

    public Pausemenu(final Tankstars game) {
        this.game = game;

        backgroundImage = new Texture(Gdx.files.internal("pausemenubackground.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);

        resumegametexture = new Texture(Gdx.files.internal("resumegame.jpg"));
        resumegametextureregion = new TextureRegion(resumegametexture, 0, 0, 2412, 850);

        savegametexture = new Texture(Gdx.files.internal("savegame.jpg"));
        savegametextureregion = new TextureRegion(savegametexture, 0, 0, 2412, 850);

        restartgametexture = new Texture(Gdx.files.internal("restartgame.jpg"));
        restartgametextureregion = new TextureRegion(restartgametexture, 0, 0, 2412, 850);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
        game.batch.draw(resumegametextureregion, 290,270, 220, 70);
        game.batch.draw(restartgametextureregion, 290,170, 220, 70);
        game.batch.draw(savegametextureregion, 290,70, 220, 70);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new Savedgamesmenu(game));
            //dispose();
        }

        //TestRunner t=new TestRunner();


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        backgroundImage.dispose();
    }


}
