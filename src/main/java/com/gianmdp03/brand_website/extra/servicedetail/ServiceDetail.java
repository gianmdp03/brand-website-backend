package com.gianmdp03.brand_website.extra.servicedetail;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include =  JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
    //@JsonSubTypes.Type()
})
public interface ServiceDetail {
}
