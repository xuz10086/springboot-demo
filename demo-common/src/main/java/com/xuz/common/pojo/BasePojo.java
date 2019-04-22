package com.xuz.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasePojo implements Serializable {
    private static final long serialVersionUID = -3607689545418786302L;

    private Integer pagesize;
    private Integer pageindex;
    private Integer lN;

}
