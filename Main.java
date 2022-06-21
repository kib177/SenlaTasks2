package zadanie5;

import java.util.*;

public class Main {
   static calc c = new calc();

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println("Введите максимальный обьем сейфа: ");
      int maxWeightSafe = in.nextInt();
      Safe.setMaxWeight(maxWeightSafe);
      c.calcult();
   }


}
