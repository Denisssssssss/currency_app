package com.example.curency.impl.util;

import feign.Param;

public class ParamsExpander implements Param.Expander {
    @Override
    public String expand(Object value) {
        return value.toString();
    }
}
