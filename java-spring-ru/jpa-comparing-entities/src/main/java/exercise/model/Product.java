package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Entity
@Table(name = "products")
@Setter
@Getter
@EqualsAndHashCode(of ={"title", "price"})
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String title;
    int price;
}
// END
