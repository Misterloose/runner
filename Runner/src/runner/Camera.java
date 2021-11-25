package runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;

public class Camera {
    private int x,y;
    private long ax,vx=0;
    private final double f=1.2,k=1,m=1;

    public Camera(int a, int b) {
        this.x = a;
        this.y = b;

    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public String toString(){
        return "X:"+x+"Y"+y;
    }

    public void update(long time,Hero hero){
       double xhero = hero.getX();
        if(time<1){
            ax = (long) ((k/m)* (xhero - x) - (f/m) * vx);
            vx+=ax*time;
            x+=vx*time;
        }


    }

    public long getVx() {
        return vx;
    }
}
