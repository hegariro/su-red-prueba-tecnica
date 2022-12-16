package com.testproject.demo.bean;

public class GeneralPropertiesImplement implements GeneralProperties {
    private String uri;

    public GeneralPropertiesImplement(String uri) {
        this.uri = uri;
    }

    @Override
    public String getApiUri() {
        return uri;
    }
}
