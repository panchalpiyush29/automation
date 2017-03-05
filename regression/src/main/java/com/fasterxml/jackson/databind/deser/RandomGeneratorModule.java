package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class RandomGeneratorModule extends SimpleModule {

    public RandomGeneratorModule() {
        super("RandomGeneratorModule");

        // set custom intercepting deserializer
        setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
                if (deserializer instanceof BeanDeserializer) {
                    return new RandomGeneratorDeserializer((BeanDeserializer) deserializer);
                }
                return deserializer;
            }
        });
    }
}
