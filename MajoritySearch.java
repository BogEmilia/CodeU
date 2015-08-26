import java.util.Arrays;

public class MajoritySearch {
    public static Integer hasMajority(int[] l) {
        Arrays.sort(l);
        int len = 1;
        for (int i = 0; i < l.length - 1; i++ ) {
            if (l[i] == l[i+1]) {
                len++;
                if (len > 0.5*l.length) {
                    return l[i];
                }
            } else {
                len = 0;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] list1 = { 5, 3, 9, 4, 3, 3, 8, 3, 3 };
        System.out.println(hasMajority(list1));

        int[] list2 = { 5, 3, 9, 4, 3, 3, 8, 3 };
        System.out.println(hasMajority(list2));

        int[] list3 = {};
        System.out.println(hasMajority(list3));

        int[] list4 = { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2 };
        System.out.println(hasMajority(list4));

        int[] list5 = { 2, 3, 2, 2 };
        System.out.println(hasMajority(list5));

        int[] list6 = { 5, 5, 5};
        System.out.println(hasMajority(list6));
//        Expected output:
//        3
//        null
//        null
//        null
//        2
//        5
    }
}
