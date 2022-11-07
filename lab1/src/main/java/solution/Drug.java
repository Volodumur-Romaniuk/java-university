package solution;

import java.util.Objects;
import java.util.UUID;

public class Drug {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String manufacturer;
    private Double price;
    public Drug() {

    }
    public Drug(String name, String manufacturer, Double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drug drug)) return false;
        return Objects.equals(getId(), drug.getId()) && Objects.equals(getName(), drug.getName()) && Objects.equals(getManufacturer(), drug.getManufacturer()) && Objects.equals(getPrice(), drug.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getManufacturer(), getPrice());
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }
}
