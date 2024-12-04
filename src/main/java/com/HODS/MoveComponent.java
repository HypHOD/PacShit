package com.HODS;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class MoveComponent extends Component {
    private double speedX=0d;
    private double speedY=0d;
    private final double maxSpeed=4d;
    private int faceDirection=1;
    private final AnimationChannel up;
    private final AnimationChannel down;
    private final AnimationChannel left;
    private final AnimationChannel right;

    private final AnimatedTexture texture;

    @Override
    public void onAdded() {
        entity.getViewComponent().addChild(texture);

    }


    @Override
    public void onUpdate(double tpf) {
        int tempFaceDirection=faceDirection;
        if(speedX!=0d){
            Vec2 dir = Vec2.fromAngle(entity.getRotation()-360)
                    .mulLocal(speedX);
            entity.translate(dir);
            if(speedX<0d){
                tempFaceDirection=1;
            }else{
                tempFaceDirection=2;
            }
        }
        if(speedY!=0d){
            Vec2 dir = Vec2.fromAngle(entity.getRotation()-90)
                    .mulLocal(speedY);
            entity.translate(dir);
            if(speedY>0d){
                tempFaceDirection=3;
            }else{
                tempFaceDirection=4;
            }
        }
        if(tempFaceDirection!=faceDirection){
            if(tempFaceDirection==1){
                this.texture.loopAnimationChannel(left);
            }else if(tempFaceDirection==2){
                this.texture.loopAnimationChannel(right);
            }else if(tempFaceDirection==3){
                this.texture.loopAnimationChannel(up);
            }else if(tempFaceDirection==4){
                this.texture.loopAnimationChannel(down);
            }
            faceDirection=tempFaceDirection;
        }
    }
    public MoveComponent(){

        Image image = new Image("assets/textures/sprite.png");
        up = new AnimationChannel(image,12,24,24, Duration.seconds(0.5),0,2);
        down = new AnimationChannel(image,12,24,24, Duration.seconds(0.5),3,5);
        left = new AnimationChannel(image,12,24,24, Duration.seconds(0.5),6,8);
        right = new AnimationChannel(image,12,24,24, Duration.seconds(0.5),9,11);
        texture = new AnimatedTexture(up);
        texture.loop();
    }

    public void up(){
        speedY=maxSpeed;
    }

    public void down(){
        speedY=-maxSpeed;
    }

    public void left(){
        speedX=-maxSpeed;
    }

    public void right(){
        speedX=maxSpeed;
    }

    public void stop(){
        speedX=0d;
        speedY=0d;
    }



}
