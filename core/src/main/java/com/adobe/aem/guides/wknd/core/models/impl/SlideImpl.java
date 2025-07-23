package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.guides.wknd.core.models.Slide;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = {
        Slide.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = {
                SlideImpl.RESOURCE_TYPE })
public class SlideImpl implements Slide {

    protected static final String RESOURCE_TYPE = "markeup/models/components/slide";

    @ValueMapValue
    private String alignment;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String buttonName;

    @ValueMapValue
    private String internalLink;

    @ValueMapValue
    private String externalLink;

    @Override
    public String getAlignment() {
        return alignment;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getButtonName() {
        return buttonName;
    }

    @Override
    public String getInternalLink() {
        if (internalLink != null && !internalLink.isEmpty()) {
            return externalLink.concat(".html");
        }
        return null;
    }

    @Override
    public String getExternalLink() {
        if (externalLink.startsWith("http://")) {
            return internalLink;
        } else {
            return externalLink = "http://".concat(externalLink);
        }
    }
}