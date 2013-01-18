package com.zenika.thymeleaf;

import com.zenika.Contact;
import org.junit.Assert;
import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 *
 */
public class StandaloneTest {

    @Test public void standalone() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode("XHTML");
        resolver.setSuffix(".html");
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        StringWriter writer = new StringWriter();

        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("John","Doe"));
        contacts.add(new Contact("Jane","Doe"));

        Context context = new Context();
        context.setVariable("contact",new Contact("John","Doe"));
        context.setVariable("contacts",contacts);
        String now = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        context.setVariable("date", now);
        engine.process("home", context, writer);
        Assert.assertTrue(writer.toString().contains("Hello World"));
        Assert.assertTrue(writer.toString().contains(now));
        Assert.assertTrue(writer.toString().contains("John"));
        Assert.assertTrue(writer.toString().contains("Doe"));
        Assert.assertTrue(writer.toString().contains("Jane"));
    }

}
