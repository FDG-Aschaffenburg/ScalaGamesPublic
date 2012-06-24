/**
 * Created with IntelliJ IDEA.
 * User: 41079
 * Date: 15.05.12
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Input;
import org.newdawn.slick.tiled.TiledMap;

public class SimpleGame extends BasicGame{

    private Animation anim;

    private TiledMap map;

    private float x;
    private float y;

    public SimpleGame()
    {
        super("SimpleGame");
    }

    @Override
    public void init(GameContainer gc)
            throws SlickException {
        SpriteSheet sheet = new SpriteSheet("data/homeranim.png", 36, 65);
        this.anim = new Animation();
        for (int i = 0; i < 8; i++) {
            this.anim.addFrame(sheet.getSprite(i, 0), 150);
        }

        // We do not want to many game updates
        gc.setMinimumLogicUpdateInterval(20);
        this.map = new TiledMap("data/firstmap.tmx");
    }

    @Override
    public void update(GameContainer gc, int delta)
            throws SlickException
    {
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_DOWN)) {
            y += 3;
        } else if (input.isKeyDown(Input.KEY_UP)) {
            y -= 3;
        }

        if (input.isKeyDown(Input.KEY_RIGHT)) {
            x += 3;
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            x -= 3;
        }
    }

    public void render(GameContainer gc, Graphics g)
            throws SlickException
    {
        this.map.render(0,0);
        this.anim.draw(this.x, this.y);
    }

    public static void main(String[] args)
            throws SlickException
    {
        AppGameContainer app =
                new AppGameContainer(new SimpleGame());

        app.setDisplayMode(1280, 1024, false);
        app.start();
    }
}
