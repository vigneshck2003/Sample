import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WeatherAnalyzer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: WeatherAnalyzer <input file>");
            System.exit(1);
        }
        String inputFile = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int maxTemperature = Integer.MIN_VALUE;
            int minTemperature = Integer.MAX_VALUE;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\t");
                if (tokens.length >= 2) {
                    int temperature = Integer.parseInt(tokens[1]);
                    if (temperature > maxTemperature) {
                        maxTemperature = temperature;
                    }
                    if (temperature < minTemperature) {
                        minTemperature = temperature;
                    }
                }
            }
            System.out.println("Maximum Temperature: " + maxTemperature);
            System.out.println("Minimum Temperature: " + minTemperature);
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid temperature value: " + e.getMessage());
        }
    }
}
