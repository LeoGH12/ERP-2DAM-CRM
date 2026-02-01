Este proyecto java contiene la creación de la API de la entidad oportunidad, tabla que se encuentra en el CRM que debemos desarrollar mis compañeros Leonardo, Jose y yo. 
Este proyecto utiliza las dependencias de java Spring Boot, Lombok y JPA, además de hacer conexión a una base de datos creada en MariaDB.
Para la creación de esta API he tenido que seguir unos pasos muy concretos:
1. Creación del proyecto java con las siguientes dependencias: Lombok, Spring Web, Spring Data JPA, Spring Boot DevTools y MariaDB Driver.
2. Creación de las carpetas que mantendran todos los .java ordenados por funcionamiento: model, dto, repository, service y controller.
3. En primer lugar cree el archivo model que es la representación de la entidad de base de datos que vamos a mapear.
4. En segundo lugar creamos el dto que es el archivo en el que crearemos el objeto java que correspondera con la entidad, y mapeara los datos de esta para poder usar este objeto en nuestro código.
5. En tercer lugar creo el repository que sera el encargado de la comunicación con la base de datos, el traduce las instrucciones java a sql.
6. En cuarto lugar el service, que es el núcleo de nuestra aplicación ya que aqui se encuentra la lógica empresarial.
7. Por ultimo lugar tenemos el archivo controller que es el que se encarga de actuar como un adaptador entre el protocolo HTTP y el codigo java.

Mediante este proceso he creado un microservicio que actua como un intermediario entre los usuarios que utilizan la app y mi base de datos.
