package com.adobe.aem.guides.wknd.core.models;

/* Representa o content fragment do documento para o projeto wknd  */
public class Document {

    private String name;
    private String file;

    public void setName(String name) {
        this.name = name;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public String getFile() {
        return file;
    }

}
