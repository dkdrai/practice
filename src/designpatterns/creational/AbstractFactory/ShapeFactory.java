package designpatterns.creational.AbstractFactory;

import designpatterns.creational.AbstractFactory.shapes.Rectangle;
import designpatterns.creational.AbstractFactory.shapes.Shape;
import designpatterns.creational.AbstractFactory.shapes.Square;

public class ShapeFactory extends AbstractFactory {
   @Override
   public Shape getShape(String shapeType){
      if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
      }else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }	 
      return null;
   }
}