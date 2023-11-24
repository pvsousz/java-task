package LESSON_06.exercise.task_01;

public class Administrative extends Assistent {

    private boolean WorkNight;
    private double bonusValue = 200;

    public Administrative(String name, Double salary, String registration, boolean WorkNight, double bonusValue) {
        super(name, salary, registration);
        this.WorkNight = WorkNight;
        this.bonusValue = bonusValue;
    }

    public boolean isWorkNight() {
        return WorkNight;
    }

    public double getBonusValue() {
        return bonusValue;
    }

    public String showWorkNight() {
        if (isWorkNight() == true) {
            return "Sim";
        } else {
            return "Nao";
        }
    }

    public double gainYearly() {
        if (WorkNight == true) {
            return 12 * (getBonusValue() + getSalary());
        } else {
            return 12 * getSalary();
        }
    }

    public void showDates() {
        System.out.println("Nome: " + getName()
                + "\nSalario: " + getSalary()
                + "\nTurno: " + showWorkNight()
                + "\nSalario com Bonus: " + (getSalary() + getBonusValue())
                + "\nGanho Anual: " + gainYearly());
    }

}
