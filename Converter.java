package converter;

public class Converter {

    private final String sourceNumber;

    private final int sourceBase;

    private final int finalBase;

    public Converter(int sourceBase, String sourceNumber, int finalBase) {
        this.sourceBase = sourceBase;
        this.sourceNumber = sourceNumber;
        this.finalBase = finalBase;
    }

    public final String convert() {
        String[] number = sourceNumber.split("[,.]");

        if (number.length == 1) {
            return convertIntegerPart(number[0]);
        } else if (number.length == 2) {
            return convertIntegerPart(number[0]) + "." + convertDecimalPart(number[1]);
        } else {
            return "Error: incorrect number";
        }
    }

    private String convertIntegerPart(String sourceNumber) {
        int temp = 0;

        if (sourceBase != 1){
            temp = Integer.parseInt(sourceNumber, sourceBase);
        } else {
            temp = sourceNumber.length();
        }

        if (finalBase != 1) {
            return Integer.toString(temp, finalBase);
        } else {
            return "1".repeat(temp);
        }
    }

    private String convertDecimalPart(String sourceNumber) {
        StringBuilder answer = new StringBuilder();

        if (sourceBase == 1) {
            return "0000000";
        }

        double tempDouble = 0;

        for (int i = 0; i < sourceNumber.length(); i++) {
            tempDouble += (double) Integer.parseInt(Character.toString(sourceNumber.charAt(i)), sourceBase) / Math.pow(sourceBase, i + 1);
        }

        int tempInt;

        for (int i = 0; i < 5; i++) {

            tempDouble *= finalBase;
            tempInt = (int) tempDouble;
            tempDouble -= tempInt;

            answer.append(Integer.toString(tempInt, finalBase));
        }

        return answer.toString();
    }

}
