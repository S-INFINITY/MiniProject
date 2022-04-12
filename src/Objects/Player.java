package Objects;

import java.awt.Graphics;

import Objects.Abstract.GameObject;
import Objects.AssetController.Animation;

public class Player extends GameObject {

    Animation duck;
    Animation walk;
    Animation climb;
    Animation hit;
    Animation jump;
    Animation stand;
    Animation swim;

    Animation currentAnimation;

    int upKeyCode = 87;
    int downKeyCode = 83;
    int leftKeyCode = 65;
    int rightKeyCode = 68;

    int jumpKeyCode = 32;
    int duckKeyCode = 16;

    boolean jumping = false;

    // TODO make this a hashmap or something cleaner

    String[] walk_images = { "alienBlue_walk1.png", "alienBlue_walk2.png" };
    String[] climb_images = { "alienBlue_climb1.png", "alienBlue_climb2.png" };
    String[] swim_images = { "alienBlue_swim1.png", "alienBlue_swim2.png" };
    String[] duck_images = { "alienBlue_duck.png" };
    String[] hit_images = { "alienBlue_hit.png" };
    String[] jump_images = { "alienBlue_jump.png" };
    String[] stand_images = { "alienBlue_stand.png" };

    public Player(float x, float y, ID id, int canvasWidth, int canvasHeight) {
        super(x, y, id, "/res/players/spritesheet_players", canvasWidth, canvasHeight);

        duck = new Animation(duck_images, spriteSheetController);
        walk = new Animation(walk_images, spriteSheetController);
        climb = new Animation(climb_images, spriteSheetController);
        hit = new Animation(hit_images, spriteSheetController);
        jump = new Animation(jump_images, spriteSheetController);
        stand = new Animation(stand_images, spriteSheetController);
        swim = new Animation(swim_images, spriteSheetController);

        currentAnimation = walk;
        sprite = walk.getCurrentFrame();

        width = sprite.getWidth();
        height = sprite.getHeight();
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        currentAnimation.tick();
        System.out.println(x + " " + y);
        System.out.println("canvasWidth: " + canvasWidth + " canvasHeight: " + canvasHeight);
        if (velX == 0 && velY == 0) {
            currentAnimation = stand;
        }

    }

    @Override
    public void render(Graphics g) {
        sprite = currentAnimation.getCurrentFrame();
        if (velX < 0) {
            flipSprite();
        }
        g.drawImage(sprite, (int) x, (int) y, null);

    }

    @Override
    public void handleKeys(Boolean[] keys) {
        stop();
        if (keys[upKeyCode]) {
            moveUp();
        }
        if (keys[downKeyCode]) {
            moveDown();
        }
        if (keys[leftKeyCode]) {
            moveLeft();
        }
        if (keys[rightKeyCode]) {
            moveRight();
        }
        if (keys[duckKeyCode]) {
            duck();
        }

    }

    private void stop() {
        velX = 0;
        velY = 0;

        currentAnimation = stand;
    }

    private void moveRight() {
        if (x < canvasWidth && velX <= 5) {
            velX += 5;
            currentAnimation = walk;
        }
    }

    private void moveLeft() {
        if (x > 0) {
            velX -= 5;
            currentAnimation = walk;
        }
    }

    private void moveUp() {
        if (y >= -100) {
            velY -= 5;
        }
        currentAnimation = climb;
    }

    private void moveDown() {
        if (y < canvasHeight - height && velY <= 5) {
            velY += 5;
        }
        currentAnimation = climb;
    }

    private void duck() {
        currentAnimation = duck;
    }

}
