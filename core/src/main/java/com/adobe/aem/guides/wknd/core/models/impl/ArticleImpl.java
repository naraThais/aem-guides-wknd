package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Article;
import com.adobe.aem.guides.wknd.core.models.Document;
import com.adobe.aem.guides.wknd.core.utils.ArticleBuilder;

import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = { SlingHttpServletRequest.class, Resource.class }, adapters = {
        Article.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = {
                ArticleImpl.RESOURCE_TYPE })

public class ArticleImpl implements Article {

    protected static final String RESOURCE_TYPE = "markeup/models/components/article";

    private String titile;
    private String recipe;
    private String description;
    private GregorianCalendar date;
    private String text;
    private String thumbnail;
    private List<Document> documents;

    @Self
    private SlingHttpServletRequest request;
    @SlingObject
    private ResourceResolver resourceResolver;
    @RequestAttribute
    private String fragmentName;

    @PostConstruct
    protected void init() {
        ArticleBuilder articleBuilder = new ArticleBuilder(request, resourceResolver);
        articleBuilder.buildArticle(this, "/conf/wknd/settings/dam/cfm/models/artigo", fragmentName);
    }

    @Override
    public void setTitle(String title) {
        this.titile = title;
    }

    @Override
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    @Override
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    @Override
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String getTitle() {
        return titile;
    }

    @Override
    public String getRecipe() {
        return recipe;
    }

    @Override
    public GregorianCalendar getDate() {
        return date;
    }

    @Override
    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<Document> getDocuments() {
        return documents;
    }

}