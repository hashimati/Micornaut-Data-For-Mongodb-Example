package io.hashimati.controllers;

import io.hashimati.domains.ArabicName;
import io.hashimati.utils.Randomizer;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ArabicNameControllerTest {

    @Inject
    @Client("/api/arabicName")
    HttpClient client;

    ArabicName arabicName;



    @Test
    void save() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        ArabicName arabicName = new Randomizer<ArabicName>(ArabicName.class).getRandomInstance();
        HttpRequest<ArabicName> request = HttpRequest.POST("/save", arabicName);
        this.arabicName = client.toBlocking().retrieve(request, ArabicName.class);
        assertNotNull(arabicName);
    }

    @Test
    void findById() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        save();
        HttpRequest<ArabicName> request = HttpRequest.GET("/get?id="+this.arabicName.getId());
        ArabicName arabicName = client.toBlocking().retrieve(request, ArabicName.class);
        assertNotNull(arabicName);
        assertEquals(arabicName.getId() , this.arabicName.getId());
    }

    @Test
    void deleteById() throws InstantiationException, IllegalAccessException, NoSuchFieldException{
        save();
        HttpRequest<Boolean> request = HttpRequest.DELETE("/delete/"+this.arabicName.getId());
        Boolean body= client.toBlocking().retrieve(request, Boolean.class);
        assertTrue(body.booleanValue());
    }

    @Test
    void findAll() throws InstantiationException, IllegalAccessException, NoSuchFieldException{

        save();
        HttpRequest<Iterable<ArabicName>> request = HttpRequest.GET("/findAll");
        Iterable<ArabicName> list = client.toBlocking().retrieve(request, Iterable.class);
        System.out.println(list);
        assertNotNull(list);

    }

    @Test
    void update() throws InstantiationException, IllegalAccessException, NoSuchFieldException{
        save();
        HttpRequest<ArabicName> request = HttpRequest.PUT("/update", this.arabicName);
        ArabicName arabicName = client.toBlocking().retrieve(request, ArabicName.class);
        assertNotNull(arabicName);
    }

    

}

