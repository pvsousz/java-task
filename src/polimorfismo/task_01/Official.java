package LESSON_06.exercise.task_01;

public class Official {
    private String name;
    private Double salary;

    public Official(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public double gainYearly() {
        return 12 * getSalary();
    }

    public void showDates() {
        System.out.println("Nome: " + getName()
                + "\nSalario: " + getSalary()
                + "\nGanho Anual: " + gainYearly());
    }

}
