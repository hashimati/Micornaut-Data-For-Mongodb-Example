package io.hashimati.domains;


import io.micronaut.data.annotation.*;
import lombok.*;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.*;
import static io.micronaut.data.model.naming.NamingStrategies.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@MappedEntity(value = "arabicnames", namingStrategy = Raw.class)
@Schema(name="ArabicName", description="ArabicName Description")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ArabicName{
    @Id 
    @GeneratedValue(GeneratedValue.Type.AUTO) 
    private String id;

    private String name;
	private String letter;
	private String nativeArabic;
	private String meaning;
    @DateCreated 
    private Date dateCreated;

    @DateUpdated 
    private Date dateUpdated;

}

