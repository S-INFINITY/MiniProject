package Objects.AssetController;

import java.awt.image.BufferedImage;

public class Animation {
    BufferedImage[] frames;
    int currentFrame = 1;
    int count;
    public int tickThreshold = 10;

    // constructor
    public Animation(String[] assetPaths, SpriteSheetController spriteSheetController) {
        frames = new BufferedImage[assetPaths.length];
        for (int i = 0; i < assetPaths.length; i++) {
            frames[i] = spriteSheetController.grabImage(assetPaths[i]);
        }
    }

    public void tick() {
        count++;
        if (count >= tickThreshold) {
            count = 0;
            currentFrame++;
            if (currentFrame > frames.length) {
                currentFrame = 1;
            }
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[currentFrame - 1];
    }
}
