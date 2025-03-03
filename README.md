# Spring Boot Kafka Example

Proyecto de ejemplo compuesto de dos módulos.

El módulo "springboot-kafta-provider" crea un tópico y produce un mensaje.

El módulo "springboot-kafta-consumer" consume los mensajes enviados a un tópico.


### Notas Kafka
Desde una terminal, situandonos sobre el directorio donde hemos instalado Kafka, por ejemplo, "C:\java\kafka_2.12-3.4.0".

* "topic-name" se sustituye por el nombre de nuestro topic.

* "host" se sustituye por el host donde tengamos corriendo kafka (localhost)

Comando para iniciar Zookeeper

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Comando para iniciar Kafka

.\bin\windows\kafka-server-start.bat .\config\server.properties

Comando para crear un nuevo Topic en el servidor de Kafka

.\bin\windows\kafka-topics.bat --create --topic <topic-name> --bootstrap-server <host>:9092

Comando para describir los detalles de un Topic

.\bin\windows\kafka-topics.bat --describe --topic <topic-name> --bootstrap-server <host>:9092

Comando para listar todos los Topics que existen dentro del Broker

.\bin\windows\kafka-topics.bat --list --bootstrap-server <host>:9092

Comando para iniciar una consola para ver mensajes de un topic específico

.\bin\windows\kafka-console-consumer.bat --topic <topic-name> --bootstrap-server <host>:9092

Comando para iniciar una consola para enviar mensajes a un topic especifico

.\bin\windows\kafka-console-produces.bat --broker-list <host>:9092 --topic <topic-name>


Por defecto, kafka viene configurado para Linux, para configurarlo para Windows:
* Editar el archivo .\config\server.properties

  Buscar la propiedad log.dirs=/tmp/kafka-logs y cambiar su valor a por ejemplo C:\\java\\kafka_2.12-3.4.0\\kafka-logs
* Editar el archivo .\config\zookeeper.properties

  Buscar la propiedad dataDir=/tmp/zookeeper y cambiar su valor a por ejemplo C:\\java\\kafka_2.12-3.4.0\\zookeeper-data


### Notas Kafka Docker Image
Comando para arrancar (iniciar el servicio) Docker Desktop desde la línea de comandos (si no se arranca visualmente)

$ docker start
 
Comando para obtener la imagen de docker de kafka:

$ docker pull apache/kafka:3.9.0

Comando para arrancar el contenedor de docker de Kafka:

$ docker run -p 9092:9092 apache/kafka:3.9.0


Estos comandos de ahora los debes poner en tu notas-docker.txt

los puedes hacer visualmente desde el docker desktop o por comandos desde la línea de comandos una vez que has arrancado la aplicación de docker desktop
* Comando que indica la versión de docker (Docker Desktop debe estar arrancada)
  
  $ docker version
* Comando para arrancar (iniciar el servicio) Docker Desktop desde la línea de comandos
  
  $ docker start
