package com.zcoders.restaurante.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class NovoPedidoDeserializer implements Deserializer<NovoPedidoEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public NovoPedidoEvent deserialize(String s, byte[] data) {
        try {
            return objectMapper.readValue(data, NovoPedidoEvent.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
