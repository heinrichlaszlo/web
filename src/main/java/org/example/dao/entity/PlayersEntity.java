package org.example.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "players", schema = "AustralianFootball")
public class PlayersEntity {

    @Id

    @Column(name = "pid")
    private int id;

    @Column(name="dob")
    private Timestamp dob;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="height")
    private int height;

    @Column(name="weight")
    private int weight;
}
