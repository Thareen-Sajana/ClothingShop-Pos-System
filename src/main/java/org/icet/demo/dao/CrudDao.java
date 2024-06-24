package org.icet.demo.dao;

import java.util.List;

public interface CrudDao <T> extends SuperDao{
    boolean save(T dto);
    boolean delete(T dto);

    boolean update(T dto);

    List<T> retriveAll();
}
