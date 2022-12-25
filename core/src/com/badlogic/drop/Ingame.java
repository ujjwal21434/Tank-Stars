package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.Thread.sleep;

public class Ingame implements Screen {
    final Tankstars game;
    private Texture missile,backgroundImage,move1texture, move2texture, tank1texture, tank2texture, pausetexture, health1texture, health2texture, firebuttontexture;
    private TextureRegion backgroundTexture, shooterbacktextureregion, shootertextureregion, tank1textureregion, tank2textureregion, pausetextureregion, health1textureregion, health2textureregion, firebuttontextureregion;
    OrthographicCamera camera;
    float x,y;
    Rectangle tank1,tank2,move1,move2,missilerec;

    public Ingame(final Tankstars game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("ingame1.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1237, 696);

        tank1=new Rectangle();
        tank2=new Rectangle();
        move1=new Rectangle();
        move2=new Rectangle();
        missilerec=new Rectangle();

        tank1.x=70;
        tank1.y=20;
        tank1.width=110;
        tank1.height=110;

        tank2.x=600;
        tank2.y=42;
        tank2.width=110;
        tank2.height=75;

        move1.x=150;
        move1.y=12;
        move1.width=80;
        move1.height=34;

        move2.x=510;
        move2.y=12;
        move2.width=80;
        move2.height=34;

        missilerec.x=tank1.x+100;
        missilerec.y=30;
        missilerec.width=110;
        missilerec.height=110;






        tank1texture = new Texture(Gdx.files.internal("tank1.png"));

        move1texture = new Texture(Gdx.files.internal("move.jpg"));
        //tank1textureregion = new TextureRegion(tank1texture, 0, 0, 480, 480);

        tank2texture = new Texture(Gdx.files.internal("tank2.png"));
        missile = new Texture(Gdx.files.internal("missile.png"));
        //tank2textureregion = new TextureRegion(tank2texture, 0, 0, 280, 147);

        pausetexture = new Texture(Gdx.files.internal("pause.png"));
        pausetextureregion = new TextureRegion(pausetexture, 0, 0, 512, 512);

        health1texture = new Texture(Gdx.files.internal("heart6.png"));
        health1textureregion = new TextureRegion(health1texture, 0, 0, 333, 312);

        health2texture = new Texture(Gdx.files.internal("heart8.png"));
        health2textureregion = new TextureRegion(health2texture, 0, 0, 337, 292);

        firebuttontexture = new Texture(Gdx.files.internal("fire.jpg"));
        firebuttontextureregion = new TextureRegion(firebuttontexture, 0, 0, 122, 53);

        //shootertexture = new Texture(Gdx.files.internal("shooter.png"));
        //shootertextureregion = new TextureRegion(shootertexture, 0, 0, 800, 800);

        //shooterbacktexture = new Texture(Gdx.files.internal("shooterback.png"));
        //shooterbacktextureregion = new TextureRegion(shooterbacktexture, 0, 0, 608, 640);


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
        //game.batch.draw(tank1textureregion, 70,20, 110, 110);
        game.batch.draw(tank1texture, tank1.x, tank1.y, tank1.width, tank1.height);
        game.batch.draw(tank2texture, tank2.x, tank2.y, tank2.width, tank2.height);
        game.batch.draw(move1texture, move1.x, move1.y, move1.width, move1.height);
        game.batch.draw(move1texture, move2.x, move2.y, move2.width, move2.height);
        //game.batch.draw(tank2textureregion, 630,50, 90, 50);
        game.batch.draw(pausetextureregion, 12,420, 50, 50);
        game.batch.draw(health1texture, 180,425, 50, 50);
        game.batch.draw(health2texture, 557,425, 50, 50);
        game.batch.draw(firebuttontextureregion, 360,6, 60, 30);
        //game.batch.draw(shooterbacktextureregion, 510,10, 50, 50);
        //game.batch.draw(shootertextureregion, 503,3, 63, 65);

        game.font.draw(game.batch, "Tank 1", 183, 420);
        game.font.draw(game.batch, "Tank 2", 560, 420);

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




            if(x > 14 && x < 58 && y > 13 && y < 58){
                game.setScreen(new Pausemenu(game));
            }

            else if(x > 149 && x < 172 && y > 432 && y < 462){
                tank1.x -= 200 * Gdx.graphics.getDeltaTime();
            }

            else if(x > 211 && x < 228 && y > 435 && y < 465){
                tank1.x += 200 * Gdx.graphics.getDeltaTime();

            }

            else if(x > 510 && x < 533 && y > 432 && y < 462){
                tank2.x -= 200 * Gdx.graphics.getDeltaTime();

            }

            else if(x > 570 && x < 588 && y > 432 && y < 462){
                tank2.x += 200 * Gdx.graphics.getDeltaTime();

            }

            else if(x > 87 && y < 360){
                game.setScreen(new Winner1(game));
            }

            else if(x > 362 && x < 418 && y > 444 && y < 471){
                game.batch.begin();
                game.batch.draw(missile, missilerec.x, missilerec.y, missilerec.width, missilerec.height);
                game.batch.end();
                missilerec.x += (tank2.x-tank1.x) * Gdx.graphics.getDeltaTime();
                ;
                ;
                ;
                missilerec.x=tank1.x+100;

            }



            //dispose();
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
