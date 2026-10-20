

public class Player extends EntityParent {
    GamePanel go;
    keyHandler key;
    public Player(GamePanel go, keyHandler key){
        this.go = go;
        this.key = key;
    }

    public void setDefault() {
        x = 100;
        y = 100;
        speed = 4;
        
    }
    
}
