package com.HODS;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class GameDemoApp extends GameApplication {

    public Entity player;
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("GameDemoApp");
        settings.setVersion("0.1");
        settings.setAppIcon("Ghost1.gif");
    }



    @Override
    protected void initGame() {
        player= FXGL.entityBuilder()
                .view(new ImageView(new Image("assets/textures/PacMan1.gif")))
                .build();
        FXGL.getGameWorld().addEntity(player);

    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("Move UP") {
            @Override
            protected void onAction() {

                player.translateY(-5);
            }
        }, KeyCode.UP);

        FXGL.getInput().addAction(new UserAction("Move DOWN") {
            @Override
            protected void onAction() {
                player.translateY(5);
            }
        }, KeyCode.DOWN);

        FXGL.getInput().addAction(new UserAction("Move LEFT") {
            @Override
            protected void onAction() {
                player.translateX(-5);
            }
        }, KeyCode.LEFT);

        FXGL.getInput().addAction(new UserAction("Move RIGHT") {
            @Override
            protected void onAction() {
                player.translateX(5);
            }
        }, KeyCode.RIGHT);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
