package converter;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    Scanner scanner = new Scanner(System.in);

    //regex pattern for source number
    private Pattern pattern;

    public Input() {
        //default constructor
    }

    public String getSourceNumber() {
        System.out.println("Input source number:");
        String input = scanner.next().toLowerCase();

        if (!pattern.matcher(input).matches()) {
            System.out.println("Error: input should contain only numbers and letters");
            System.exit(0);
        }

        return input;
    }

    public int getSourceBase() {
        System.out.println("Input source base:");
        int sourceBase = getBase();

        if (sourceBase > 10) {
            pattern = Pattern.compile("[0-9a-" + (char) (sourceBase + 86) + ",.]+");
        } else {
            pattern = Pattern.compile("[0-" + (char) Math.max(sourceBase + 47, 49) + ",.]+");
        }

        return sourceBase;
    }

    public int getFinalBase() {
        System.out.println("Input final base:");

        return getBase();
    }

    private int getBase() {
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: non numerical input");
            System.exit(0);
        }
        if (input < 1 || input > 36 ) {
            System.out.println("Error: min base value is 1 and max is 36");
            System.exit(0);
        }
        return input;
    }

}
