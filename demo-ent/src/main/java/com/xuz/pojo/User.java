package com.xuz.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer lUserId;
    private String vcUserName;
    private String vcUserPassword;
}
