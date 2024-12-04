package com.HODS;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
        FXGL.inc("score",0);
        //如果碰到球就+1分
        //如果吃掉敌人就加10分
        //如果碰到敌人就结束游戏
        //如果分数达到要求就下一关

    }

    @Override
    protected void initUI() {
//        Image image = new Image("assets/textures/background.png");
//        Rectangle rectangle = new Rectangle(50,50);
//        rectangle.setFill(new ImagePattern(image));
//        rectangle.setOnMouseClicked(e -> FXGL.getInput().mockKeyPress(KeyCode.SPACE));
//        FXGL.addUINode(rectangle, 700, 0);

        Rectangle ScoreUI = new Rectangle(100 ,100);
        Rectangle levelUI = new Rectangle(100, 100);
        ScoreUI.setStroke(Color.WHEAT);
        ScoreUI.setStrokeWidth(6);
        levelUI.setStroke(Color.WHEAT);
        levelUI.setStrokeWidth(6);
        Text scoreText = FXGL.getUIFactoryService().newText(FXGL.getip("score").asString());
        Integer level = FXGL.setLevelFromMap("level1.tmx").getProperties().getInt("level");
        Text levelText = FXGL.getUIFactoryService().newText("Level: " + level.toString());
        StackPane stackPane1 = new StackPane(ScoreUI, scoreText);
        StackPane stackPane2 = new StackPane(levelUI,levelText);
        stackPane1.setTranslateX(100);
        stackPane1.setTranslateY(100);
        stackPane2.setTranslateX(300);
        stackPane2.setTranslateY(300);

        FXGL.addUINode(stackPane1, 480, 0);
        FXGL.addUINode(stackPane2, 480, 100);
    }



    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(585);
        settings.setHeight(720);
        settings.setTitle("GameDemoApp");
        settings.setVersion("0.1");
        settings.setAppIcon("Ghost1.gif");
    }


    @Override
    protected void initGame() {
        //创建地图
        FXGL.getGameWorld().addEntityFactory(new MapEntityFactory());
        setLevel();
        //创建实体工厂
        Entity entity=Objects.requireNonNull(CustomerEneieyFactory.createEntity(EntityType.Player));
        FXGL.getGameWorld().addEntity(entity);

        //绑定视角
//        Viewport viewport = FXGL.getGameScene().getViewport();
//        viewport.setBounds(0, 0, 600, 800);
//        viewport.bindToEntity(entity, (double) FXGL.getAppWidth() / 2, (double) FXGL.getAppHeight() / 2);


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

    private void setLevel() {
        Level levelmap = FXGL.setLevelFromMap("level1.tmx");
        int level, score;
        level = levelmap.getProperties().getInt("level");
        score = levelmap.getProperties().getInt("score");
        System.out.println("level:" + level + " score:" + score);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
