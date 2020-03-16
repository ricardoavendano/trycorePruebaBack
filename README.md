# trycorePruebaBack
Prueba TRYCORE

Ricardo Avendaño Casas

Para ejecutar el proyecto se deben realizar los siguientes pasos
1. descargar fuente de github: git clone https://github.com/ricardoavendano/trycorePruebaBack.git
2. ir al directorio donde se encuentra el fuente y crear jar: mvn clean install (se crea la carpeta target)
3. ir al directorio donde se encuentra el fuente y dirigirse a la carpeta target; por linea de comandos ejecutar jar: java -jar trycore_prueba-0.0.1-SNAPSHOT.jar
4. La aplicacion ya se encuentra desplegada localmente en la url (http://localhost:8081)
5. endpoint de la aplicacion
	1. POST http://localhost:8081/prueba/login 
			body ejemplo:
			{"idUsuario":"usuario1","password":"dXN1YXJpbzE="}
			el password esta encriptado en base64 pero es el mismo que el idUsuario
	2. GET http://localhost:8081/prueba/cargar/modelo (este carga en la base de datos H2 los planetas y personas, si no de despliega el front se debe invocar para usar los demas endpoint)
	3. GET http://localhost:8081/prueba/cargar/persona se encarga de cargar la lista de personas en el front
	4. GET http://localhost:8081/prueba/cargar/personaRS se encarga de cargar la lista de personas que se les halla dado click en el front
	5. GET http://localhost:8081/prueba/cargar/personaRS/{idPlaneta} se encarga de mostrar el planeta al que pertenece la persona
	6. GET http://localhost:8081/prueba/cargar/planeta se encarga de cargar la lista de planetas en el front
	7. GET http://localhost:8081/prueba/cargar/planetaRS se encarga de cargar la lista de planetas que se les halla dado click en el front
	8. GET http://localhost:8081/prueba/cargar/planetaRS/{idPlaneta} se encarga de mostrar la lista de personas asociadas a un planeta
	9. POST http://localhost:8081/prueba/persona/click 
			body ejemplo:
			{
			  "contador": 0,
			  "idPersona": 0,
			  "idPlaneta": 0,
			  "name": "string"
			}
			guarda registros en la BD a la persona y su planeta asiciado al que se le hace click
			
	9. POST http://localhost:8081/prueba/planeta/click 
			body ejemplo:
			{
			  "contador": 0,
			  "idPlaneta": 0,
			  "name": "string"
			}
			guarda registros en la BD al planeta que se le hace click
6. Ingreso a la BD H2
	url: http://localhost:8081/prueba/h2-console/login.jsp
	JDBC URL: jdbc:h2:mem:prueba
	User name: trycore
	Password: trycore
	
	Tablas: PLANETA, USUARIO, PERSONA, CONTROLADORPERSONA, CONTROLADORPLANETA
7. Pruebas unitarias con JUnit	 
