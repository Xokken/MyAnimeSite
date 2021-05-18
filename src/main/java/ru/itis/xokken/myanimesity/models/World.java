package ru.itis.xokken.myanimesity.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data  @EqualsAndHashCode(exclude = "persons")
@ToString(exclude = "persons")
@AllArgsConstructor
@NoArgsConstructor
public class World {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    private String img;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "world")
    private List<Person> persons;
}
