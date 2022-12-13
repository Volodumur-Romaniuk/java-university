package com.example.pharmacy.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

//generic
public class Customer extends Person {

    private Order order;

    public Customer(String name, String surname, LocalDate birthday, Sex sex, Order order) {
        super(name, surname, birthday, sex);
        this.order = order;
    }

    public class CustomerBuilder{
        private Order order;


        public CustomerBuilder order(Order order){
            this.order = order;
            return this;
        }
        public CustomerBuilder name(String name){
            setName(name);
            return this;
        }
        public CustomerBuilder surname(String surname){
            setSurname(surname);
            return this;
        }
        public CustomerBuilder birthday(LocalDate birthday){
            setBirthday(birthday);
            return this;
        }
        public CustomerBuilder sex(Sex sex){

            setSex(sex);
            return this;
        }

        public Customer validate(Customer obj) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Customer>> violations = validator.validate(obj);
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
