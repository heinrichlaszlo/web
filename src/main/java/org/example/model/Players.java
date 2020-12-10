package org.example.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Players {

    private int id;
    private Timestamp dob;
    private String first_name;
    private String last_name;
    private int height;
    private int weight;
}
