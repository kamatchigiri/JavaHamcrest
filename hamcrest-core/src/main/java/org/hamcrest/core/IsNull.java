/*  Copyright (c) 2000-2010 hamcrest.org
 */
package org.hamcrest.core;

import static org.hamcrest.core.IsNot.not;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Factory;
import org.hamcrest.BaseMatcher;

/**
 * Is the value null?
 */
public class IsNull<T> extends BaseMatcher<T> {
    @Override
    public boolean matches(Object o) {
        return o == null;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("null");
    }

    /**
     * Matches if value is null.
     */
    @Factory
    public static Matcher<Object> nullValue() {
        return new IsNull<Object>();
    }

    /**
     * Matches if value is not null.
     */
    @Factory
    public static Matcher<Object> notNullValue() {
        return not(nullValue());
    }

    /**
     * Matches if value is null. With type inference.
     */
    @Factory
    public static <T> Matcher<T> nullValue(@SuppressWarnings("unused") Class<T> type) {
        return new IsNull<T>();
    }

    /**
     * Matches if value is not null. With type inference.
     */
    @Factory
    public static <T> Matcher<T> notNullValue(Class<T> type) {
        return not(nullValue(type));
    }
}

