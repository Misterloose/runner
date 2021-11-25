package runner;

import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    private double invincibility =0;
    private int pdv=3;

    public void setPdv(int pdv) {
        this.pdv = pdv;

    }

    public int getPdv() {
        return pdv;
    }

    public double getInvincibility() {
        return invincibility;
    }

    public void setInvincibility(double invincibility) {
        this.invincibility = invincibility;
    }

    public Hero(double x, double y, double duration, double size_window_x, double size_window_y , int max_index, int offset, String attitude, String FileName) {
        super(x, y, duration, size_window_x, size_window_y, max_index, offset, attitude, FileName);
        this.getImage().setViewport(new Rectangle2D(x,y,size_window_x,size_window_y));
    }

}
