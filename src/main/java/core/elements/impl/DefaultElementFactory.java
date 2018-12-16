package core.elements.impl;

import core.elements.ElementFactory;
import core.elements.Element;
import org.openqa.selenium.WebElement;
import java.lang.reflect.InvocationTargetException;


public class DefaultElementFactory implements ElementFactory {
    @Override
    public <E extends Element> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return elementClass.getDeclaredConstructor(WebElement.class)
                        .newInstance(wrappedElement);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
            return null;

    }
}

