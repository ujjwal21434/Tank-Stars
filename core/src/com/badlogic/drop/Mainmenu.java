package com.badlogic.drop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class Mainmenu implements Screen, InputProcessor, ApplicationListener {


    final Tankstars game;
    private Texture backgroundImage, startnewgamelogoimage, savedgameslogoimage, exitlogoimage;
    private TextureRegion backgroundTexture, startnewgamelogotexture, savedgameslogotexture, exitlogotexture;
    Music introMusic;
    OrthographicCamera camera;
    float x,y;




    public Mainmenu(final Tankstars game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("mainmenu.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);

        startnewgamelogoimage = new Texture(Gdx.files.internal("startnewgame.jpg"));
        startnewgamelogotexture = new TextureRegion(startnewgamelogoimage, 0, 0, 2700, 850);

        savedgameslogoimage = new Texture(Gdx.files.internal("savedgames.jpg"));
        savedgameslogotexture = new TextureRegion(savedgameslogoimage, 0, 0, 2700, 850);

        exitlogoimage = new Texture(Gdx.files.internal("exit.jpg"));
        exitlogotexture = new TextureRegion(exitlogoimage, 0, 0, 2700, 850);

        introMusic = Gdx.audio.newMusic(Gdx.files.internal("intro.mp3"));
        introMusic.setLooping(true);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }



    @Override
    public void show() {

        introMusic.play();
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
        game.batch.draw(startnewgamelogotexture,510,330,300,80);
        game.batch.draw(savedgameslogotexture,510,210,300,80);
        game.batch.draw(exitlogotexture,510,90,300,80);
        game.batch.end();



        if (Gdx.input.isTouched()) {
            x=Gdx.input.getX();
            y=Gdx.input.getY();

            //System.out.println("x=");
            //System.out.print(x);
            //System.out.println();
            //System.out.println("y=");
            //System.out.print(y);
            //System.out.println();

            //Vector3 worldCoords = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            //camera.unproject(worldCoords);
            //x = worldCoords.x;
            //y = worldCoords.y;

            if(x > 514 && x < 769 && y > 73 && y < 140){
                game.setScreen(new Ingame(game));
            }

            if (x > 514 && x < 769 && y > 191 && y < 260)
                game.setScreen(new Savedgamesmenu(game));

            else if (x > 514 && x < 769 && y > 313 && y < 381)
                Gdx.app.exit();
        }
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

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
        introMusic.dispose();
        backgroundImage.dispose();
        savedgameslogoimage.dispose();
        startnewgamelogoimage.dispose();
        exitlogoimage.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        //Vector3 worldCoords = new Vector3(screenX, screenY, 0);
        //camera.unproject(worldCoords);

        //float x = worldCoords.x;
        //float y = worldCoords.y;

        // check if the click occurred within the desired region
        //if (x > 510 && x < 810 && y > 210 && y < 290) {
         //   game.setScreen(new Ingame(game));
          //  return true;
        //}


        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
