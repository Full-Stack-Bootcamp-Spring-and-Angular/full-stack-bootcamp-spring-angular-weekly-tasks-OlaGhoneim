package com;

public class CircleShape implements Shape
{

   public Draw2D draw2D;

   //constructor injection
    public CircleShape(Draw2D draw2D)
    {
        this.draw2D = draw2D;
    }


    @Override
    public void drawShape2d() {
        draw2D.draw("circle");
    }


    @Override
    public void drawShape3d() {

    }
}


