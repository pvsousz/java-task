package LESSON_06.exercise.task_01;

public class Main {
    public static void main(String[] args) {
        Official funcionario = new Official("Robson", 1800.0);
        Assistent assistent = new Assistent("Michael", 2000.0, "76347348");
        Technician technician = new Technician("Samuel", 1500.0, "64748477", 400);
        Administrative administrative = new Administrative("Mj", 4000.0, "78433321", false, 800);
        
        funcionario.showDates();
        System.out.println("----------------------------------");
        assistent.showDates();
        System.out.println("----------------------------------");
        technician.showDates();
        System.out.println("----------------------------------");
        administrative.showDates();
        System.out.println("----------------------------------");
    }

}
