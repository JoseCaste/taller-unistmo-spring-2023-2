package com.unistmo.operation.crud;


import com.unistmo.exception.ControllerException;

public interface ICrudOperation<T> {

    T saveItem(T item);

    void deleteItem(Long idProduct) throws ControllerException;

    T updateItem(T itemToUpdate);
}
