package lt.codeacademy;

public class Main {

    public static void main(String[] args) {
        simpleDIExample();
    }

    private static void simpleDIExample() {
        System.out.println("Pazymiu vidurkis: " +
                new GradeService(new InternalMarksDao()).averageGrade());
    }
}
