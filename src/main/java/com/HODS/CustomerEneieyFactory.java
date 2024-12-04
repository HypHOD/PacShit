package com.HODS;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;

public class CustomerEneieyFactory {
    public static Entity createEntity(EntityType type){
        switch(type){
            case Player->{
                Entity entity=FXGL.entityBuilder().with(new MoveComponent()).build();
                entity.setType(EntityType.Player);
                return entity;
            }
            default->{
                return null;
            }
        }
    }

    public Entity newWall(SpawnData data){
        Entity build = FXGL
                .entityBuilder(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .collidable()
                .with(new PhysicsComponent())
                .build();
        return build;

    }
}
