package dto;

import java.math.BigDecimal;

public class ItemDTO {
    String id;
    String name;
    String description;
    int qty;
    double price;

    public ItemDTO() {
    }

    public ItemDTO(String id, String name, String description, int qty, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.qty = qty;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
