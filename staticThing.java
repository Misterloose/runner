package runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class staticThing {
    public double x,y;
    public ImageView image ;
    private Rectangle2D hitbox;

    public staticThing(double x, double y, String FileName) {
        this.x = x;
        this.y = y;
        this.image=new ImageView(FileName);
        image.setX(x);
        image.setY(y);
        this.hitbox= new Rectangle2D(image.getX(), image.getY(), 40,40);
    }

    public ImageView getImage() {
        return image;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Rectangle2D getHitbox(){
        return hitbox;
    }

    public void update(long time) {
        image.setX(x);
        image.setY(y);
        this.hitbox= new Rectangle2D(x,y,40,40);
    }
}
