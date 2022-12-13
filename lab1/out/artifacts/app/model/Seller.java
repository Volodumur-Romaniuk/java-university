package model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Seller extends Person{
    @Min(value = 100,message = "Дайте зарплату")
    private double salary;

    private Position position;
    public Seller() {
        super();
    }
    public Seller(String name, String surname, LocalDate birthday, Sex sex, double salary, Position position) {
        super(name, surname, birthday, sex);
        this.salary = salary;
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seller seller)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(seller.getSalary(), getSalary()) == 0 && getPosition() == seller.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalary(), getPosition());
    }

    @Override
    public String toString() {

        return "Seller{" +
                "name=" + getName()+ '\n' +
                "surname=" + getSurname()+ '\n' +
                "birthday=" + getBirthday()+ '\n' +
                "sex=" + getSex()+ '\n' +
                "salary=" + salary + '\n' +
                "position=" + position + '\n' +
                '}';
    }


    public static class SellerBuilder{
        private double salary;
        private Position position;
        private String name;
        private String surname;
        private LocalDate birthday;
        private Sex sex;

        public Seller.SellerBuilder salary(double salary){
            this.salary = salary;
            return this;
        }
        public Seller.SellerBuilder position(Position position){
            this.position = position;
            return this;
        }
        public Seller.SellerBuilder name(String name){
            this.name = name;
            return this;
        }
        public Seller.SellerBuilder surname(String surname){
           this.surname = surname;
            return this;
        }
        public Seller.SellerBuilder birthday(LocalDate birthday){
            this.birthday = birthday;
            return this;
        }
        public Seller.SellerBuilder sex(Sex sex){
            this.sex = sex;
            return this;
        }
        public Seller build(){
            var seller =  new Seller(name,surname,birthday,sex,salary,position);
            validate(seller);
            return seller;
        }

        public Seller validate(Seller obj) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Seller>> violations = validator.validate(obj);
            if (violations.isEmpty()) {
                return obj;
            } else {
                StringBuilder sb = new StringBuilder();
                for (var violation : violations) {
                    sb.append(violation.getInvalidValue()).append(" : ").append(violation.getMessage());
                }
                return null;
            }
        }
    }
}
