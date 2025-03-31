package io.github.some_example_name;

import ArcanaFramework.Card.Card;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {

    private SpriteBatch spriteBatch;
    private Texture cardArt;
    private Texture cardBorder;
    private Card<String> testCard;
    private Card<String> testCard2;
    @Override
    public void show() {
        // Prepare your screen here.
        spriteBatch = new SpriteBatch();

        cardArt = new Texture("CardArt/FireLord.jpg");
        cardBorder = new Texture("CardBorder/NT_AMBER.png");



        Vector2 cardPos = new Vector2(150, 150);
        Vector2 cardSize = new Vector2(250, 150);

        Vector2 cardPos2 = new Vector2(300, 150);
        testCard2 = new Card(cardPos2,cardSize,cardArt,cardBorder,"Puto el que lee");

        testCard = new Card(cardPos,cardSize,cardArt,cardBorder,"FireLord");

    }
    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        testCard2.draw(spriteBatch);
        testCard.draw(spriteBatch);

        spriteBatch.end();

        testCard.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        spriteBatch.dispose();
        cardArt.dispose();
        cardBorder.dispose();
    }
}
