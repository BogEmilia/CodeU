import java.util.ArrayList;
import java.util.List;

public class QueryStream {
    private List<Query> qs;
    private int index = 0;
    private int qiter = 0;
    private int iiter = 0;

    public static class Query{
        private int timestamp;
        private String words;

        public Query(int timestamp, String words) {
            this.timestamp = timestamp;
            this.words = words;
        }
    }

    public QueryStream(List<Query> qs) {
        this.qs = qs;
    }

    public String next(){
        String word = null;
        Query q;
        if (qiter < qs.size()) {
            q = qs.get(qiter);
            String[] ws = q.words.split(" ");
            word = ws[index];
            if ((ws.length - 1) == index) {
                index = 0;
                qiter++;
            } else {
                index++;
            }
        }
        return word;
    }

    public boolean hasNext(){
        String[] last = qs.get((qs.size()-1)).words.split(" ");
        if (qiter < (qs.size() - 1)) {
            return true;
        } else if (qiter < qs.size() && index < last.length) {
            return true;
        }
        return false;
    }

    public void iterator() {
        while (qiter < qs.size()) {
                if (hasNext()) {
                    if (iiter == qiter) {
                        if (iiter - 1 >= 0) {
                            System.out.println((qs.get(iiter).timestamp - qs.get(iiter - 1).timestamp));
                            System.out.println(next());
                            iiter++;
                        } else {
                            System.out.println("<First Query>");
                            System.out.println(next());
                            iiter++;
                        }
                    } else {
                        System.out.println(next());
                    }
                }
        }
    }
    public static void main(String[] args) {
        Query q = new Query(12082014, "some words strings things");
        Query q1 = new Query(12092015, "birthday party");
        Query q2 = new Query(17102015, "something cool happens");
        List<Query> qss = new ArrayList<Query>();
        qss.add(q);
        qss.add(q1);
        qss.add(q2);
        QueryStream qs = new QueryStream(qss);
        qs.iterator();

        Query q3 = new Query(12082014, "");
        List<Query> ss = new ArrayList<Query>();
        ss.add(q3);
        QueryStream qs2 = new QueryStream(ss);
        qs2.iterator();
    }
//    Expected output:
//            <First Query>
//            some
//            words
//            strings
//            things
//            10001
//            birthday
//            party
//            5010000
//            something
//            cool
//            happens
//            <First Query>
}
