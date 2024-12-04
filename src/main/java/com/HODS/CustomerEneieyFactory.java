package com.HODS;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

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
}
