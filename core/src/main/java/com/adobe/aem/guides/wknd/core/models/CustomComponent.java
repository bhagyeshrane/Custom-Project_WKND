package com.adobe.aem.guides.wknd.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import com.day.cq.wcm.api.Page;

@Model(adaptables = { Resource.class,
        SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomComponent.class);

    private String pageTitle;

    @ValueMapValue
    private String pagePath;

    @SlingObject
    private ResourceResolver resourceResolver;

    @PostConstruct
    protected void init() {
        try {
            if (pagePath != null) {
                Page page = resourceResolver.getResource(pagePath).adaptTo(Page.class);
                pageTitle = page != null ? page.getTitle() : null;
            }
        } catch (IllegalStateException e) {
            LOGGER.error("Exception in CustomComponent ", e);
        }
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getPagePath() {
        return pagePath;
    }
}
