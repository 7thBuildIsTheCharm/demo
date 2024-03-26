package com.assignments.demo.model;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Data
@Entity
@Table(name="players")
public class Player {

    @Id
    @CsvBindByName(column = "playerID", required = true)
    String playerID;

    @CsvBindByName(column = "birthYear")
    int birthYear;

    @CsvBindByName(column = "birthMonth")
    int birthMonth;

    @CsvBindByName(column = "birthDay")
    int birthDay;

    @CsvBindByName(column = "birthCountry")
    String birthCountry;

    @CsvBindByName(column = "birthState")
    String birthState;

    @CsvBindByName(column = "birthCity")
    String birthCity;

    @CsvBindByName(column = "deathYear")
    int deathYear;

    @CsvBindByName(column = "deathMonth")
    int deathMonth;

    @CsvBindByName(column = "deathDay")
    int deathDay;

    @CsvBindByName(column = "deathCountry")
    String deathCountry;

    @CsvBindByName(column = "deathState")
    String deathState;

    @CsvBindByName(column = "deathCity")
    String deathCity;

    @CsvBindByName(column = "nameFirst")
    String nameFirst;

    @CsvBindByName(column = "nameLast")
    String nameLast;

    @CsvBindByName(column = "nameGiven")
    String nameGiven;

    @CsvBindByName(column = "weight")
    int weight;

    @CsvBindByName(column = "height")
    int height;

    @CsvBindByName(column = "bats")
    String bats;

    @CsvBindByName(column = "throws")
    String throwsDirection;

    @CsvBindByName(column = "debut")
    String debut;

    @CsvBindByName(column = "finalGame")
    String finalGame;

    @CsvBindByName(column = "retroID")
    String retroID;

    @CsvBindByName(column = "bbrefID")
    String bbrefID;

}
