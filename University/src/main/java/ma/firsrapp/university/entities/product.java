package ma.firsrapp.university.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class product {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private int quantity;










}
