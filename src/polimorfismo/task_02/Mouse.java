package LESSON_06.exercise.task_02;

public class Mouse extends Product {
    private String tipo;

    public Mouse(String nameStore, double price, String description, String tipo) {
        super(nameStore, price, description);
        this.tipo = tipo;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + "Tipo: " + this.tipo;
    }
}
