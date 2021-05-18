package ru.itis.xokken.myanimesity.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;



@Builder
@Data
@EqualsAndHashCode(exclude = "persons")
@ToString(exclude = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipment")
    private List<Person> persons;
}
