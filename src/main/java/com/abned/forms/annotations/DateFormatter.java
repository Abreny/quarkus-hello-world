package com.abned.forms.annotations;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.jboss.resteasy.spi.StringParameterUnmarshaller;
import org.jboss.resteasy.spi.util.FindAnnotation;

public class DateFormatter implements StringParameterUnmarshaller<LocalDate> {
    private DateTimeFormatter formatter;

    public void setAnnotations(Annotation[] annotations) {
        DateFormat format = FindAnnotation.findAnnotation(annotations, DateFormat.class);
        formatter = DateTimeFormatter.ofPattern(format.value());
    }

    public LocalDate fromString(String str) {
        try {
            return LocalDate.parse(str, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e);
        }
    }
}