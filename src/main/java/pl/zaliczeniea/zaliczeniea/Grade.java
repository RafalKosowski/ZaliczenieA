package pl.zaliczeniea.zaliczeniea;

public class Grade {
    private Integer id;
    private Integer grade;
    private String description;
    private Integer studentID;
    private Integer subjectID;

    public Grade(Integer id, Integer ocena, String description, Integer studentID, Integer subjectID) {
        this.id = id;
        this.grade = ocena;
        this.description = description;
        this.studentID = studentID;
        this.subjectID = subjectID;
    }

    public Grade() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public Integer getSubjectID() {
        return subjectID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public void setSubjectID(Integer subjectID) {
        this.subjectID = subjectID;
    }
}
