package com.acem.db.modifier;

import java.util.List;

public interface FileModifier {

    public Boolean add(Object o);

    public Boolean write(List<Object> list);
    public Boolean update(Object o);

    public Boolean delete(Object o);
}
