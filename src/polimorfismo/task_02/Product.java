package LESSON_06.exercise.task_02;

public class Product {
    private String nameStore;
    private double price;
    private String description = "Produto Infortica";

    public Product(String nameStore, double price, String description) {
        this.nameStore = nameStore;
        this.price = price;
        this.description = description;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

}
