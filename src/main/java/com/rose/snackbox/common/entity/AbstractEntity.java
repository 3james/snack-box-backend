package com.rose.snackbox.common.entity;

import lombok.Data;

@Data
public abstract class AbstractEntity extends BaseTimeEntity {

    private String createUser;
    private String modifyUser;

}
