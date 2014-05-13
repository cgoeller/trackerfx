package net.goeller.trackerfx.persistence;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import java.time.LocalDateTime;

/**
 * Created by Christian on 13.05.2014.
 */
public class DateConverter implements SingleValueConverter {

    @Override
    public String toString(Object o) {
        LocalDateTime d = (LocalDateTime) o;
        return d.toString();
    }

    @Override
    public Object fromString(String s) {
        return LocalDateTime.parse(s);
    }

    @Override
    public boolean canConvert(Class aClass) {
        return LocalDateTime.class.equals(aClass);
    }
}
