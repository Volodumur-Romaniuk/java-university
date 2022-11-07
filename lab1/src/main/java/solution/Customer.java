package solution;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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


    }
}
