package com.coffeebrew.stubserver.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.http.HttpMethod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EndpointMock {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;

    HttpMethod method;
    String url;
    String body;
    String status;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    public String getBody() {
        return body;
    }
}
