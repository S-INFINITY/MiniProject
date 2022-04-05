package EventHandler;
import java.util.LinkedList;

import Objects.GameObject;

import java.awt.Graphics;

// This class is used to handle all the game objects.

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    // This method calls the tick method on every game object.
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    // This method calls the render method on every game object.
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    // This method adds a game object to the list.
    public void addObject(GameObject object) {
        this.object.add(object);
    }

    // This method removes a game object from the list.
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    // This method returns the list of game objects.
    public LinkedList<GameObject> getObject() {
        return object;
    }

    // This method returns the size of the list.
    public int getSize() {
        return object.size();
    }


}
