package com.challenge.italiaonline.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "Articoli")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Articolo {

    @Id
    @Indexed(unique=true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String title;
    private String url;
    @JsonAlias("published_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date nyDate;
    @JsonAlias("publishedAt")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone="GMT")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date bbcDate;
    @JsonAlias("time")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date hackerDate;
    private String publishDate;
    private String type;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String source;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getNyDate() {
        return nyDate;
    }

    public void setNyDate(Date nyDate) {
        this.nyDate = nyDate;
        if(nyDate != null) {
            this.publishDate = nyDate.toString();
        }
    }

    public Date getBbcDate() {
        return bbcDate;
    }

    public void setBbcDate(Date bbcDate) {
        this.bbcDate = bbcDate;
        if(bbcDate != null) {
            this.publishDate = bbcDate.toString();
        }
    }

    public Date getHackerDate() {
        return hackerDate;
    }

    public void setHackerDate(Date hackerDate) {
        this.hackerDate = hackerDate;
        if(hackerDate != null) {
            this.publishDate = hackerDate.toString();
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
