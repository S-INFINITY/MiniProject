package Objects.Abstract;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import Objects.ID;
import Objects.AssetController.SpriteSheetController;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

/* This class is used to blueprint a game object. 
It has a position, a size, a sprite, and a ID.
It has 1 constructor, and 2 abstract methods.
Constructor:
    This constructor takes in the x and y position, the width and height, the sprite, and the ID.
    It sets the position, size, sprite, and ID.
Method 1: tick
    This method is used to update the game object's logic.
Method 2: render
    This method is used to display the game object's graphics.
 */

public abstract class GameObject {
    protected float x, y;
    protected ID id;
    protected float velX, velY;
    protected SpriteSheetController spriteSheetController;
    protected BufferedImage sprite;
    protected int width, height;
    protected final int canvasWidth, canvasHeight;

    public GameObject(float x, float y, ID id, String spriteSheetPath, int canvasWidth, int canvasHeight) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.spriteSheetController = new SpriteSheetController(spriteSheetPath);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void handleKeys(Boolean[] keys);

    public void flipSprite() {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-sprite.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        sprite = op.filter(sprite, null);

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public void setVel(float velX, float velY) {
        this.velX = velX;
        this.velY = velY;
    }

    public void setVel(float vel) {
        this.velX = vel;
        this.velY = vel;
    }

}
