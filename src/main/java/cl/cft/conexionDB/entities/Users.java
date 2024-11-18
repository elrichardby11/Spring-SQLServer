package cl.cft.conexionDB.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String lastname;

    @OneToOne
    @JoinColumn(name = "id_direction")
    private Direction direction;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

}
