# Test SysOne
Se adjunta el script para la base sysonetest. El mismo se encuentra en /SCRIPT_DB

Con respecto a la base se crea una tabla variante y una tabla opcion. Con respecto a la tabla auto tiene un campo especial que es codigoAuto que sirve para operaciones con el api y una forma dentro del negocio para identificar distintos modelos.

### Operaciones del API


http://localhost:8080/auto/all  Trae toda la tabla Auto joineando con Variante y Opcion



http://localhost:8080/auto/1   Trae los datos del auto con codigo 1 o el que reciba como parametro

Ejemplo Salida :

{"id":1,"nombre":"Básico Sedán","opcionales":["TC","AA","LL"],"precio":274000}


http://localhost:8080/auto/borrarAuto?codigoAuto=5000 Para eliminar se debe especificar el codigo del auto. Caso que no exista dara error y mostrara un mensaje en el response.



http://localhost:8080/auto/guardarAuto/  Se usa para guardar un auto. Hay que ingresar el id de variante y en un array los id de opcion. El codigo de auto se genera autómaticamente.

El campo id sería el codigo de auto en todos los responses de guardar y consulta

### Otros documentos en la entrega
##
Se adjunta en la carpeta Documento unas capturas de pantalla para probar con postman.


Con respecto a pruebas para generar un ejecutable, se puede hacer una mvn install y luego al .jar generado correrlo por medio de un bat.

