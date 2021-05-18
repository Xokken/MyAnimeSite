package ru.itis.xokken.myanimesity.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String img;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "world_id")
    private World world;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "persons")
    private List<User> users;
}
