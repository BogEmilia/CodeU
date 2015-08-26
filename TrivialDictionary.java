
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrivialDictionary {
    //Assuming the dictionary is sorted
    //Assuming dictionary is stored as a list of strings
    private static List<String> dictionary;
    private HashMap<String, Boolean> known = new HashMap<String, Boolean>();

    public TrivialDictionary(){
        dictionary = new ArrayList<String>();
    }

    public void add(String str) {
        dictionary.add(str);
    }

    public static String wordAt(int ind) {
        if (ind < dictionary.size()) {
            return dictionary.get(ind);
        } else {
            return null;
        }
    }

    public static int dictionarySize() { // size() can be used instead, for another implementation this method might be useful
        int ind = 0;
        while (TrivialDictionary.wordAt(ind) != null) {
            ind = (ind + 1)*2;
        }
        while (TrivialDictionary.wordAt(ind) == null) {
            ind -- ;
        }
        return ind+1;
    }

    public boolean isInDictionary(String word) {
        boolean isItHere = false;
        if (known.keySet().contains(word)) {
            return known.get(word);
        } else {
            int lo = 1;
            int hi = TrivialDictionary.dictionarySize();
            while (lo <= hi) {
                int mid = (int) (lo + Math.floor((double) (hi - lo) / 2));
                if (TrivialDictionary.wordAt(mid).equals(word)) {
                    isItHere = true;
                    break;
                } else if (TrivialDictionary.wordAt(mid).compareTo(word) < 0) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            known.put(word, isItHere);
        }
        return isItHere;
    }

    public static void main(String[] args) {
        TrivialDictionary dict = new TrivialDictionary();
        dict.add("dog");
        dict.add("cat");
        dict.add("hamster");

        System.out.println(dict.wordAt(2));
        System.out.println(dict.wordAt(5));
        System.out.println(dict.isInDictionary("hamster"));
        System.out.println(dict.isInDictionary("fox"));
        System.out.println(dict.isInDictionary(""));
        System.out.println(dictionarySize());
        System.out.println(dict.isInDictionary("hamster"));

//        Expected output:
//        hamster
//        null
//        true
//        false
//        false
//        3
//        true
    }
}
