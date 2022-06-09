# Práctica de CRUD
+ Spring Boot
+ JPA
+ MySQL
+ Unit testing

# Instrucciones del programa
1. Clone el repositorio 
+ git clone https://github.com/tattortega/demoCrudTEST
2. Ejecute la clase principal
+ Run 'DemocrudApplication'
3. Siga a continuación las rutas de acceso.

# Rutas de acceso

### Index
+ localhost:8080/

### GET
+ /usuario 
+ /usuario/{id} 
+ /usuario/query?priority=? 
+ /usuario/rol 
+ /usuario/rol/{id} 
+ /usuario/rol/query?rol=?

### POST
+ /usuario 
+ /usuario/rol

### DELETE
+ /usuario/{id} 
+ /usuario/rol/{id}

### PUT
+ /usuario/{id} 
+ /usuario/rol/{id}

## Relación entre tablas
Para las tablas Usuario y Rol, elegí la relación @OneToMany ya que asi se solicitaba en el ejercicio.

## Evidencia del CRUD en Postman
    @Get Usuario
![](./src/main/resources/images/get-usuario.png)

    @Get id Usuario
![](./src/main/resources/images/get-id-usuario.png)

    @Get query Usuario
![](./src/main/resources/images/get-prioridad-usuario.png)

    @Post Usuario
![](./src/main/resources/images/post-usuario.png)
    
    @Put Usuario
![](./src/main/resources/images/put-usuario.png)

    @Delete Usuario
![](./src/main/resources/images/delete-usuario.png)

    @Get Rol
![](./src/main/resources/images/get-rol.png)

    @Get id Rol
![](./src/main/resources/images/get-id-rol.png)

    @Get query Rol
![](./src/main/resources/images/get-nombre-rol.png)

    @Post UsuarioRol
![](./src/main/resources/images/post-rol.png)

    @Put Rol
![](./src/main/resources/images/put-rol.png)

    @Delete Rol
![](./src/main/resources/images/delete-rol.png)

## Desarrollador
+ Ricardo Ortega - tattortega.28@gmail.com
