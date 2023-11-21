package com.unistmo.operation.crud;


import com.unistmo.exception.ControllerException;

import java.util.List;

public interface ICrudOperation<T> {

    T saveItem(T item);

    void deleteItem(Long idProduct) throws ControllerException;

    T updateItem(T itemToUpdate);

    List<?> getAllProducts();
}
