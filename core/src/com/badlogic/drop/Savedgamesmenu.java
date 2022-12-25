package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class Savedgamesmenu implements Screen {
    final Tankstars game;
    private Texture backgroundImage, heart6texture, heart8texture, savedgame1buttontexture, savedgame2buttontexture, savedgame3buttontexture, savedgame4buttontexture;
    private TextureRegion backgroundTexture, heart6textureregion, heart8textureregion,savedgame1buttontextureregion, savedgame2buttontextureregion, savedgame3buttontextureregion, savedgame4buttontextureregion;
    OrthographicCamera camera;

    public Savedgamesmenu(final Tankstars game) {
        this.game = game;

        backgroundImage = new Texture(Gdx.files.internal("savedgamesbackground.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);

        savedgame1buttontexture = new Texture(Gdx.files.internal("game1button.jpg"));
        savedgame1buttontextureregion = new TextureRegion(savedgame1buttontexture, 0, 0, 2412, 850);

        savedgame2buttontexture = new Texture(Gdx.files.internal("game2button.jpg"));
        savedgame2buttontextureregion = new TextureRegion(savedgame2buttontexture, 0, 0, 2412, 850);

        savedgame3buttontexture = new Texture(Gdx.files.internal("game3button.jpg"));
        savedgame3buttontextureregion = new TextureRegion(savedgame3buttontexture, 0, 0, 2412, 850);

        savedgame4buttontexture = new Texture(Gdx.files.internal("game4button.jpg"));
        savedgame4buttontextureregion = new TextureRegion(savedgame4buttontexture, 0, 0, 2412, 850);

        heart6texture = new Texture(Gdx.files.internal("heart6.png"));
        heart6textureregion = new TextureRegion(heart6texture, 0, 0, 333, 312);

        heart8texture = new Texture(Gdx.files.internal("heart8.png"));
        heart8textureregion = new TextureRegion(heart8texture, 0, 0, 337, 292);


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
        game.batch.draw(savedgame1buttontextureregion, 510,290, 270, 70);
        game.batch.draw(savedgame2buttontextureregion, 510,200, 270, 70);
        game.batch.draw(savedgame3buttontextureregion, 510,110, 270, 70);
        game.batch.draw(savedgame4buttontextureregion, 510,20, 270, 70);
        game.batch.draw(heart6textureregion, 538,299, 19, 19);
        game.batch.draw(heart8textureregion, 721,299, 22, 19);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new Winner1(game));
            dispose();
        }

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
