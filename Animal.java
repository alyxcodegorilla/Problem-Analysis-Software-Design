import java.util.Arrays;
import java.util.Objects;

public class Animal {
    String category;
    Integer cost;
    Integer[][] minimalSpaceRequirement; //length x width
    Integer visitorRewardsValue; //this is based on a scale from 1-10 where 1 is the lowest and 10 the highest

    public Animal(String category, Integer cost, Integer[][] minimalSpaceRequirement, Integer visitorRewardsValue) {
        this.category = category;
        this.cost = cost;
        this.minimalSpaceRequirement = minimalSpaceRequirement;
        this.visitorRewardsValue = visitorRewardsValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(category, animal.category) && Objects.equals(cost, animal.cost) && Arrays.deepEquals(minimalSpaceRequirement, animal.minimalSpaceRequirement) && Objects.equals(visitorRewardsValue, animal.visitorRewardsValue);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(category, cost, visitorRewardsValue);
        result = 31 * result + Arrays.deepHashCode(minimalSpaceRequirement);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "category='" + category + '\'' +
                ", cost=" + cost +
                ", minimalSpaceRequirement=" + Arrays.toString(minimalSpaceRequirement) +
                ", visitorRewardsValue=" + visitorRewardsValue +
                '}';
    }
}
