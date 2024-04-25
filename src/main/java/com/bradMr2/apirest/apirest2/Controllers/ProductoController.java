package com.bradMr2.apirest.apirest2.Controllers;

import com.bradMr2.apirest.apirest2.Entities.Producto;
import com.bradMr2.apirest.apirest2.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no se encontro el porducto con el id: "+ id));

    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return  productoRepository.save(producto);
    }



    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detalleProducto){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no se encontro el porducto con el id: "+ id));

        producto.setNombre(detalleProducto.getNombre());
        producto.setPrecio(detalleProducto.getPrecio());

        return productoRepository.save(producto);

    }



    @DeleteMapping("/{id}")
    public String deleProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("no se encontro el producto con el ID: "+ id));
        productoRepository.delete(producto);
        return "El producto con el ID: "+ id + " fue eliminado correctamente";
    }
}
