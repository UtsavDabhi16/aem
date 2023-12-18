package com.aem.projectt.example.core.models;

import com.aem.projectt.example.core.impl.StudentInterface;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TaskModel {

//    @SlingObject
//    SlingHttpServletRequest slingRequest;

    //    @Inject
//    @Via("resource")
    @ChildResource
    public List<Task> task;

    public List<Task> getTask() {
        return task;
    }


    @OSGiService
    StudentInterface studentInterface;

    public String getFirstName() {
        return studentInterface.firstName();
    }

    public String getLastName() { return studentInterface.lastName(); }

//    @ChildResource
//    @ValueMapValue
//    String myValue;
//
//    public String getMyValue() {
//        return myValue;
//    }

    @ValueMapValue
    String myCheckbox;

    public String getMyCheckbox() {
        return myCheckbox;
    }
}
