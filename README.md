# Kafka implementation with springboot

### Kafka overview
as you can see we have to client that send the request to the fly reservation system but as system checks they fly is full so they must want until someone cancel the fly so the clients must subscribe to the Kafka in order to receive the notification about the empty seat on the fly
Kafka has the fast data transfer, scalable, reliable and Kafka can send the message in real time and has a bit data lost because it saved the messages in the disk
![Farmers Market Finder Demo](photo/subscrible.PNG)
### Start Zookeeper
``bin/zookeeper-server-start.sh config/zookeeper.properties``
### Start Kafka Server
``bin/kafka-server-start.sh config/server.properties``
### Create Kafka Topic
``bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example``
### Consume from the Kafka Topic via Console
``bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Kafka_Example --from-beginning``
## Publish message via WebService
``http://localhost:8081/kafka/publish/Sam``
``http://localhost:8081/kafka/publish/Peter``

