import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Zoo {
    private final String name;
    private final int[][] size;
    private final List<Animal> animals;

    private Zoo(String name, int[][] size, List<Animal> animals) {
        this.name = name;
        this.size = size;
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", size=" + Arrays.toString(size) +
                ", animals=" + animals +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zoo)) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(name, zoo.name) && Arrays.deepEquals(size, zoo.size) && Objects.equals(animals, zoo.animals);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, animals);
        result = 31 * result + Arrays.deepHashCode(size);
        return result;
    }
}
