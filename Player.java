
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends EntityParent {
    GamePanel go;
    keyHandler key;
    public Player(GamePanel go, keyHandler key){
        this.go = go;
        this.key = key;
        setDefault();
        getPlayerImage();
    }

    public void setDefault() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
        
        
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("New Piskel (1).png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("New Piskel (2).png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("New Piskel (3).png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("New Piskel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if (key.up){
            y -= speed;
            direction = "up";
        }
        else if (key.down) {
            y += speed;
            direction = "down";
        }

        else if (key.left){
            x -= speed;
            direction = "left";
        }
        else if (key.right){
            x += speed;
            direction = "right";
        }
    
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }

        g2.drawImage(image, x, y, go.tile_size, go.tile_size, null);
    }
    
}
