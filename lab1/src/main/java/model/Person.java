package model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    @NotEmpty(message = "Введіть імя")
    private String name;
    private String surname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private Sex sex;

    public Person() {

    }
    public Person(String name, String surname, LocalDate birthday, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(), person.getSurname()) && Objects.equals(getBirthday(), person.getBirthday()) && getSex() == person.getSex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthday(), getSex());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                '}';
    }
}
