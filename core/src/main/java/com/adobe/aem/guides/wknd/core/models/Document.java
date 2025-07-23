package com.adobe.aem.guides.wknd.core.models;

/* Representa o content fragment do documento para o projeto wknd  */
public class Document {

    private String name;
    private String filePath;

    public void setName(String name) {
        this.name = name;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }

}
