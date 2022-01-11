package com.sadatmalik.fusionnews.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Media {

    @JsonProperty("type")
    private String type;
    private String subtype;
    @JsonProperty("caption")
    private String caption;
    private String url;
    @JsonProperty("media-metadata")
    private List<Thumbnail> mediaMetadata;
}