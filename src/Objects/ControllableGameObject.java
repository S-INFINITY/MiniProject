package Objects;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
/* This class is used to blueprint a game object that can be controlled using the keyboard.
It is the same as the GameObject class, except it has 2 more abstract methods.
These are handleKeyPress() and handleKeyRelease().
This ensures that instances of this class must implement these methods.

Error Handling:
This is important because it means that within the Handler class, I can safely call ControllableGameObject.handleKeyPress()
and ControllableGameObject.handleKeyRelease() because any ControllableGameObject must implement these methods.
 */

public abstract class ControllableGameObject extends GameObject {
    ArrayList<BufferedImage> walk_right = new ArrayList<BufferedImage>();

    public ControllableGameObject(float x, float y, ID id, String spriteSheetPath) {
        super(x, y, id, spriteSheetPath);
    }

    public abstract void handleKeyPress(int key);

    public abstract void handleKeyRelease(int key);

}
