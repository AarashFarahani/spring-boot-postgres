package com.sb.txpostgres.repository;

import com.sb.txpostgres.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("update Product p set p.number = ?1 where p.id = ?2")
    int updateProduct(Byte number, Long id);
}
