To install the mqtt kafka bridge, run :-

podman run -d --name mqttkafkabridge -e kafka_broker_url=192.168.59.3:9092 -e mqtt_broker_url=192.168.59.3:1883 quay.io/philprosser/mqtt_kafka_bridge:v1

Please replace the IP address for your kafka and mqtt brokers as per your environment in the environment variables above. Typically the host ip where the containers are running