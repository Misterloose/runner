package runner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application{
    public void start(Stage primaryStage){
        primaryStage.setTitle("runner");
        Group root = new Group();
        Pane pane = new Pane(root);
        GameScene gamescene= new GameScene(pane);
        gamescene.setFill(Color.rgb(0,153,255));
        primaryStage.setScene(gamescene);
        // affichage hero
//        Image spriteSheet = new Image("runner/heros.png");
//        ImageView sprite = new ImageView(spriteSheet);
//        sprite.setImage(spriteSheet);
//        sprite.setViewport(new Rectangle2D(20,0,65,100));
//        sprite.setX(200);
//        sprite.setY(300);
//        // affichage fond
//        Image fondSheet = new Image("runner/desert.png");
//        ImageView fond =new ImageView(fondSheet);
//        fond.setImage(fondSheet);
//        fond.setViewport(new Rectangle2D(0,0,800,400));
//        fond.setX(400);
//        fond.setY(400);
//        Image fondSheet2 = new Image("runner/desert.png");
//        ImageView fond2 =new ImageView(fondSheet2);
//        fond2.setImage(fondSheet2);
//        fond2.setViewport(new Rectangle2D(400,0,800,400));
//        fond2.setX();
//        pane.getChildren().addAll(sprite);
        AnimationTimer timer =new AnimationTimer() {
            @Override
            public void handle(long time) {
                gamescene.getHero().update(time);
                gamescene.getCam().update(time,gamescene.getHero());
                gamescene.update(time);
                gamescene.getRight().update(time);
                gamescene.getLeft().update(time);
                gamescene.getMiddle().update(time);

                for(Foe ennemie: gamescene.getEnnemies()){
                    ennemie.update(time);
                }
            }
        };
        timer.start();
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        // write your code here
    }
}