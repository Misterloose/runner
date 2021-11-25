package runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;



public class GameScene extends Scene  {
   private Camera cam ;
//   public static final int height = 400;
//   public static final int width = 800;
   public Pane pane;
   private staticThing left ;
   private staticThing right ;
   private staticThing numberOfLives ;
   private staticThing middle  ;
   private Hero hero;
   private ArrayList<Foe> ennemies = new ArrayList();
   private ImageView fin =new ImageView("runner\\gameover.jpg");

    public GameScene(Pane pane) {
        super(pane, 800, 400);
        this.pane = pane;
        cam = new Camera(400, 600);
        left = new staticThing(0, 0, "runner\\desert.png");
        right = new staticThing(1600, 0, "runner\\desert.png");
        middle = new staticThing(800, 0, "runner\\desert.png");
        numberOfLives = new staticThing(0, 0, "runner/vie.png");
        numberOfLives.image.setViewport(new Rectangle2D(0, 0, 270, 94));
        numberOfLives.image.setFitWidth(100);
        numberOfLives.image.setPreserveRatio(true);

        hero = new Hero(100, 250, 90000000, 75, 100, 6, 10, "running", "runner\\heros.png");

        for (int i = 0; i < 10; i++) {
            Foe ennemie =new Foe(Math.random()*8000+2000, 300, 45, 45, "runner/rock (1).gif");
            ennemies.add(ennemie);
        }

        pane.getChildren().addAll(left.getImage(),middle.getImage(), right.getImage(), numberOfLives.getImage(),hero.getImage());

        for(Foe ennemie:ennemies){
            pane.getChildren().addAll(ennemie.getImage());
        }

        this.setOnKeyPressed(event->{
            if (event.getCode().equals(KeyCode.SPACE)&&hero.getY()==250){
                System.out.println("jump_up");
                hero.setAttitude("jump_up");
            }
        });
    }

    public Camera getCam() {
        return cam;
    }

    public staticThing getLeft() {
        return left;
    }

    public staticThing getRight() {
        return right;
    }

    public staticThing getMiddle() {
        return middle;
    }

    public Hero getHero() {
        return hero;
    }

    public ArrayList<Foe> getEnnemies() {
        return ennemies;
    }



    public void update(long time) {
//        hero.setX(hero.getX()+1);
        for(Foe ennemie : ennemies){
            ennemie.setX(ennemie.getX()-4);
            if (hero.getHitbox().intersects(ennemie.getHitbox())&& hero.getInvincibility()==0)
            {
                hero.setInvincibility(250);
                hero.setPdv(hero.getPdv()-1);
                System.out.println("-1 vie");

                System.out.println(" hero x:"+hero.getX()+" hero y:"+hero.getY()+" ennemie x:"+ennemie.getX()+" ennemie y:"+ennemie.getY());
            }
        }
        // moving background
        right.setX(right.getX() - 10);
        left.setX(left.getX() - 10);
        middle.setX((middle.getX() - 10));
        if (left.getX() <= -800) {
            left.setX(1599);
        }
        if (right.getX() <= -800) {
            right.setX(1599);
        }
        if (middle.getX() <= -800) {
            middle.setX(1599);
        }
        //attitude
        if (hero.getAttitude() == "jump_up"||(hero.getAttitude()=="still"&&hero.getY()<150)) {
            hero.getImage().setViewport(new Rectangle2D(0, 160, 85, 100));
            hero.setY(hero.getY() - 5);
            right.setY(right.getY() +1 );
            left.setY(left.getY() + 1);
            middle.setY(middle.getY() + 1);
            for(Foe ennemie : ennemies) {
                ennemie.setY(ennemie.getY() + 1);
            }
            if (hero.getY() == 150 && hero.getAttitude() == "jump_up") {
                hero.setAttitude("jump_down");
            }
        }

        if(hero.getAttitude() == "jump_down"||(hero.getAttitude()=="still" && hero.getY()>250)) {
            hero.getImage().setViewport(new Rectangle2D(100, 160, 85, 100));
            hero.setY(hero.getY() + 5);
            right.setY(right.getY() -1 );
            left.setY(left.getY() - 1);
            middle.setY(middle.getY() - 1);
            numberOfLives.setY(numberOfLives.getY()-1);
            for(Foe ennemie : ennemies) {
                ennemie.setY(ennemie.getY() - 1);
            }

            if (hero.getY() == 250 && hero.getAttitude() == "jump_down") {
                hero.setAttitude("running");
            }
        }

        if(hero.getInvincibility()!=0) {
            hero.setInvincibility(hero.getInvincibility()-1);
            hero.getImage().setOpacity(0.5);
        }
        if(hero.getInvincibility()==0){
            hero.getImage().setOpacity(1);
        }
        if(hero.getPdv()==2){
            numberOfLives.image.setViewport(new Rectangle2D(0, 0, 180, 94));
            numberOfLives.image.setFitWidth(66);
            numberOfLives.image.setPreserveRatio(true);
        }
        if(hero.getPdv()==1){
            numberOfLives.image.setViewport(new Rectangle2D(0, 0, 90, 94));
            numberOfLives.image.setFitWidth(33);
            numberOfLives.image.setPreserveRatio(true);
        }
        if(hero.getPdv()==0){
            numberOfLives.image.setViewport(new Rectangle2D(0, 0, 0, 94));
            numberOfLives.image.setFitWidth(100);
            numberOfLives.image.setPreserveRatio(true);
            fin.setFitWidth(800);
            fin.setPreserveRatio(true);
            pane.getChildren().removeAll();
            pane.getChildren().add(fin);
        }
    }
}