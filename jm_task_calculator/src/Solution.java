import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calculator calc = new Calculator();
        String input = "";
        while (true){
            System.out.println("Введите выражение или наберите команду \"exit\" для выхода.");
            try {
                input = reader.readLine();
                if (input.equals("exit")){
                    System.out.println("Введена команда \"exit\"!");
                    break;
                } else  if (Pattern.matches("^[1-9]0?\\s[\\+\\-\\/\\*]{1}\\s[1-9]0?", input)){
                    System.out.println(calc.Calculate(input, true));
                } else  if (Pattern.matches("^[IVX]+\\s[\\+\\-\\/\\*]{1}\\s[IVX]+", input.toUpperCase())){
                    System.out.println(calc.Calculate(input, false));
                } else {
                    throw new InvalidInputException("Введены некоректные данные, вычисление произвести нельзя.");
                } // end if input
            } catch (InvalidInputException e) {
                //System.out.println(e.getMessage());
                e.printStackTrace();
                break;
            } catch (BigNumbersException e) {
                e.printStackTrace();
                break;
            }catch (IOException e) {
                e.printStackTrace();
                break;
            }// end try

        } // end while
        try {
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } //end try
    } // end main
}
