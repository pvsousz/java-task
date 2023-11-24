package LESSON_06.exercise.task_01;

public class Technician extends Assistent {
    private double bonusValue = 300;

    public Technician(String name, Double salary, String registration, double bonusValue) {
        super(name, salary, registration);
        this.bonusValue = bonusValue;

    }

    public double getBonusValue() {
        return bonusValue;
    }

    public double gainYearly() {
        return 12 * (getBonusValue() + getSalary());
    }

    public void showDates() {
        System.out.println("Nome: " + getName()
                + "\nSalario: " + getSalary()
                + "\nSalario com Bonus: " + (getSalary() + getBonusValue())
                + "\nGanho Anual: " + gainYearly());
    }

}
