package miu.edu.model_mapper_demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    @NotBlank(message = "Not blank - empty - null")
    @Column(unique = true)
    private String publisherName;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address publisherAddress;

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }
}
