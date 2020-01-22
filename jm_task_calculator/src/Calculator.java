import java.util.List;

public class Calculator {
    private String[] inputArr;

    public String Calculate (String input, boolean isArabic) throws BigNumbersException, InvalidInputException{
        inputArr = input.split("\\s");
        int x,y,z;
        if (inputArr.length == 3){
            if (!isArabic){
                x = romanToArabic(inputArr[0]);
                y = romanToArabic(inputArr[2]);
            } else {
                x = Integer.parseInt(inputArr[0]);
                y = Integer.parseInt(inputArr[2]);
            } // end if isArabic
            if (x > 10 || y > 10){
                throw new BigNumbersException("Введены числа больше 10.");
            } // end if 10
            switch (inputArr[1]){
                case "+" : z = x + y;break;
                case "-" : z = x - y;break;
                case "*" : z = x * y;break;
                case "/" : z = x / y;break;
                default: throw new InvalidInputException("Введены некоректные данные, вычисление произвести нельзя.");
            } // end switch
            if (!isArabic){
                return arabicToRoman(z);
            } else {
                return "" + z;
            } // end if isArabic 2
        } else throw new InvalidInputException("Введены некоректные данные, вычисление произвести нельзя.");
    }// end Calculate

    private int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " Конвертировать в арабские числа не удалось.");
        }

        return result;
    }// end romanToArabic

    private String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " Не в диапазоне (0,4000], конвертировать не удалось");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }// end arabicToRoman
}

