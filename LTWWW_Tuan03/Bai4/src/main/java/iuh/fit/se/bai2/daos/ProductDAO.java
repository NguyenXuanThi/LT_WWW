package iuh.fit.se.bai2.daos;

import iuh.fit.se.bai2.models.Product;
import java.util.*;
public interface ProductDAO {
    public void insert(Product product);
    public List<Product> getAll();
    public void delete(String id);
    public Product getById(String id);
    }
