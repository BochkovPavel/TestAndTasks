import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calculator calc = new Calculator();
        String str = "";
        while (true){

            try {
                str = reader.readLine();
                if (str.equals("exit")){
                    System.out.println("Введена команда \"exit\"!");
                    break;
                //}
                //if (Pattern.matches("^\\D+\\s// [\\+\\-\\/\\*]{1}\\s\\D+", str)){
                   // strList = str.split("\\s");

                  //  System.out.println(romanToArabic(strList[0]) + strList[1] + romanToArabic(strList[2])
                  //          + arabicToRoman(romanToArabic(strList[0])) + arabicToRoman(romanToArabic(strList[0])));
                } else  if (Pattern.matches("^\\d+\\s[\\+\\-\\/\\*]{1}\\s\\d+", str) ||
                        Pattern.matches("^[IVXLCDM]+\\s[\\+\\-\\/\\*]{1}\\s[IVXLCDM]+", str.toUpperCase())){
                    System.out.println(str + "pattern");
                } else System.out.println("Введите корректно арифметическую операцию или введите команду \"exit\" для завершения операций.");
            } catch (IOException e) {
                System.out.println("Введена пустая строка!");

                e.printStackTrace();
                break;
            } // end try

        } // end while
        try {
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } // end main


}
