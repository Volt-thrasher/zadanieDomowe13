package z2;

public class Vehicle {
    String type;
    String producer;
    String model;
    int year;
    String kilometer;
    String vin;

    public Vehicle(String type, String producer, String model, int year, String kilometer, String vin) {
        this.type = type;
        this.producer = producer;
        this.model = model;
        this.year = year;
        this.kilometer = kilometer;
        this.vin = vin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getKilometer() {
        return kilometer;
    }

    public void setKilometer(String kilometer) {
        this.kilometer = kilometer;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", kilometer='" + kilometer + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
