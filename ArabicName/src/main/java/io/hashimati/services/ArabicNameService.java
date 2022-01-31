package io.hashimati.services;


import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micrometer.core.annotation.Timed;
import javax.transaction.Transactional;
import io.hashimati.domains.ArabicName;
import io.hashimati.repositories.ArabicNameRepository;



@Singleton
public class ArabicNameService {

    private static final Logger log = LoggerFactory.getLogger(ArabicNameService.class);
    @Inject private ArabicNameRepository arabicNameRepository;

    @Timed(value = "io.hashimati.services.arabicNameService.save", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for saving arabicName object")
    public ArabicName save(ArabicName arabicName){
        log.info("Saving  ArabicName : {}", arabicName);
        //TODO insert your logic here!
        //saving Object
        arabicNameRepository.save(arabicName);
        return arabicName;
    }

    
    @Timed(value = "io.hashimati.services.arabicNameService.findById", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by id")
    public ArabicName findById(String id){
        log.info("Finding ArabicName By Id: {}", id);
        return arabicNameRepository.findById(id).orElse(null);
    }

    @Timed(value = "io.hashimati.services.arabicNameService.deleteById", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for deleting a arabicName object by id")
    public boolean deleteById(String id){
        log.info("Deleting ArabicName by Id: {}", id);
        try{
            arabicNameRepository.deleteById(id);
            log.info("Deleted ArabicName by Id: {}", id);
            return true;
        }
        catch(Exception ex)
        {
            log.info("Failed to delete ArabicName by Id: {}", id);
            ex.printStackTrace();
            return false;
        }
    }

    @Timed(value = "io.hashimati.services.arabicNameService.findAll", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding all arabicName objects")
    public Iterable<ArabicName> findAll() {
        log.info("Find All");
      return  arabicNameRepository.findAll();
    }

    public boolean existsById(String id)
    {
        log.info("Check if id exists: {}", id);
        return  arabicNameRepository.existsById(id);

    }

    @Timed(value = "io.hashimati.services.arabicNameService.update", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for update a arabicName object")
    public ArabicName update(ArabicName arabicName)
    {
        log.info("update {}", arabicName);
        return arabicNameRepository.update(arabicName);

    }
    
    @Timed(value = "io.hashimati.services.arabicNameService.findByName", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by id")
    public ArabicName findByName(String query){
          log.info("Finding ArabicName By Name: {}", query);
          return arabicNameRepository.findByName(query).orElse(null);
    }


    
    @Timed(value = "io.hashimati.services.arabicNameService.findAllByLetter", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by Letter")
    public Iterable<ArabicName> findAllByLetter(String query){
          log.info("Finding ArabicName By Letter: {}", query);
          return arabicNameRepository.findAllByLetter(query);
    }

    
    @Timed(value = "io.hashimati.services.arabicNameService.findByNativeArabic", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by id")
    public ArabicName findByNativeArabic(String query){
          log.info("Finding ArabicName By NativeArabic: {}", query);
          return arabicNameRepository.findByNativeArabic(query).orElse(null);
    }


    
    @Timed(value = "io.hashimati.services.arabicNameService.findByMeaning", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by id")
    public ArabicName findByMeaning(String query){
          log.info("Finding ArabicName By Meaning: {}", query);
          return arabicNameRepository.findByMeaning(query).orElse(null);
    }




    @Timed(value = "io.hashimati.services.arabicNameService.updateby.Name", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for update a arabicName object")
    public Long updateByName(String query,  String name, String nativeArabic, String meaning)
    {
        log.info("update by {}", query);
        return arabicNameRepository.updateByName(query, name, nativeArabic, meaning);
    }

}

