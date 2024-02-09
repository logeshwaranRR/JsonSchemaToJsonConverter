package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonSchemaConverter {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: JsonSchemaConverter <json_schema_file>");
            System.exit(1);
        }

        String jsonSchemaFile = args[0];
        String jsonSchema = new String(Files.readAllBytes(Paths.get(jsonSchemaFile)));

        String convertedJson = convertJsonSchemaToJson(jsonSchema);
        System.out.println(convertedJson);
    }

    public static String convertJsonSchemaToJson(String jsonSchema) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode schemaNode = mapper.readTree(jsonSchema);

        // Generate JSON instance based on schema
        JsonNode jsonNode = generateJsonFromSchema(schemaNode);

        return mapper.writeValueAsString(jsonNode);
    }

    private static JsonNode generateJsonFromSchema(JsonNode schemaNode) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonNode = mapper.createObjectNode();

        // Handle properties defined in the schema
        JsonNode propertiesNode = schemaNode.path("properties");
        propertiesNode.fields().forEachRemaining(entry -> {
            String propertyName = entry.getKey();
            JsonNode propertySchema = entry.getValue();
            generatePropertyJson(propertyName, propertySchema, jsonNode, schemaNode);
        });

        // Handle required properties
        JsonNode requiredNode = schemaNode.path("required");
        requiredNode.forEach(requiredProperty -> {
            String propertyName = requiredProperty.asText();
            if (!jsonNode.has(propertyName)) {
                jsonNode.put(propertyName, "");
            }
        });

        return jsonNode;
    }

    private static void generatePropertyJson(String propertyName, JsonNode propertySchema, ObjectNode parentJsonNode, JsonNode schemaNode) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode propertyJsonNode = mapper.createObjectNode();

        // Handle properties with type "array"
        if (propertySchema.has("type") && propertySchema.get("type").asText().equals("array")) {
            ArrayNode arrayNode = mapper.createArrayNode();
            parentJsonNode.set(propertyName, arrayNode);

            JsonNode itemsNode = propertySchema.path("items");
            if (itemsNode.isObject() && itemsNode.has("$ref")) {
                // Resolve reference and generate array of objects
                String ref = itemsNode.get("$ref").asText();
                JsonNode refSchema = resolveReference(ref, schemaNode);
                if (refSchema != null) {
                    JsonNode itemJsonNode = generateJsonFromSchema(refSchema);
                    arrayNode.add(itemJsonNode);
                }
            }
        }

        // Handle properties with type "object"
        if (propertySchema.has("type") && propertySchema.get("type").asText().equals("object")) {
            ObjectNode objectNode = mapper.createObjectNode();
            parentJsonNode.set(propertyName, objectNode);

            JsonNode propertiesNode = propertySchema.path("properties");
            propertiesNode.fields().forEachRemaining(entry -> {
                String nestedPropertyName = entry.getKey();
                JsonNode nestedPropertySchema = entry.getValue();
                generatePropertyJson(nestedPropertyName, nestedPropertySchema, objectNode, schemaNode);
            });
        }

        // Handle other types (e.g., string, integer, boolean)
        if (propertySchema.has("type") && !propertySchema.get("type").asText().equals("array") && !propertySchema.get("type").asText().equals("object")) {
            String propertyType = propertySchema.get("type").asText();
            switch (propertyType) {
                case "string":
                    parentJsonNode.put(propertyName, "");
                    break;
                case "integer":
                    parentJsonNode.put(propertyName, 0);
                    break;
                case "boolean":
                    parentJsonNode.put(propertyName, false);
                    break;
                // Add support for other types as needed
            }
        }
    }

    private static JsonNode resolveReference(String ref, JsonNode schemaNode) {
        String[] parts = ref.split("/");
        JsonNode currentNode = schemaNode;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (currentNode.has(part)) {
                currentNode = currentNode.get(part);
            } else {
                return null;
            }
        }
        return currentNode;
    }
}
