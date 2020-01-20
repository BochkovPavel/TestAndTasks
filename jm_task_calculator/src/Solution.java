import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String strList[];
        int res;
        while (true){
            try {
                str = reader.readLine();
                if (Pattern.matches("^\\d+\\s[\\+\\-\\/\\*]{1}\\s\\d+", str)){
                    strList = str.split("\\s");
                    
                    System.out.println(strList[0] + strList[1] + strList[2]);
                } else break;
            } catch (IOException e) {
                System.out.println("Введена пустая строка!");
                e.printStackTrace();
                break;
            } // end try
        } // end while

    } // end main
}
