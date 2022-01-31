package io.hashimati.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micrometer.core.annotation.Timed;


import jakarta.inject.Inject;

import io.hashimati.domains.ArabicName;
import io.hashimati.services.ArabicNameService;


@Controller("/api/arabicName")
public class ArabicNameController {

    private static final Logger log = LoggerFactory.getLogger(ArabicNameController.class);

    @Inject private ArabicNameService arabicNameService;


    
    @Timed(value = "io.hashimati.controllers.arabicNameController.save", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for saving arabicName object")
    @Post("/save")
    @Version("1")
    @Operation(summary = "Creating a arabicName and Storing in the database",
            description = "A REST service, which saves ArabicName objects to the database.",
            operationId = "SaveArabicName"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Object Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not stored")
    public ArabicName save( @Body ArabicName arabicName){
        log.info("Saving  ArabicName : {}", arabicName);
        //TODO insert your logic here!

        //saving Object
        return arabicNameService.save(arabicName);
    }


    
    @Timed(value = "io.hashimati.controllers.arabicNameController.findById", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by id")
    @Get("/get")
    @Version("1")
    @Operation(summary = "Getting a arabicName by Id",
        description = "A REST service, which retrieves a ArabicName object by Id.",
        operationId = "FindByIdArabicName"
    )
    @ApiResponse(
        content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public ArabicName findById( @Parameter("id") String id){
        return arabicNameService.findById(id);
    }

    
    @Timed(value = "io.hashimati.controllers.arabicNameController.deleteById", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for deleting a arabicName object by id")
    @Delete("/delete/{id}")
    @Version("1")
    @Operation(summary = "Deleting a arabicName by ID",
            description = "A REST service, which deletes ArabicName object from the database.",
            operationId = "DeleteByIdArabicName"
    )
    @ApiResponse(
            content = @Content(mediaType = "boolean")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public boolean deleteById( @PathVariable("id") String id){
        log.info("Deleting ArabicName by Id: {}", id);
        return  arabicNameService.deleteById(id);
    }

    
    @Timed(value = "io.hashimati.controllers.arabicNameController.findAll", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding all arabicName objects")
    @Get("/findAll")
    @Version("1")
    @Operation(summary = "Retrieving all arabicName objects as Json",
            description = "A REST service, which returns all ArabicName objects from the database.",
            operationId = "FindAllArabicName"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    public Iterable<ArabicName> findAll(){
        log.info("find All");
        return arabicNameService.findAll();
    }

    
    @Timed(value = "io.hashimati.controllers.arabicNameController.update", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for update a arabicName object")
    @Put("/update")
    @Version("1")
    @Operation(summary = "Updating a arabicName.",
            description = "A REST service, which update a ArabicName objects to the database.",
            operationId = "UpdateArabicName"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public ArabicName update( @Body ArabicName arabicName)
    {
        log.info("update {}", arabicName);
        return arabicNameService.update(arabicName);

    }

    @Get("/findByName")
    
    @Timed(value = "io.hashimati.controllers.arabicNameController.findByName", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by Name")
    @Operation(summary = "Find an entity by Name",
    description = "A REST service, which retrieves a ArabicName object by Name."
    )
    @ApiResponse(
    content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public ArabicName findByName(String query){
          log.info("Finding ArabicName By Name: {}", query);
          return arabicNameService.findByName(query);
    }


    
    @Timed(value = "io.hashimati.controllers.arabicNameController.findAllByLetter", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by Letter")
    @Get("/findAllByLetter")
    @Operation(summary = "Getting all entity by Letter",
       description = "A REST service, which retrieves a ArabicName objects by Letter."
    )
    @ApiResponse(
       content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public Iterable<ArabicName> findAllByLetter(String query){
          log.info("Finding all ArabicName By Letter: {}", query);
          return arabicNameService.findAllByLetter(query);
    }


    @Get("/findByNativeArabic")
    
    @Timed(value = "io.hashimati.controllers.arabicNameController.findByNativeArabic", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by NativeArabic")
    @Operation(summary = "Find an entity by NativeArabic",
    description = "A REST service, which retrieves a ArabicName object by NativeArabic."
    )
    @ApiResponse(
    content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public ArabicName findByNativeArabic(String query){
          log.info("Finding ArabicName By NativeArabic: {}", query);
          return arabicNameService.findByNativeArabic(query);
    }


    @Get("/findByMeaning")
    
    @Timed(value = "io.hashimati.controllers.arabicNameController.findByMeaning", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by Meaning")
    @Operation(summary = "Find an entity by Meaning",
    description = "A REST service, which retrieves a ArabicName object by Meaning."
    )
    @ApiResponse(
    content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public ArabicName findByMeaning(String query){
          log.info("Finding ArabicName By Meaning: {}", query);
          return arabicNameService.findByMeaning(query);
    }





    
    @Timed(value = "io.hashimati.controllers.arabicNameController.updateby.Name", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for update a arabicName object")
    @Put("/updateByName")
    @Version("1")
    @Operation(summary = "Updating a arabicName.",
            description = "A REST service, which updates a ArabicName objects to the database by Name, This service will only update these attributes {name, nativeArabic, meaning}.",
            operationId = "UpdateArabicNamebyName"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public Long updateName( @QueryValue("query") String query,  @Body ArabicName body)
    {
        log.info("update {}", query);
        return arabicNameService.updateByName(query, body.getName(), body.getNativeArabic(), body.getMeaning());

    }

}


