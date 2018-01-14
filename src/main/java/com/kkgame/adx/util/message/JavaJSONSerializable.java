package com.kkgame.adx.util.message;

import com.kkgame.adx.util.OM;

/**
 * Created by Administrator on 2017/8/17.
 */
public abstract class JavaJSONSerializable {

    public String toString() {
        return OM.toJOSN(this);
    }
}
