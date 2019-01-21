package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

@Configuration
public class FilterRegistration
{
    @Bean
    public FilterRegistrationBean sitemeshFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(siteMeshFilter());
        registration.addUrlPatterns("/*");
        registration.setName("sitemesh");
        registration.setOrder(1);
        return registration;
    }
    @Bean
    public FilterRegistrationBean strutsFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(strutsPrepareAndExecuteFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("actionPackages","com.lq");
        registration.setName("struts2");
        registration.setOrder(2);
        return registration;
    }

    public Filter siteMeshFilter()
    {
        return new SiteMeshFilter();
    }

    public Filter strutsPrepareAndExecuteFilter()
    {
        return new StrutsPrepareAndExecuteFilter();
    }
}
