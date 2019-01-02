package com.lili.transaction.jpa.listeners;

import com.lili.transaction.jpa.models.BaseModel;

import javax.persistence.PreUpdate;

/**
 * Created by lili19289 on 2016/12/27.
 */
public class BaseModelListener {

    @PreUpdate
    public static void preUpdate(BaseModel baseModel) {

        baseModel.lastModifyTime = System.currentTimeMillis();
    }
}
