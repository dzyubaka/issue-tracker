package dev.dzyuba.issuetracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/projects");
        registry.addRedirectViewController("/projects/{key}", "/projects/{key}/issues");
        registry.addRedirectViewController("/projects/{key}/", "/projects/{key}/issues");
    }

}
