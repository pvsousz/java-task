package LESSON_06.exercise.task_02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> cart = new ArrayList<>();

        cart.add(new Mouse("Loja 1", 29.99, "Mouse ótico, Saída USB. 1.600 dpi", "Optico"));
        cart.add(new Book("Loja 2", 28.00, "Livro de Romance", "Michae Alves"));

        for (Product product : cart) {
            System.out.println("Nome da loja: " + product.getNameStore());
            System.out.println("Preço do produto: " + product.getPrice());
            System.out.println("Descriçao do produto: " + product.getDescription());
            System.out.println("------------------------------");
        }
    }
}
