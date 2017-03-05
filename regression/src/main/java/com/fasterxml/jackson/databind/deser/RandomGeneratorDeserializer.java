package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import nz.co.automation.regression.io.random.RandomValueGenerator;
import nz.co.automation.regression.io.random.RandomValueGeneratorFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class RandomGeneratorDeserializer extends BeanDeserializer implements ResolvableDeserializer {

    private final RandomValueGenerator randomValueGenerator = new RandomValueGeneratorFactory().create();

    public RandomGeneratorDeserializer(BeanDeserializer deserializer) {
        super(deserializer);
    }

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        final ObjectNode objectNode = jsonParser.readValueAsTree();
        final Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();
        while (fields.hasNext()) {
            final Map.Entry<String, JsonNode> field = fields.next();
            if (field.getValue().isTextual()) {
                objectNode.set(field.getKey(), TextNode.valueOf(randomValueGenerator.generateRandomValueIfRequired(field.getValue().textValue())));
            }
        }
        JsonParser postInterceptionParser = new TreeTraversingParser(objectNode, jsonParser.getCodec());
        postInterceptionParser.nextToken();

        // because BeanDeserializer constructor only copy all properties from "this"
        // therefore it will not cause stack overflow..phew!...
        return new BeanDeserializer(this).deserialize(postInterceptionParser, deserializationContext);
    }

}
