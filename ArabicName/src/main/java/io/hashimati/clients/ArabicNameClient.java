package io.hashimati.clients;


import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import io.hashimati.domains.ArabicName;


@Client("/api/arabicName")
public interface ArabicNameClient {

    @Post("/save")
    public ArabicName save(ArabicName arabicName);

    @Get("/get")
    public ArabicName findById(@Parameter("id") String id);

    @Delete("/delete/{id}")
    public boolean deleteById(@PathVariable("id") String id);

    @Get("/findAll")
    public Iterable<ArabicName> findAll();

    @Put("/update")
    public ArabicName update(@Body ArabicName arabicName);


    @Get("/findAllByName")
    public ArabicName findByName(String query);

    @Get("/findAllByLetter")
    public Iterable<ArabicName> findAllByLetter(String query);

    @Get("/findAllByNativeArabic")
    public ArabicName findByNativeArabic(String query);

    @Get("/findAllByMeaning")
    public ArabicName findByMeaning(String query);


    @Put("/updateByName")
    public Long updateName(@QueryValue("query") String query,  @Body ArabicName body);

}


