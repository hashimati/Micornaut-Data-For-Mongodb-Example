package io.hashimati.graphqls;

import graphql.kickstart.tools.SchemaParser;
import graphql.kickstart.tools.SchemaParserBuilder;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import jakarta.inject.Singleton;

@Factory
public class QueryFactory {



    @Bean
    @Singleton
    public GraphQL graphQL( ArabicNameQueryResolver arabicnameQueryResolver)
    {
        SchemaParserBuilder builder = SchemaParser.newParser()
                .files("queries.graphqls" ,"ArabicName.graphqls")
                .resolvers(arabicnameQueryResolver);


        GraphQLSchema graphQLSchema = builder.build().makeExecutableSchema();
        return GraphQL.newGraphQL(graphQLSchema).build();

    }
}

