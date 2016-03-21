package products.service;

import products.entity.Entity;

public interface Service<T extends Entity> {

    T get(String identifier) throws Exception;

}
