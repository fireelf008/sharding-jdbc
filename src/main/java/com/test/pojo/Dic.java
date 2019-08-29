package com.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name="tb_dic")
public class Dic implements Serializable {

    @Id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String k;

    private String v;
}
