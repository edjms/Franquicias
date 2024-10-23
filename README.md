# Franquicias

# Contexto
esta aplicacion permite crear y consultar franquicias, sucursales y productos, ademas actualizar
el stock de productos y el maximo numero en stock de algun producto por franquicia especifica.

## Desarrollo

- **Java 17**
- **Spring Boot** 
- **Mysql** 
- **Maven**

En el archivo src\main\resources\application.properties se encuentra:
el nombre de la BD : BdFranquicias, usuario y contraseña de mi BD de forma local


## BD Mysql 

- **version 8 o superior**
- **crear una BD llamada BdFranquicias**
- **cambiar los parametros de username y password**

spring.datasource.url=jdbc:mysql://localhost:3306/BdFranquicias
spring.datasource.username=username
spring.datasource.password=password


### APIS Expuestas

1. **para crear franquicias se condiciono q fuera de nombre unico.**
metodo Post: http://localhost:8080/api/franquicia/guardar/
BODY: 
{
    "nombre" : "Frisby",
    "sucursal": []
}

2. **para crear sucursal, valida q exista primero la franquicia y se agrega como hijo**
metodo Post : http://localhost:8080/api/sucursal/guardar/
BODY: 
{
    "nombre" : "poblado",
    "franquicia" : {
        "nombre" : "Frisby"
        },
    "producto": []
}

3. **para crear productos, valida q exista primero la sucursal y se agrega como hijo**
metodo Post: http://localhost:8080/api/producto/guardar/
BODY: 
{
    "nombre" : "gaseosa",
    "stock" : 100,
    "sucursal" : 
        {"nombre" : "laureles"}
}

4. **para extraer alguna franquicia especifica por el nombre**
Metodo get: http://localhost:8080/api/franquicia/listar/nombre_franquicia

5. **para extraer alguna sucursal especifica por el nombre**
Metodo get: http://localhost:8080/api/sucursal/listar/nombre_sucursal

6. **para extraer productos especifico por el nombre**
Metodo get: http://localhost:8080/api/producto/listar/nombre_producto

7. **para eliminar un producto por id**
Metodo Delete: http://localhost:8080/api/producto/eliminar/numero_id

8. **para Actualizar el stock de un producto**
Metodo Post: http://localhost:8080/api/producto/actualizar/stock
BODY: 
{
    "nombre" : "confite",
    "stock" : 10
}


9. **para extraer el producto con mayor stock en una franquicia**
Metodo get: http://localhost:8080/api/producto/stock/sucursal/numero_id_franquicia



### Instrucciones de Ejecución

1. **Clona el repositorio**:

   git clone https://github.com/edjms/Franquicias.git
   
2. **abre el archivo clonado**

3. **compila el projecto**
    mvn clean install


