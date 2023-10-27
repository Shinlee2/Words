import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String sx = "a a a  b  c c  d d d d  e e e e e";
        String sx2 = "e e e e DDD ddd DdD: ddd, ddd aa. 'aA Aa, bb cc c'C e e e";
        String sx3 = "  //wont won't won't ";
        String sx4 = "  ...  ";
        String sx5 = "  '  ";
        String sx6 = "  '''  ";
        String s =         "In a village of La Mancha, the name of which I have no desire to call to" +
                           "mind, there lived not long since one of those gentlemen that keep a lance" +
                           "in the lance-rack, an old buckler, a lean hack, and a greyhound for" +
                           "coursing. An olla of rather more beef than mutton, a salad on most" +
                           "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra" +
                           "on Sundays, made away with three-quarters of his income.";
        int counter = 1;
        int counter2 = 1;
        int counter3 = 1;
        int counterFinal = 1;
        int counterFinal2 = 1;
        int counterFinal3 = 1;
        String word1 = "error";
        String word2 = "error";
        String word3 = "error";

        String replace = s.toLowerCase().replaceAll("[^a-zA-Z']+"," ").replaceAll("\\s+", " ").trim();
        String[] finalArr = replace.split(" ");
        Stream<String> sorted = Arrays.stream(finalArr).sorted();
        Object[] firstWordSearchArray = sorted.toArray();

        if(firstWordSearchArray.length == 1) {
            System.out.println("no words in String");
            return;
        }

        if(firstWordSearchArray.length <= 2) {
            word1 = (String) firstWordSearchArray[0];
            System.out.println("String: " + Arrays.toString(firstWordSearchArray));
            System.out.println("Result: ");
            System.out.println("1st word: " + word1 + " " + counterFinal);
            return;
        }

        for(int i = 1; i < firstWordSearchArray.length; i++) {
            if (firstWordSearchArray[i - 1].equals(firstWordSearchArray[i]) && counter >= counterFinal) {
                counter++;
                word1 = (String) firstWordSearchArray[i];
                counterFinal = counter;
            } else if(firstWordSearchArray[i - 1].equals(firstWordSearchArray[i])) {
                counter++;
                } else
                    counter = 1;
            }
        String s2 = Arrays.toString(firstWordSearchArray).replaceAll(word1, "").replaceAll("[^a-zA-Z ']+","").replaceAll("\\s+", " ").trim();
        String[] finalArr2 = s2.split(" ");
        Stream<String> sorted2 = Arrays.stream(finalArr2).sorted();
        Object[] secondWordSearchArray = sorted2.toArray();

        if(secondWordSearchArray.length == 0) {
            return;
        }

        if(secondWordSearchArray.length == 1) {
            word2 = (String) secondWordSearchArray[0];
            System.out.println("String: " + Arrays.toString(firstWordSearchArray));
            System.out.println("String: " + s2);
            System.out.println("String: " + Arrays.toString(secondWordSearchArray));
            System.out.println("Result: ");
            System.out.println("1st word: " + word1 + " " + counterFinal);
            System.out.println("2nd word: " + word2 + " " + counter2);
            return;
        }

        for(int i = 1; i < secondWordSearchArray.length; i++) {
            if (secondWordSearchArray[i - 1].equals(secondWordSearchArray[i]) && counter2 >= counterFinal2) {
                counter2++;
                word2 = (String) secondWordSearchArray[i];
                counterFinal2 = counter2;
            } else if(secondWordSearchArray[i - 1].equals(secondWordSearchArray[i]) && counter2 < counterFinal2) {
                counter2++;
            } else
                counter2 = 1;
        }

        String s3 = Arrays.toString(secondWordSearchArray).replaceAll(word2, "").replaceAll("[^a-zA-Z ']+","").replaceAll("\\s+", " ").trim();;
        String[] finalArr3 = s3.split(" ");
        Stream<String> sorted3 = Arrays.stream(finalArr3).sorted();
        Object[] thirdWordSearchArray = sorted3.toArray();

        if(thirdWordSearchArray.length == 0) {
            return;
        }

        if(thirdWordSearchArray.length == 1) {
            word3 = (String) thirdWordSearchArray[0];
            System.out.println("String: " + Arrays.toString(firstWordSearchArray));
            System.out.println("String: " + s2);
            System.out.println("String: " + Arrays.toString(secondWordSearchArray));
            System.out.println("String: " + s3);
            System.out.println("String: " + Arrays.toString(thirdWordSearchArray));
            System.out.println("Result: ");
            System.out.println("1st word: " + word1 + " " + counterFinal);
            System.out.println("2nd word: " + word2 + " " + counter2);
            System.out.println("3rd word: " + word3 + " " + counterFinal3);
            return;
        }

        for (int i = 1; i < thirdWordSearchArray.length; i++) {
            if ((thirdWordSearchArray[i - 1].equals(thirdWordSearchArray[i])) && counter3 >= counterFinal3) {
                counter3++;
                word3 = (String) thirdWordSearchArray[i];
                counterFinal3 = counter3;
            } else if (thirdWordSearchArray[i - 1].equals(thirdWordSearchArray[i]) && counter3 < counterFinal3) {
                counter3++;
            } else
                counter3 = 1;
        }

        System.out.println("String: " + Arrays.toString(firstWordSearchArray));
        System.out.println("String: " + s2);
        System.out.println("String: " + Arrays.toString(secondWordSearchArray));
        System.out.println("String: " + s3);
        System.out.println("String: " + Arrays.toString(thirdWordSearchArray));
        System.out.println("Result: ");
        System.out.println("1st word: " + word1 + " " + counterFinal);
        System.out.println("2nd word: " + word2 + " " + counter2);
        System.out.println("3rd word: " + word3 + " " + counterFinal3);

        List<String> result = new ArrayList<>();
        result.add(word1);
        result.add(word2);
        result.add(word3);

        System.out.println(result);

    }
}
