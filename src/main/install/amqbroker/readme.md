Clone this git repo

cd {your directory}/mqtt_kafka_bridge/src/main/install/amqbroker


To run a single node AMQ Broker, then run :-

podman run -d --name amqbroker -e AMQ_USER=admin -e AMQ_PASSWORD=admin -e AMQ_ROLE=amq -v broker.xml:/opt/amq/conf:Z -p 61616:61616 -p 8161:8161 -p 1883:1883 registry.redhat.io/amq7/amq-broker-rhel8:7.10-42

Feel free to change the user and password to whatever you want, but please leave the role (for now) as amq