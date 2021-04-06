package lt.codeacademy;

public class GradeService {

    private MarksDao marksDao = new InternalMarksDao(); // [5, 8, 10, 10, 7, 6, 8]

    public Double averageGrade() {
        Double sum = 0.0;

        for (Integer grade : marksDao.getMarks()) {
            sum += grade;
        }

        return sum / marksDao.getMarks().size();
    }
}
