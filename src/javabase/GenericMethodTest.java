package javabase;

class GenericMethodTest {
   // generic method printArray
   public static < E > void printArray( E[] inputArray ) {
      // Display array elements
      for(E element : inputArray) {
         System.out.printf("%s ", element);
      }
      System.out.println();
   }

   public static < T ,E> E printTwoArray( T[] inputArray, E[] array) {
      // Display array elements
      for(T element : inputArray) {
         System.out.printf("%s ", element);
      }
      for(E element : array) {
         System.out.printf("%s ", element);
      }
      System.out.println();
      return array[0];
   }

   public static void main(String args[]) {
      // Create arrays of Integer, Double and Character
      Integer[] integerArray = { 5, 4, 3, 2, 1 };
      Double[] doubleArray = { 1.21, 22.12, 13.32 };
      Character[] characterArray = { 'Y', 'o', 'u', ' ', 'a', 'r', 'e', ' ', 'a','w','e','s','o','m','e' };

      System.out.println("integerArray contains:");
      char x = printTwoArray(integerArray,characterArray);   // pass an Integer array
      System.out.println(x);


   }
}