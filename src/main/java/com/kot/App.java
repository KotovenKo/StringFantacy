package com.kot;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )    {

        String sentence = "Hello, java! Nice try!";
        String result = "olleH, avaj! eciN yrt!";

        StringReverse stringReverseCustom = App::customReverse;
        StringReverse stringReverseStream = App::reverseWordsStream;
        StringReverse stringReverseOptimal = App::reverseWordsOptimal;

        String resultCustom = stringReverseCustom.reverse(sentence);
        String resultStream = stringReverseStream.reverse(sentence);
        String resultOptimal = stringReverseOptimal.reverse(sentence);

        System.out.println(resultCustom.equals(result));
        System.out.println(resultStream.equals(result));
        System.out.println(resultOptimal.equals(result));



    }

    public static String reverseWordsOptimal(String string){
        StringBuilder mainBuilder = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for(char c: string.toCharArray()){
            if (Character.isLetter(c)){
                builder.insert(0, c);
            } else {
                mainBuilder.append(builder).append(c);
                builder.setLength(0);
            }
        }
        return mainBuilder.append(builder).toString();
    }

    public static String customReverse(String s) {
        StringBuilder result = new StringBuilder();
        for (String word : s.split(" ")) {

            StringBuilder temp = new StringBuilder(word.replaceAll("[\\W\\d+]", "")).reverse();

            for (int i = 0; i < word.length(); i++) {
                if (!Character.isLetter(word.charAt(i))) {
                    temp.insert(i, word.charAt(i));
                }
            }
            result.append(temp).append(" ");
        }
        return result.toString().trim();
    }

    public  static String reverseWordsStream(String sentence) {
        String[] words = sentence.split(" ");
        return Arrays.stream(words).map(App::reverseWord).collect(Collectors.joining(" "));
    }

    private  static String reverseWord(String word) {
        String noPunctuation = word.replaceAll("\\W", "");
        String reversed = new StringBuilder(noPunctuation).reverse().toString();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!Character.isAlphabetic(ch) && !Character.isDigit(ch)) {
                result.append(ch);
            }
            if (i < reversed.length()) {
                result.append(reversed.charAt(i));
            }
        }
        return result.toString();
    }

}
interface StringReverse {
    /**
     * Преобразует строку:
     *  - все слова меняют направление
     *  - вся пунктуация остается на месте
     *
     * @param str исходная строка
     * @return результат преобразования
     */
    String reverse(String str);
}