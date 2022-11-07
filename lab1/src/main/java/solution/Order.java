package solution;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order implements Serializable {
    private String id = UUID.randomUUID().toString();
    private List<Drug> drugs;
    private Seller  seller;
    private double totalPrice;

    public Order() {

    }

    public Order(List<Drug> drugs, Seller seller) {
        this.drugs = drugs;
        for (Drug element: drugs ) {
            this.totalPrice += element.getPrice();
        }
        this.seller = seller;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Double.compare(order.totalPrice, totalPrice) == 0 && Objects.equals(id, order.id) && Objects.equals(getDrugs(), order.getDrugs()) && Objects.equals(getSeller(), order.getSeller());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getDrugs(), getSeller(), totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' + '\'' +
                ", drugs=" + drugs +  '\'' +
                ", seller=" + seller + '\'' +
                ", totalPrice=" + totalPrice + '\'' +
                '}';
    }

    public static class OrderBuilder {
        private List<Drug> drugs;
        private Seller  seller;
        private double totalPrice;

        public Order.OrderBuilder drugs(List<Drug> drugs) {
            this.drugs = drugs;
            return this;
        }
        public Order.OrderBuilder totalPrice() {
            for (Drug element: drugs ) {
                this.totalPrice += element.getPrice();
            }
            return this;
        }
        public Order.OrderBuilder seller(Seller seller) {
            this.seller = seller;
            return this;
        }
        public Order build(){
           if(seller.getName() == null){
               seller.setName("Sam");
           }
            if(seller.getSurname() == null){
                seller.setSurname("Samovuch");
            }
            if(seller.getSex() == null){
                seller.setSex(Sex.MALE);
            }
            return new Order(drugs,seller);
        }
    }

}
