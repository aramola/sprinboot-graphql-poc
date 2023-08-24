package com.poc.graphql.controller;

import com.poc.graphql.resolver.BookResolver;
import com.poc.graphql.resolver.DataResolver;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLException;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

    @RestController
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public class GraphqlController {

        private final GraphQL graphQL;

        @Autowired
        public GraphqlController(BookResolver bookResolver) {
            GraphQLSchema schema = new GraphQLSchemaGenerator()
                    .withBasePackages("com.poc.graphql")
                    .withOperationsFromSingleton(bookResolver)
                    .generate();
            this.graphQL = new GraphQL.Builder(schema)
                    .build();
        }
        @PostMapping(value = "/graphql")
        public Map<String, Object> execute(@RequestBody Map<String, String> request, HttpServletRequest raw)
                throws GraphQLException {
            ExecutionResult result = graphQL.execute(request.get("query"));
            return result.getData();
        }
    }

