package designpatterns.creational.AbstractFactory;

import designpatterns.creational.AbstractFactory.shapes.Shape;

public abstract class AbstractFactory {
   abstract Shape getShape(String shapeType) ;
}