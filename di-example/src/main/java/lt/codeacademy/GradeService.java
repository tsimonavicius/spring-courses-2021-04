package lt.codeacademy;

public class GradeService {

    private MarksDao marksDao;

    public GradeService(MarksDao marksDao) {
        this.marksDao = marksDao;
    }

    public Double averageGrade() {
        Double sum = 0.0;

        for (Integer grade : marksDao.getMarks()) {
            sum += grade;
        }

        return sum / marksDao.getMarks().size();
    }
}
