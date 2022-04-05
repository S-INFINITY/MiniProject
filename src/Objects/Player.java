package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends ControllableGameObject {

    public BufferedImage[] player_img = new BufferedImage[4];

    public Player(float x, float y, ID id) {
        super(x, y, id, "/res/players/spritesheet_players");
        velX = 1;
        this.sprite = spriteSheetController.grabImage("alienBlue_front.png");
    }

    public void tick() {
        this.x += velX;
        this.y += velY;

    }

    public void render(Graphics g) {
        g.drawImage(this.sprite, (int) this.x, (int) this.y, null);

    }

    public void handleKeyPress(int key) {
        // TODO Auto-generated method stub

    }

    public void handleKeyRelease(int key) {
        // TODO Auto-generated method stub

    }

}
