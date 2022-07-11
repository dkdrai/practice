package designpatterns.creational.AbstractFactory;

import designpatterns.creational.AbstractFactory.shapes.RoundedRectangle;
import designpatterns.creational.AbstractFactory.shapes.RoundedSquare;
import designpatterns.creational.AbstractFactory.shapes.Shape;

public class RoundedShapeFactory extends AbstractFactory {
   @Override
   public Shape getShape(String shapeType){
      if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new RoundedRectangle();
      }else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new RoundedSquare();
      }	 
      return null;
   }
}