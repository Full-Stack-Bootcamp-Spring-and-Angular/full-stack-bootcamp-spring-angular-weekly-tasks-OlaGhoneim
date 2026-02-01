package com;

public class RectangleShape implements Shape
{
    public Draw2D drawShape2d;
    public Draw3D drawShape3d;

    //setter method for setter injection
    public void setDrawShapeFor2d(Draw2D drawShape2d) {
        this.drawShape2d = drawShape2d;
    }

    public void setDrawShapeFor3d(Draw3D drawShape3d) {
        this.drawShape3d = drawShape3d;
    }

    @Override
    public void drawShape2d() {
        drawShape2d.draw("rectangle");
    }

    @Override
    public void drawShape3d() {
        drawShape3d.draw("rectangle");
    }
}
