package entities;

import java.util.Objects;

public class Students {

    int studentNumber;
    String curso;

    public Students(int studentNumber, String curso) {
        this.studentNumber = studentNumber;
        this.curso = curso;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return studentNumber == students.studentNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentNumber);
    }


}
