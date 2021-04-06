package lt.codeacademy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        simpleDIExample();
        diExampleWithSpring();
    }

    private static void simpleDIExample() {
        System.out.println("Pazymiu vidurkis (naudojant plain Java): " +
                new GradeService(new InternalMarksDao()).averageGrade());
    }

    private static void diExampleWithSpring() {
        ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringContextConfig.class);

        GradeService gradeService = springContext.getBean(GradeService.class);

        System.out.println("Pazymiu vidurkis (naudojant Spring): " +
                gradeService.averageGrade());
    }
}
