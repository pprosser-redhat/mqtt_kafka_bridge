package org.mqttkafka.bridge;

import org.apache.camel.builder.RouteBuilder;

public class MQTTKafkaBridge extends RouteBuilder  {

    @Override
    public void configure() throws Exception {
        
        from("paho-mqtt5:{{mqtt_topic}}?brokerUrl=tcp://{{mqtt_broker_url}}&clientId=camelreader")
            .routeId("MQTT to Kafka")
            .to("log:mqtt?showBody=true")
            .to("kafka:{{kafka_topic}}?brokers={{kafka_broker_url}}&clientId=camelwriter");
        
    }
    
}
