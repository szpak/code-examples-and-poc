package info.solidsoft.rnd.gradle.tomcat;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Marcin Zajączkowski, 2013-12-16
 */
public class GradleTomcatLog4j2WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.setServletContext(servletContext);
        ServletRegistration.Dynamic appServlet = servletContext.addServlet(
                "poc", new DispatcherServlet(springContext));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
