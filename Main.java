package converter;

public class Main {
    public static void main(String[] args) {
        Input userInput = new Input();

        Converter converter = new Converter(userInput.getSourceBase(), userInput.getSourceNumber(), userInput.getFinalBase());
        System.out.println(converter.convert());
    }
}