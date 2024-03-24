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

    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {

        int lo = fromIndex, hi = toIndex;
        while (lo<=hi){
            int mid = lo +(hi - lo)/2;
            int cmp = aValue.compareTo(fromArray[mid]);
            if(cmp < 0) hi = mid-1;
            else if (cmp>0) lo = mid +1;
            else return mid;
        }
        return -1;
     }


     public static <E extends Comparable<E>> void quickSort(E [] array, int begin, int end) {
        if(end <= begin) return;

        int j =partition(array,begin,end);
        quickSort(array, begin, j -1);
        quickSort(array, j+1,end);
     }

     private static <E extends Comparable<E>> int partition(E [] array, int begin, int end) {

        int i = begin, j  = end +1;

        E v = array [begin];
        while(true){
            while (array[++i].compareTo(v)<0) if (i == end) break;

            while(v.compareTo(array[--j])<0) if (j == begin) break;

            if(i>=j) break;
            E tmp = array [j];
            array[j] = array[i];
            array[i] = tmp;
        }
        E tmp = array [j];
        array[j] = array[begin];
        array[begin] = tmp;
        return j;
     }

     public static <E extends Comparable<E>> void fastSort(E [] array) {


        quickSort(array, 0, array.length - 1);
     }

}
