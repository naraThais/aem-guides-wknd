package com.adobe.aem.guides.wknd.core.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.scripting.sightly.engine.ResourceResolution;

import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;

public class ArticleBuilder {

    private SlingHttpServletRequest request;
    private ResourceResolution resourceResolver;
    private QueryBuilder queryBuilder;

    public ArticleBuilder(SlingHttpServletRequest request, ResourceResolution resourceResolver) {
        this.request = request;
        this.resourceResolver = resourceResolver;
        this.queryBuilder = request.getResourceResolver().adaptTo(QueryBuilder.class);
    }

    private Map<String, String> initializeMap(String cfModel, String fragmentName) {

        final Map<String, String> parametersMap = new HashMap<String, String>();

        parametersMap.put("type", "dam:Asset");
        parametersMap.put("path", "/content/dam");
        parametersMap.put("boolproperty", "jcr:content/contentFragment");
        parametersMap.put("boolproperty.value", "true");
        parametersMap.put("1_property", "jcr:content/data/cq:model");
        parametersMap.put("1_property.value", "/conf/wknd/settings/dam/cfm/models/artigo");
        parametersMap.put("2_property", cfModel);
        parametersMap.put("2_property.value", fragmentName);

        return parametersMap;
    }

    private SearchResult executeQuery()
}
