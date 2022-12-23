package org.mqttkafka.bridge;

import org.apache.camel.builder.RouteBuilder;

public class MQTTKafkaBridge extends RouteBuilder  {

    @Override
    public void configure() throws Exception {
        
        from("paho-mqtt5:{{mqtt_topic}}?brokerUrl=tcp://{{mqtt_broker_url}}&clientId=camelreader")
            .routeId("MQTT to Kafka")
            .to("log:mqtt?showBody=true")
            .log("hello + {{kafka_broker_url}}")
            .to("kafka:{{kafka_topic}}?clientId=camelwriter");
        
    }
    
}
