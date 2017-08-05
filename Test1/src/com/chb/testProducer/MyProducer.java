package com.chb.testProducer;
import java.util.Properties;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class MyProducer {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        //zk
       // props.put("zk.connect", "localhost:2181");
        //kafka broker
        props.put("metadata.broker.list","localhost:9092");

        //serialize
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);

        // read socket
        for (int i = 1; i <= 1000; i++) {
            //Thread.sleep(50);
            producer.send(new KeyedMessage<String, String>("test",
                    "message: " + i ));
        }

    }
}