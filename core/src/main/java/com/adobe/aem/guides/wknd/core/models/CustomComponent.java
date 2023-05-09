package com.adobe.aem.guides.wknd.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = { Resource.class,
        SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomComponent {

    private String pageTitle;

    @ValueMapValue
    private String pagePath;

    @SlingObject
    private PageManager pagemanager;

    @PostConstruct
    protected void init() {
        try {
            if (pagePath != null) {
                Page page = pagemanager.getPage(pagePath);
                pageTitle = page != null ? page.getTitle() != null ? page.getPageTitle() : "page title does not exist"
                        : "page does not exist";
            }
        } catch (IllegalStateException e) {
            pageTitle = "exception in sling model";
        }
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getPagePath() {
        return pagePath;
    }
}
