package com.bradMr2.apirest.apirest2.Repositories;

import com.bradMr2.apirest.apirest2.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
