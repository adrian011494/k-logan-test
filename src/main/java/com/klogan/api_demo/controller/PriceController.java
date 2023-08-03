package com.klogan.api_demo.controller;

import com.klogan.api_demo.entity.Price;
import com.klogan.api_demo.repository.PriceRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controlador que maneja las peticiones REST relacionadas con los precios de productos.
 */
@RestController
public class PriceController {

    private final PriceRepository priceRepository;

    /**
     * Constructor del controlador PriceController.
     *
     * @param priceRepository Repositorio de precios (PriceRepository) que proporciona acceso a la base de datos.
     */
    public PriceController(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * End point REST que permite obtener el precio final de un producto de una cadena en una fecha determinada.
     *
     * @param date     Fecha de aplicación para consultar el precio.
     * @param productId Identificador del producto.
     * @param brandId  Identificador de la cadena.
     * @return Objeto Price que contiene el precio final y otros detalles.
     */
    @GetMapping("/getPrice")
    public Price getPrice(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {

        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                brandId, productId, date, date);

        if (!prices.isEmpty()) {
            return prices.get(0);
        }

        return null; // Opcional: Devolver un objeto con valores predeterminados o lanzar una excepción
    }

    /**
     * End point REST que permite obtener todos los precios almacenados en la base de datos.
     *
     * @return Lista de objetos Price que contienen los precios de todos los productos y cadenas.
     */
    @GetMapping("/getAllPrices")
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }
}
