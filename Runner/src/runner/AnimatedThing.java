package runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

abstract public class AnimatedThing {
    private double x,y,duration,size_window_x,size_window_y;
    private ImageView spriteSheet;
    private int max_index,offset;
    private String attitude;
    private long a;
    private Rectangle2D hitbox;


    public AnimatedThing(double x, double y, double duration, double size_window_x, double size_window_y, int max_index, int offset, String attitude, String FileName) {
        this.x = x;
        this.y = y;
        this.duration = duration;
        this.size_window_x = size_window_x;
        this.size_window_y = size_window_y;
        this.spriteSheet = new ImageView(FileName);
        this.attitude = attitude;
        this.max_index = max_index;
        this.offset = offset;
        spriteSheet.setX(x);
        spriteSheet.setY(y);
        this.hitbox= new Rectangle2D(x,y,60,85);

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ImageView getImage() {
        return spriteSheet;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public String getAttitude() {
        return attitude;
    }
    public Rectangle2D getHitbox(){
        return hitbox;
    }

    public void setHitbox(Rectangle2D hitbox) {
        this.hitbox = hitbox;
    }

    public void update(long time) {
        spriteSheet.setX(x);
        spriteSheet.setY(y);

        a = (int) ((time % (max_index * duration)) / duration);
        this.getImage().setViewport(new Rectangle2D(a * (size_window_x + offset), 0, size_window_x + offset, 100));
        this.hitbox=new Rectangle2D(spriteSheet.getX(), spriteSheet.getY(), 60,85);

    }
}
