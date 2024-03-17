package oy.tol.tra;
public class Algorithms {
    public static <Item extends Comparable<Item>> void sort(Item [] array) {
        for(int i=1;i < array.length;i++){
            for(int j=i; (j>0) && (array[j].compareTo(array[j-1]) < 0);j--){
                Item tmp = array [j];
                array[j] = array[j-1];
                array[j-1] = tmp;
            }
        }
    }
    public static <Item> void reverse(Item [] array) {
        int i = 0;
      while (i <= (array.length-1)/2) {
         Item tmp = array [array.length-i-1];
         array[array.length-i-1] = array[i];
         array[i] = tmp;
         i++ ;
        }
    }
}
