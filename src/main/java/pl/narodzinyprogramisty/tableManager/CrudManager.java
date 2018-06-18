package pl.narodzinyprogramisty.tableManager;

import pl.narodzinyprogramisty.entity.BaseModel;

import java.util.List;

public interface CrudManager<T extends BaseModel> {

    String create(T t);

    List<T> read();

    void update(T newT);

    void delete(String id);

}
