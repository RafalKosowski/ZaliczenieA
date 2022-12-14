package pl.zaliczeniea.zaliczeniea;

public class Student {
    private Integer id;
    private String firstname;
    private String lastname;
    private String schoolClass;

    public Student(Integer id, String firstname, String lastname, String schoolClass) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.schoolClass = schoolClass;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }
}
