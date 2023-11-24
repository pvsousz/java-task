package LESSON_06.exercise.task_01;

public class Assistent extends Official {
    private String registration;

    public Assistent(String name, Double salary, String registration) {
        super(name, salary);
        this.registration = registration;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void showDates() {
        System.out.println("Nome: " + getName()
                + "\nMatricula: " + getRegistration()
                + "\nSalario: " + getSalary()
                + "\nGanho Anual: " + gainYearly());
    }

}
