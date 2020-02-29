package com.yevhenchmykhun.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Visitor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int count;

    private Date date;

}
