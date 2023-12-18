package com.aem.projectt.example.core.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.util.converter.Converters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;

@Component(service = {StudentInterface.class})
@Designate(ocd = StudentInterfaceImpl.Config.class)
public class StudentInterfaceImpl implements StudentInterface {

    private static final Logger log = LoggerFactory.getLogger(StudentInterfaceImpl.class);


    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @ObjectClassDefinition(
            name = "Osgi Example",
            description = "OSGi Service Demo Example"
    )
    @interface Config {

        @AttributeDefinition(
                name = "First Name",
                description = "First Desc"
        )
        String firstName();

        @AttributeDefinition(
                name = "Last Name",
                description = "Last Desc"
        )
        String lastName();

    }


    private String firstName;

    private String lastName;

    /**
     * @return the name of a random WKND adventure activity
     */

    @Activate
    protected void activate(Config config) {

        this.firstName = config.firstName();

        this.lastName = config.lastName();

        System.out.println("First Name" + firstName + "LastName" + lastName);

        log.info("Activated ActivitiesImpl with activities [ {} ]", String.join(", ", this.firstName));
    }

    @Deactivate
    protected void deactivate() {
        log.info("ActivitiesImpl has been deactivated!");
    }
}
