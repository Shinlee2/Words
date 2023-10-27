import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String sx1 = "a a a  b  c c  d d d d  e e e e e";
        String sx2 = "e e e e DDD ddd DdD: ddd, ddd aa. 'aA Aa, bb cc c'C e e e";
        String sx3 = "  //wont won't won't ";
        String sx4 = "  ...  ";
        String sx5 = "  '  ";
        String sx6 = "  '''  ";
        String s = "In a village of La Mancha, the name of which I have no desire to call to" +
                "mind, there lived not long since one of those gentlemen that keep a lance" +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for" +
                "coursing. An olla of rather more beef than mutton, a salad on most" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra" +
                "on Sundays, made away with three-quarters of his income.";
        String sx8 = "  , e   .. ";

        String word = "";
        int x = 2;

        List<String> result = new ArrayList<>();

        for (int i = 0; i <= x; i++) {
            Object[] objects = replaceAndSort(s, word);
            word = findWord(objects);
            if (!checkArray(objects)) {
                result.add(word);
                s = Arrays.toString(objects);
            } else {
                word = findWord(objects);
                result.add(word);
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean checkArray(Object[] arr) {
        return arr.length == 1;
    }

    private static Object[] replaceAndSort(String s, String word) {
        String replace = s.replaceAll(word, "").toLowerCase().replaceAll("[^a-zA-Z']+", " ").replaceAll("\\s+", " ").trim();
        String[] finalArr = replace.split(" ");
        Stream<String> sorted = Arrays.stream(finalArr).sorted();
        return sorted.toArray();
    }

    private static String findWord(Object[] s) {
        String word1 = "";
        int counter = 1, counterFinal = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i - 1].equals(s[i]) && counter >= counterFinal) {
                counter++;
                word1 = (String) s[i - 1];
                counterFinal = counter;
            } else if (s[i - 1].equals(s[i]) && counter < counterFinal) {
                counter++;
            } else
                counter = 1;
        }
        return word1;
    }
}


