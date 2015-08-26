
import java.lang.IllegalArgumentException;
import java.util.Vector;

public class NthLargestClass{
    private Vector<Integer> arr;

    public NthLargestClass(Vector<Integer> arr) {
        this.arr = arr;
    }

    public int nthLargest(int i) {    // I will use quicksort algorithm but checking only the relevant part of the partition
        Vector<Integer> rVector;
        if (i <= 0 || i > arr.size()){
            throw new IllegalArgumentException();
        } else {
            rVector = quickSort(arr, i);
            return rVector.get(0);
        }
    }

    public Vector<Integer> quickSort(Vector<Integer> arr, int i){
        int pivot = 0;
        if (!arr.isEmpty()) {
            pivot = arr.get(0);
        }
        if (arr.size() <= 1) {
            return arr;
        }
        Vector<Integer> low = new Vector<Integer>();
        Vector<Integer> pivotList = new Vector<Integer>();
        Vector<Integer> high = new Vector<Integer>();

        for (int a : arr) {
            if (a < pivot) {
                low.add(a);
            } else if (a > pivot) {
                high.add(a);
            } else {
                pivotList.add(a);
            }
        }
        if (high.size() >= i) {
            return quickSort(high, i);
        } else if ((high.size() + pivotList.size()) >= i ) {
            Vector<Integer> p = new Vector<Integer>();
            p.add(pivot);
            return quickSort(p, 1);
        } else {
            return quickSort(low, i-(high.size() + pivotList.size()));
        }
    }

    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<Integer>();
        arr.add(5);
        arr.add(2);
        arr.add(10);
        arr.add(3);
        arr.add(3);
        NthLargestClass cl = new NthLargestClass(arr);
        System.out.println(cl.nthLargest(1));
        System.out.println(cl.nthLargest(2));
        System.out.println(cl.nthLargest(3));
        System.out.println(cl.nthLargest(4));
        System.out.println(cl.nthLargest(5));

        Vector<Integer> arr1 = new Vector<Integer>();
        NthLargestClass cl1 = new NthLargestClass(arr1);
        System.out.println(cl1.nthLargest(1));
    }
//    Expected output:
//            10
//            5
//            3
//            3
//            2
//    Exception in thread "main" java.lang.IllegalArgumentException
}
