# PlayStore

1) Download HTTP link: https://www.apache.org/dyn/closer.cgi?path=/kafka/3.4.0/kafka_2.13-3.4.0.tgz

2) Extract file

3) Open CMD in the directory of extraction and write:
  a) (for windows): .\bin\windows\zookeeper-server-start.bat config\zookeeper.properties
  b) (for mac and linux): bin/zookeeper-server-start.sh config/zookeeper.properties

4) Open another CMD in the directory of extraction and write:
  a) (for windows): .\bin\windows\kafka-server-start.sh config/server.properties
  b) (for mac and linux): bin/kafka-server-start.sh config/server.properties
  
5) Run the Service that contains Kafka
