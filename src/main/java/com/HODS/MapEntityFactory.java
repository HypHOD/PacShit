package com.HODS;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

public class MapEntityFactory implements EntityFactory {
    @Spawns("rect")
    public Entity newRect(SpawnData data) {
        return FXGL.entityBuilder(data)
                .with(new RectComponent())
                .build();
    }
}
