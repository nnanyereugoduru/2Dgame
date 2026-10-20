
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
   
    // works like a game screen
    final int original_tile_size = 16; // 16 by 16 tile size default pixel size for 2d games
    final int scale = 3;

    final int tile_size = original_tile_size * scale;
    final int max_screen_col = 16; // change this for game screen
    final int max_screen_row = 12;  // change this for game screen
    final int screen_width = tile_size * max_screen_col;
    final int screen_height = tile_size * max_screen_row;

    keyHandler key = new keyHandler();
    Thread gameThread;

    // player deafult positoin

    int player_x = 100;
    int player_y = 100;
    int player_speed = 4;
    Player player = new Player(this, key);

    int FPS = 120;

    
    public GamePanel() {

        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }
    public void start_game_thread(){
        gameThread = new Thread(this);
        gameThread.start();

    }
    // game loop
   
    @Override 
    public void run(){

          double drawInterval = 1_000_000_000.0 / FPS;
    double delta = 0;
    long lastTime = System.nanoTime();

    while (gameThread != null) {
        long currentTime = System.nanoTime();
        delta += (currentTime - lastTime) / drawInterval;
        lastTime = currentTime;

        if (delta >= 1) {
            update();
            repaint();
            delta--;
        }
    }
    }

    public void update() {
        if (key.up){
            player_y -= player_speed;
        }
        else if (key.down) {
            player_y += player_speed;
        }

        else if (key.left){
            player_x -= player_speed;
        }
        else if (key.right){
            player_x += player_speed;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        
        g2.fillRect(player_x, player_y , tile_size, tile_size);
        g2.dispose();
    }    
}
