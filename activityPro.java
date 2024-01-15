package IncodevActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Citizen {
    private int age;

    public Citizen() {
        this.age = new Random().nextInt(101);
    }
}

class City {
    private String name;
    private List<Citizen> citizens;

    public City(String name) {
        if (name == null || name.isEmpty()) {
            this.name = generateRandomCityName();
        } else {
            this.name = name;
        }
        this.citizens = new ArrayList<>();
        addRandomCitizens();
    }

    public void addCitizen() {
        citizens.add(new Citizen());
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public String getName() {
        return name;
    }

    private void addRandomCitizens() {
        for (int i = 0; i < 50; i++) {
            addCitizen();
        }
    }

    private String generateRandomCityName() {
        StringBuilder randomName = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            randomName.append(randomChar);
        }
        return randomName.toString();
    }
}

class World {
    private List<City> cities;

    public World(int num) {
        this.cities = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            addCity(null);
        }
    }

    public void addCity(String name) {
        cities.add(new City(name));
    }

    public City randomCity() {
        Random random = new Random();
        return cities.get(random.nextInt(cities.size()));
    }

    public int totalCities() {
        return cities.size();
    }
}

public class activityPro {
    public static void main(String[] args) {
        World world = new World(50);

        // Adding more cities
        world.addCity("New York");
        world.addCity("Tokyo");

        // Getting a random city
        City randomCity = world.randomCity();
        System.out.println("Random City Name: " + randomCity.getName());

        // Total number of cities in the world
        int totalCities = world.totalCities();
        System.out.println("Total Cities in the World: " + totalCities);
    }
}
