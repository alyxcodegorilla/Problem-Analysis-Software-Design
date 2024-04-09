import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


public class ZooRecommendationSystem {
    public static final Integer ANIMAL_FIELDS = 5; //The MVPs
    public static final String ANIMAL_FILEPATH = "animalList.txt";

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
        scanner.nextLine(); // eats the '\n'
        //Gathering information about the animals
        System.out.print("Give the file path of the text file with the list of animal's information: ");
        String filePath = scanner.nextLine();
        scanner.close();

        List<Animal> animals = readAnimals(filePath);

        //Create a zoo with the list of animals
        Zoo theZoo = new Zoo(name, length, width, animals);
        System.out.println("The zoo's information is: \n" + theZoo);
    }

    public static List<Animal> readAnimals(String filePath) {
        if (filePath.isEmpty()) {
            filePath = ANIMAL_FILEPATH;
        }

        List<Animal> animals = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(filePath))) {
            scan.useDelimiter(Pattern.compile("\n"));
            while (scan.hasNext()) {
                String[] fields = scan.next().split(",");
                if (fields.length == ANIMAL_FIELDS) {
                    Animal animal = getAnimal(fields);
                    animals.add(animal);
                } else {
                    System.out.println("Invalid input format: " + Arrays.toString(fields));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return animals;
    }

    private static Animal getAnimal(String[] fields) {
        String category = fields[0].trim();
        double cost = Double.parseDouble(fields[1].trim());
        int length = Integer.parseInt(fields[2].trim());
        int width = Integer.parseInt(fields[3].trim());
        int visitorRewardIndication = Integer.parseInt(fields[4].trim());

        return new Animal(category, cost, length, width, visitorRewardIndication);
    }
}
