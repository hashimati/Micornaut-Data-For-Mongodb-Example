package io.hashimati.repositories;

import io.hashimati.domains.ArabicName;
import io.micronaut.data.annotation.*;
import io.micronaut.data.model.*;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import java.util.*;
import org.bson.types.ObjectId;


@MongoRepository
public interface ArabicNameRepository extends CrudRepository<ArabicName, String> {

    public Optional<ArabicName> findByName(String name);

    public Iterable<ArabicName> findAllByLetter(String letter);

    public Optional<ArabicName> findByNativeArabic(String nativeArabic);

    public Optional<ArabicName> findByMeaning(String meaning);


    public Long updateByName(String query, String name, String nativeArabic, String meaning);

}

