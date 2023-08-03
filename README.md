# API Demo - Precio de Productos

Este proyecto es una API de demostración para obtener el precio final de un producto de una cadena (brand) en una fecha determinada.

## Tecnologías utilizadas

- Java
- Spring Boot
- H2 Database (en memoria)

## Descripción del proyecto

La API permite obtener el precio final de un producto en función de una fecha específica, el identificador del producto y el identificador de la cadena (brand). Los precios se almacenan en una base de datos H2 en memoria.

## Estructura del proyecto

El proyecto sigue una estructura básica de Spring Boot:

- `com.klogan.api_demo`: Paquete raíz del proyecto.
    - `controller`: Contiene el controlador `PriceController`, que maneja las peticiones REST relacionadas con los precios de productos.
    - `entity`: Contiene la entidad `Price`, que representa un registro de precios en la base de datos.
    - `repository`: Contiene el repositorio `PriceRepository`, que proporciona acceso a la base de datos para los precios de productos.

## Configuración

El proyecto está configurado para utilizar una base de datos H2 en memoria. Los datos de ejemplo se cargan automáticamente desde el archivo `data.sql`. Puedes acceder a la consola de la base de datos H2 en `http://localhost:8080/h2-console` (asegúrate de que la URL de la base de datos sea `jdbc:h2:mem:testdb`, el usuario `sa` y sin contraseña).

## Endpoints

La API expone los siguientes endpoints:

- `GET /getPrice`: Permite obtener el precio final de un producto en una fecha específica. Requiere los parámetros `date` (fecha en formato ISO-8601), `productId` (identificador del producto) y `brandId` (identificador de la cadena).
- `GET /getAllPrices`: Permite obtener todos los precios almacenados en la base de datos.

## Ejecución

Para ejecutar el proyecto, puedes utilizar el siguiente comando desde la raíz del proyecto:

`
./gradlew bootRun
`


## Pruebas

Se han incluido pruebas unitarias para el controlador `PriceController`. Puedes ejecutar las pruebas utilizando el siguiente comando:

`
./gradlew test
`


## Contribuciones

Este proyecto es solo una demostración, pero si deseas contribuir o realizar mejoras, no dudes en enviar un pull request. ¡Tus contribuciones serán bienvenidas!

## Licencia

Este proyecto está bajo la Licencia MIT. Puedes consultar el archivo [LICENSE](LICENSE) para más detalles.

¡Gracias por revisar esta demostración! Si tienes alguna pregunta o sugerencia, no dudes en contactarnos. ¡Esperamos que encuentres útil este proyecto!
