package com.HODS;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectComponent extends Component {

    @Override
    public void onAdded() {
        String color = entity.getString("color");
        Color webColor = Color.web(color);
        entity.getViewComponent().addChild(new Rectangle(entity.getInt("w"), entity.getInt("h"), webColor));

    }
}
