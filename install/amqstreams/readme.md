Running AMQ Streams Kafka in podman

This will run Kafka without zookeeper (NOT working at the mo.... Camel cannot connect, need to investigate)

podman run -d --name amqstreams -p 9092:9092 -e LOG_DIR=/tmp/logs  registry.redhat.io/amq7/amq-streams-kafka-32-rhel8:2.2.0-13 /bin/sh -c 'export CLUSTER_ID=$(bin/kafka-storage.sh random-uuid) && bin/kafka-storage.sh format -t $CLUSTER_ID -c config/kraft/server.properties && bin/kafka-server-start.sh config/kraft/server.properties'


If you want to see the messaged arriving on the kafka topic then run the following :-

podman exec -it amqstreams bin/kafka-console-consumer.sh --bootstrap-server 192.168.59.3:9092 --topic bintopickafka


Running in podman with the above command does recover from stopping the container. Need to remove and execute podman rnu again. I suspect it's using storage in the container than is causing the problem 