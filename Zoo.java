import java.util.List;
import java.util.Objects;

public class Zoo {
    private final String name;
    private final Integer size; //in square meters
    private final List<Animal> animals;

    protected Zoo(String name, Integer length, Integer width, List<Animal> animals) {
        this.name = name;
        this.size = length * width;
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", size=" + size + '\'' +
                ", animals=" + animals +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zoo)) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(name, zoo.name) && Objects.equals(size, zoo.size) && Objects.equals(animals, zoo.animals);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, animals);
        result = 31 * result + Objects.hash(size);
        return result;
    }
}
