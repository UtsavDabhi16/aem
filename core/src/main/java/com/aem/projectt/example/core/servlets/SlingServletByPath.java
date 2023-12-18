package com.aem.projectt.example.core.servlets;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Enumeration;

@Component(service = { Servlet.class },
        property = {
        "sling.servlet.paths=/bin/custom/saveFormData" ,
        "sling.servlet.methods={GET,POST}",
        "sling.servlet.selectors={one,two}",
        "sling.servlet.extensions=txt"
        })
public class SlingServletByPath extends SlingAllMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(SlingServletByPath.class);

    //http://localhost:4502/bin/practice.coco.bhai.txt
    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource = req.getResource();
        resp.setContentType("text/plain");
        String[] selectors = req.getRequestPathInfo().getSelectors();
        if(selectors.length > 0){
            resp.getWriter().write("Selector Length = " + selectors.length + "Selector Value = " + selectors[0]);
        }else {
            resp.getWriter().write("Hello World");
        }
    }

    @Override
    protected void doPost(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LOG.info("Value of Name: {}", name);
        LOG.info("Value of Email: {}", email);
        response.getWriter().write("Hello World" + " " + name +" "+ email);

//        Enumeration<String> parameterNames = request.getParameterNames();
//
//        // Process and print parameters
//        response.getWriter().write("<html><body>");
//        response.getWriter().write("<h2>Form Submission Results:</h2>");
//        while (parameterNames.hasMoreElements()) {
//            String paramName = parameterNames.nextElement();
//            String paramValue = request.getParameter(paramName);
//            response.getWriter().write("<p>" + paramName + ": " + paramValue + "</p>");
//        }
//        response.getWriter().write("</body></html>");
    }

}

