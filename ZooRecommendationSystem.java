import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class ZooRecommendationSystem {
    public static final Integer ANIMAL_FIELDS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Gathering information about the zoo
        System.out.println("Welcome to the Zoo Recommendation System!");
        System.out.println("Please provide information about your new zoo:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Property length: ");
        Integer length = scanner.nextInt();
        System.out.print("Property width: ");
        Integer width = scanner.nextInt();

        //Gathering information about the animals
        System.out.print("Give the file path of the text file with the list of animal's information");
        String filePath = scanner.nextLine();

        List<Animal> animals = readAnimals(filePath);

        //Create a zoo with the list of animals
        Zoo theZoo = new Zoo(name, length, width, animals);
        System.out.println("The zoo is" + theZoo);
    }

    public static List<Animal> readAnimals(String filePath) {
        List<Animal> animals = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma into individual fields
                String[] fields = line.split(",");
                if (fields.length == ANIMAL_FIELDS) {
                    Animal animal = getAnimal(fields);
                    animals.add(animal);
                } else {
                    System.out.println("Invalid input format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return animals;
    }

    private static Animal getAnimal(String[] fields) {
        String category = fields[0].trim();
        int length = Integer.parseInt(fields[1].trim());
        int width = Integer.parseInt(fields[2].trim());
        double cost = Double.parseDouble(fields[3].trim());
        int visitorRewardIndication = Integer.parseInt(fields[4].trim());

        return new Animal(category, cost, length, width, visitorRewardIndication);
    }
}
