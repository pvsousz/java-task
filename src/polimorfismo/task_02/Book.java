package LESSON_06.exercise.task_02;

public class Book extends Product {
    private String author;

    public Book(String nameStore, double price, String description, String author) {
        super(nameStore, price, description);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + "Autor: " + this.author;
    }
}
