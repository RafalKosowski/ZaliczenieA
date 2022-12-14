package pl.zaliczeniea.zaliczeniea;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DatabaseClient {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    // Students
    @GetMapping("/students")
    public String getStudents() throws JsonProcessingException {
        List students = jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<>(Student.class));
        return objectMapper.writeValueAsString(students);
    }

    @GetMapping("/students/{id}")
    public String getStudent(@PathVariable("id") Integer id) throws JsonProcessingException {
        List students = jdbcTemplate.query("SELECT * FROM student WHERE id = :id",
                new MapSqlParameterSource()
                        .addValue("id", id), new BeanPropertyRowMapper<>(Student.class));

        return objectMapper.writeValueAsString(students.get(0));
    }

    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody Student student) {
        String sql = "INSERT into student(firstname, lastname, schoolClass) VALUES(:firstname, :lastname, :schoolClass)";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("firstname", student.getFirstname())
                .addValue("lastname", student.getLastname())
                .addValue("schoolClass", student.getSchoolClass());

        jdbcTemplate.update(sql, parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Integer id) {
        String sql = "DELETE FROM student where id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("id", id);

        jdbcTemplate.update(sql, parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateStudent(@PathVariable("id") Integer id,@RequestBody Student student) {
        String sql = "UPDATE student SET firstname=:firstname,lastname=:lastname,schoolClass=:schoolClass WHERE id=:id ";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("firstname", student.getFirstname())
                .addValue("lastname", student.getLastname())
                .addValue("schoolClass", student.getSchoolClass());

        jdbcTemplate.update(sql, parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Subjects

    @GetMapping("/subjects")
    public String getSubject() throws JsonProcessingException {
        List subjects = jdbcTemplate.query("SELECT * FROM subject", new BeanPropertyRowMapper<>(Subject.class));
        return objectMapper.writeValueAsString(subjects);
    }

    @GetMapping("/subjects/{id}")
    public String getSubject(@PathVariable("id") Integer id) throws JsonProcessingException {
        List subjects = jdbcTemplate.query("SELECT * FROM subject WHERE id = :id",
                new MapSqlParameterSource()
                        .addValue("id", id), new BeanPropertyRowMapper<>(Subject.class));

        return objectMapper.writeValueAsString(subjects.get(0));
    }

    @PostMapping("/subjects")
    public ResponseEntity addSubiect(@RequestBody Subject subject) {
        String sql = "INSERT into subject(name) VALUES(:name)";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", subject.getName());


        jdbcTemplate.update(sql, parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity deleteSubject(@PathVariable("id") Integer id) {
        String sql = "DELETE FROM subject where id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("id", id);

        jdbcTemplate.update(sql, parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/subjects/{id}")
    public ResponseEntity updateSubject(@PathVariable("id") Integer id,@RequestBody Subject subject) {
        String sql = "UPDATE subject SET name=:name WHERE id=:id ";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("name", subject.getName());

        jdbcTemplate.update(sql, parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }
    // Grades
    @GetMapping("/grades")
    public String getGrade() throws JsonProcessingException {
        List grades = jdbcTemplate.query("SELECT * FROM grade", new BeanPropertyRowMapper<>(Grade.class));
        return objectMapper.writeValueAsString(grades);
    }

    @GetMapping("/grades/{id}")
    public String getGrade(@PathVariable("id") Integer id) throws JsonProcessingException {
        List grades = jdbcTemplate.query("SELECT * FROM grade WHERE id = :id",
                new MapSqlParameterSource()
                        .addValue("id", id), new BeanPropertyRowMapper<>(Grade.class));

        return objectMapper.writeValueAsString(grades.get(0));
    }

    @PostMapping("/grades")
    public ResponseEntity addGrade(@RequestBody Grade grade) {
        String sql = "INSERT into grade(grade,description,studentID,subjectID) VALUES(:grade,:description,:studentID,:subjectID)";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("grade", grade.getGrade())
                .addValue("description", grade.getDescription())
                .addValue("studentID", grade.getStudentID())
                .addValue("subjectID", grade.getSubjectID());



        jdbcTemplate.update(sql, parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/grades/{id}")
    public ResponseEntity deleteGrade(@PathVariable("id") Integer id) {
        String sql = "DELETE FROM grade where id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("id", id);

        jdbcTemplate.update(sql, parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/grades/{id}")
    public ResponseEntity updateGrade(@PathVariable("id") Integer id,@RequestBody Grade grade) {
        String sql = "UPDATE grade SET grade=:grade,description=:description,studentID=:studentID,subjectID=:subjectID WHERE id=:id";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("grade", grade.getGrade())
                .addValue("description", grade.getDescription())
                .addValue("studentID", grade.getStudentID())
                .addValue("subjectID", grade.getSubjectID());


        jdbcTemplate.update(sql, parameters);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}