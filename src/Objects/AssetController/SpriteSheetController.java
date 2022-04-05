package Objects.AssetController;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
This class has the responsibility of loading the spritesheet and the sprite records.
It has 2 methods and 1 constructor.

Constructor:
    This constructor takes in the path to the spritesheet and the path to the sprite records.
    It loads the spritesheet and the sprite records.
Method 1: loadSpriteSheet
    This method loads the spritesheet and returns a BufferedImage.
Method 2: loadSpriteRecords
    This method loads the sprite records and updates the private spritesObjects ArrayList.
*/

public class SpriteSheetController {
    ArrayList<SpriteRecord> spritesObjects;
    BufferedImage spriteSheet;
    static String rootPath = System.getProperty("user.dir");

    public SpriteSheetController(String path) {
        spritesObjects = new ArrayList<SpriteRecord>();
        LoadSpriteRecords(rootPath + path + ".xml");
        try {
            LoadSpriteSheet(rootPath + path + ".png");

            // Handles the exception if it cannot read SubTextures from the xml file
            if (spritesObjects.size() == 0) {
                System.out.println("Error: There was a problem reading the xml file.");
                System.out.println("The path was: " + path + ".xml");
            }
        } catch (IOException e) {
            // Handles the exception if it cannot read the sprite sheet png file
            System.out.println("Error: the sprite sheet could not be loaded.");
            System.out.println("The path was: " + path + ".png");
        }

    }

    // Parse an XML file
    public void LoadSpriteRecords(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();

            // Get the list of sprites
            NodeList sprites = root.getElementsByTagName("SubTexture");
            for (int i = 0; i < sprites.getLength(); i++) {
                // Get the sprite
                Element sprite = (Element) sprites.item(i);
                String name = sprite.getAttribute("name");
                int width = Integer.parseInt(sprite.getAttribute("width"));
                int height = Integer.parseInt(sprite.getAttribute("height"));
                int x = Integer.parseInt(sprite.getAttribute("x"));
                int y = Integer.parseInt(sprite.getAttribute("y"));

                // Create a new sprite record
                SpriteRecord spriteRecord = new SpriteRecord(name, width, height, x, y);
                this.spritesObjects.add(spriteRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Loading spritesheet
    // Adding 'throws IOException' handles the edge case where the file is not found
    public void LoadSpriteSheet(String imageFilePath) throws IOException {
        spriteSheet = ImageIO.read(new File(imageFilePath));
    }

    public BufferedImage grabImage(String name) {
        // Search for the sprite that matches the name passed in
        for (SpriteRecord spriteRecord : spritesObjects) {
            if (spriteRecord.name().equals(name)) {
                return spriteSheet.getSubimage(spriteRecord.x(), spriteRecord.y(), spriteRecord.width(),
                        spriteRecord.height());
            }
        }
        // If the sprite is not found, return null
        return null;
    }
}
