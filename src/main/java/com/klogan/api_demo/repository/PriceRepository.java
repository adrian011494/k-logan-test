package com.klogan.api_demo.repository;

import com.klogan.api_demo.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositorio que proporciona acceso a la base de datos para los precios de productos.
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Método que obtiene los precios aplicables a un producto de una cadena para una fecha dada.
     *
     * @param brandId    Identificador de la cadena.
     * @param productId  Identificador del producto.
     * @param startDate  Fecha de inicio para la búsqueda.
     * @param endDate    Fecha de fin para la búsqueda.
     * @return Lista de objetos Price que contienen los precios aplicables al producto.
     */
    List<Price> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);

}
