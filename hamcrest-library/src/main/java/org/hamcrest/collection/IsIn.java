package org.hamcrest.collection;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import java.util.Arrays;
import java.util.Collection;

public class IsIn<T> extends BaseMatcher<T> {
    private final Collection<T> collection;

    public IsIn(Collection<T> collection) {
        this.collection = collection;
    }
    
    public IsIn(T[] elements) {
        collection = Arrays.asList(elements);
    }
    
    @Override
    public boolean matches(Object o) {
        return collection.contains(o);
    }

    @Override
    public void describeTo(Description buffer) {
        buffer.appendText("one of ");
        buffer.appendValueList("{", ", ", "}", collection);
    }
    
    @Factory
    public static <T> Matcher<T> isIn(Collection<T> collection) {
        return new IsIn<T>(collection);
    }
    
    @Factory
    public static <T> Matcher<T> isIn(T[] elements) {
        return new IsIn<T>(elements);
    }
    
    @Factory
    public static <T> Matcher<T> isOneOf(T... elements) {
        return isIn(elements);
    }
}
