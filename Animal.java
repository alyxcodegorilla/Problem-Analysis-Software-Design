import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Animal {
    String category;
    Double cost;
    Integer minimalSpaceRequirement; //square meters
    Integer visitorRewardsValue; //this is based on a scale from 1-10 where 1 is the lowest and 10 the highest

    public Animal(String category, Double cost, Integer minimalLength, Integer minimalWidth, Integer visitorRewardsValue) {
        this.category = category;
        this.cost = cost;
        this.minimalSpaceRequirement = minimalLength * minimalWidth;
        this.visitorRewardsValue = visitorRewardsValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(category, animal.category) && Objects.equals(cost, animal.cost) && Objects.equals(minimalSpaceRequirement, animal.minimalSpaceRequirement) && Objects.equals(visitorRewardsValue, animal.visitorRewardsValue);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(category, cost, visitorRewardsValue);
        result = 31 * result + Objects.hash(minimalSpaceRequirement);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "category='" + category + '\'' +
                ", cost=" + cost +
                ", minimalSpaceRequirement=" + minimalSpaceRequirement +
                ", visitorRewardsValue=" + visitorRewardsValue +
                '}';
    }
}
