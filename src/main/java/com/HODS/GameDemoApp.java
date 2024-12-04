package com.HODS;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.texture.Texture;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameDemoApp extends GameApplication {

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("score", 0);
    }

    @Override
    protected void onUpdate(double tpf) {
        FXGL.inc("score",1);
    }

    @Override
    protected void initUI() {
//        Image image = new Image("assets/textures/background.png");
//        Rectangle rectangle = new Rectangle(50,50);
//        rectangle.setFill(new ImagePattern(image));
//        rectangle.setOnMouseClicked(e -> FXGL.getInput().mockKeyPress(KeyCode.SPACE));
//        FXGL.addUINode(rectangle, 700, 0);

        Rectangle ScoreUI = new Rectangle(100 ,100);
        ScoreUI.setStroke(Color.BLUE);
        ScoreUI.setStrokeWidth(3);
        Text scoreText = FXGL.getUIFactoryService().newText(FXGL.getip("score").asString());
        StackPane stackPane = new StackPane(ScoreUI, scoreText);
        FXGL.addUINode(stackPane, 650, 0);
    }



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
        FXGL.getGameWorld().addEntity(Objects.requireNonNull(CustomerEneieyFactory.createEntity(EntityType.Player)));

        FXGL.getInput().addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entities = FXGL.getGameWorld().getEntitiesByType(EntityType.Player);
                entities.get(0).getComponent(MoveComponent.class).up();
            }

            @Override
            protected void onActionEnd() {
                List<Entity> entities = FXGL.getGameWorld().getEntitiesByType(EntityType.Player);
                entities.get(0).getComponent(MoveComponent.class).stop();
            }
        }, KeyCode.UP);

        FXGL.getInput().addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entities = FXGL.getGameWorld().getEntitiesByType(EntityType.Player);
                entities.get(0).getComponent(MoveComponent.class).down();
            }

            @Override
            protected void onActionEnd() {
                List<Entity> entities = FXGL.getGameWorld().getEntitiesByType(EntityType.Player);
                entities.get(0).getComponent(MoveComponent.class).stop();
            }
        }, KeyCode.DOWN);

        FXGL.getInput().addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entities = FXGL.getGameWorld().getEntitiesByType(EntityType.Player);
                entities.get(0).getComponent(MoveComponent.class).left();
            }

            @Override
            protected void onActionEnd() {
                List<Entity> entities = FXGL.getGameWorld().getEntitiesByType(EntityType.Player);
                entities.get(0).getComponent(MoveComponent.class).stop();
            }
        }, KeyCode.LEFT);

        FXGL.getInput().addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entities = FXGL.getGameWorld().getEntitiesByType(EntityType.Player);
                entities.get(0).getComponent(MoveComponent.class).right();
            }

            @Override
            protected void onActionEnd() {
                List<Entity> entities = FXGL.getGameWorld().getEntitiesByType(EntityType.Player);
                entities.get(0).getComponent(MoveComponent.class).stop();
            }
        }, KeyCode.RIGHT);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
