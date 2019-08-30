package com.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name="tb_user_info")
public class UserInfo implements Serializable {

    @Id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private Long userId;
}
