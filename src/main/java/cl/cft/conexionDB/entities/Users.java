package cl.cft.conexionDB.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "assignments",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_task")
    )
    private List<Task> tasks;

}
