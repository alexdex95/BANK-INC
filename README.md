# BANK-INC
Proyecto de Bank Inc para la asignación de tarjetas.
***********************************************************************************************************************************
Desarrollado Por: Jefferson Alexander Moreno Barrera
***********************************************************************************************************************************
## Instrucciones para ejecutar la aplicación

1. Clonar el repositorio.
2. Importar proyecto en IDE de preferencia.
3. Ejecutar comando mvn clean install.
4. Iniciar proyecto spring.
5. Importar colección en postman.
7. Ejecutar pruebas, tener en cuenta que en la API Crear Tarjeta se requiere el dato del numero de la tarjeta que se obtiene de la API Generar Numero de Tarjeta

## Tecnologias

1.  Maven: Gestor de dependencias para el manejo del empaquetado e implementación de librerías externas
2.  Spring Boot: Modulo de spring para el desarrollo de la API REST 
3.  Java 11: leguaje de codificación del aplicativo
4.  Eclipse: IDE de desarrollo
5.  Google Cloud: Plataforma cloud para hostear la API
6.  GIT: software de manejo de versiones de la API
7.  Postman: Plataforma para el diseño y pruebas de API
8.  JUnit: Biblioteca para desarrollo de pruebas unitarias a la API
9.  H2: Base de datos en memoria
10. Flyway: dependencia para la migracion de base de datos H2

## Versiones usadas en el proyecto:

* [Spring-Boot]: Version 3.0.3 
* [H2] : Version 2.1.212 
* [Flyway] : Version 9.0.0
* [JUnit] : Version 4.4
* [Mockito] : Version ‎4.2.0

## API REST

## 1. Generar número de tarjeta
Tipo de método: GET
Recurso: /card/{productId}/number

```curl
    curl --location 'http://localhost:8080/V1/API/card/1/number'
```

## 2. Crear Tarjeta
Tipo de método: POST
Recurso: /card/create

```curl
    curl --location 'http://localhost:8080/V1/API/card/create' \
--header 'Content-Type: application/json' \
--data '{
    "cardId": "1000001514737897",
    "firstName":"Jefferson Moreno"
}'
```

## 3. Activar tarjeta
Tipo de método: POST
Recurso: /card/enroll

```curl
    curl --location 'http://localhost:8080/V1/API/card/enroll' \
--header 'Content-Type: application/json' \
--data '{
 "cardId":"1000001616057078"
}'
```

## 4. Bloquear tarjeta
Tipo de método: DELETE
Recurso: /card/{cardId}

```curl
    curl --location --request DELETE 'http://localhost:8080/V1/API/card/1000001616057078'
```


## 5. Recargar saldo
Tipo de método: POST
Recurso: /card/balance

```curl
    curl --location 'http://localhost:8080/V1/API/card/balance' \
--header 'Content-Type: application/json' \
--data '{
 "cardId": "1000001514737897",
 "balance":"50000"
}'
```

## 6. Consulta de saldo
Tipo de método: GET
Recurso: /card/balance/{cardId}

```curl
    curl --location 'http://localhost:8080/V1/API/card/balance/1000001514737897'
```

## 7. Transacción de compra
Tipo de método: POST
Recurso: /transaction/purchase

```curl
   curl --location 'http://localhost:8080/V1/API/transaction/purchase' \
--header 'Content-Type: application/json' \
--data '{
 "cardId": "1000001514737897",
 "price": 1000,
 "currency":"USD"
}'
```

## 8. Consultar transacción
Tipo de método: GET
Recurso: /transaction/{transactionId}

```curl
    curl --location 'http://localhost:8080/V1/API/transaction/0'
```

## 9. Anular transacciones
Tipo de método: POST
Recurso: /transaction/anulation

```curl
    curl --location 'http://localhost:8080/V1/API/transaction/anulation' \
--header 'Content-Type: application/json' \
--data '{
 "cardId": "1000001514737897",
 "transactionId": "0"
}'
```

## Colección Postman

https://drive.google.com/drive/folders/1zu6FUQDnGCAwdAxSaPRgd1y967QL2B9r

## Autor
@alexdex95
