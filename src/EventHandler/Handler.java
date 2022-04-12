package EventHandler;
import java.util.LinkedList;

import Objects.Abstract.GameObject;

import java.awt.Graphics;

// This class is used to handle all the game objects.

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<GameObject>();
    
    // This method calls the tick method on every game object.
    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
            
        }
    }

    // This method calls the render method on every game object.
    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
        }
    }

    // This method adds a game object to the list.
    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    // This method removes a game object from the list.
    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

    // This method returns the list of game objects.
    public LinkedList<GameObject> getObjects() {
        return objects;
    }

    // This method returns a specific game object.
    public GameObject getObject(int index) {
        return objects.get(index);
    }

    // This method returns the size of the list.
    public int getSize() {
        return objects.size();
    }


}
