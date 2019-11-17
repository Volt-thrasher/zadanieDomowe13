package z1;

public class Country {
    private String index;
    private String name;
    private String population;

    public Country(String index, String name, String population) {
        this.index = index;
        this.name = name;
        this.population = population;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return name + ", (" +
                index + ") ma " +
                population + " ludnosci";
    }
}
