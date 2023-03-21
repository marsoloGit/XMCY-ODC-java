package ui.selenium;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    public CustomFieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    /**
     * the method is called by the fabric for every field in a class
     */
    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<?> decoratableClass = decoratableClass(field);
        // if a class of a field can be decorated
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }

            // element
            return createElement(loader, locator, decoratableClass);
        }
        //return null;
        return super.decorate(loader, field);
    }

    /**
     *
     * Returns the decorating class of a field or null in case when a class doesn't suit the decorator
     */
    private Class<?> decoratableClass(Field field) {

        Class<?> clazz = field.getType();

        // an element should have a constructor that takes WebElement
        try {
            clazz.getConstructor(WebElement.class);
        } catch (Exception e) {
            return null;
        }

        return clazz;
    }

    /**
     * Element creation. Finds WebElement and passes it to the custom class
     */
    protected <T> T createElement(ClassLoader loader, ElementLocator locator,
                                  Class<T> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        return createInstance(clazz, proxy);
    }

    /**
     * Creates an instance of the class, calling the constructor with WebElement as an argument
     */
    private <T> T createInstance(Class<T> clazz, WebElement element) {
        try {
            return (T) clazz.getConstructor(WebElement.class).newInstance(
                    element);
        } catch (Exception e) {
            throw new AssertionError("WebElement can't be represented as "
                    + clazz);
        }
    }
}
