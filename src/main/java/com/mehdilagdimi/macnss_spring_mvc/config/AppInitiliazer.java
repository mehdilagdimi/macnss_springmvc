package com.mehdilagdimi.macnss_spring_mvc.config;

import com.mehdilagdimi.macnss_spring_mvc.config.AppConfig;
import com.mehdilagdimi.macnss_spring_mvc.config.DispatcherConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//
////public class AppInitiliazer extends AbstractAnnotationConfigDispatcherServletInitializer {
public class AppInitiliazer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        System.out.println(" inside init /// ");
            // Create the 'root' Spring application context
            AnnotationConfigWebApplicationContext rootContext =
                    new AnnotationConfigWebApplicationContext();
            rootContext.register(AppConfig.class);

            // Manage the lifecycle of the root application context
//            container.addListener(new ContextLoaderListener(rootContext));

            // Create the dispatcher servlet's Spring application context
            AnnotationConfigWebApplicationContext dispatcherContext =
                    new AnnotationConfigWebApplicationContext();
            dispatcherContext.register(DispatcherConfig.class);

            container.addListener(new ContextLoaderListener(dispatcherContext));

            DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
            // Register and map the dispatcher servlet
            ServletRegistration.Dynamic dispatcher =
                    container.addServlet("dispatcher", dispatcherServlet);
            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("/");
    }
////
////        @Override
////        protected Class <?> [] getRootConfigClasses() {
////            System.out.println( "inside init ///1 ");
////            return new Class[] {
////                    AppConfig.class
////            };
////            //return null;
////        }
////
////        @Override
////        protected Class <?> [] getServletConfigClasses() {
////            System.out.println( "inside init ///2 ");
////            return new Class[] {
////                    DispatcherConfig.class
////            };
////        }
////
////        @Override
////        protected String[] getServletMappings() {
////            System.out.println( "inside init ///3 ");
////            return new String[] {
////                    "/"
////            };
////        }
}
