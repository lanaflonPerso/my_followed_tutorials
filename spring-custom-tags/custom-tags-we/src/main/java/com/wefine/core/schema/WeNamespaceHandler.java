package com.wefine.core.schema;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

public class WeNamespaceHandler extends NamespaceHandlerSupport {
    private static final String WE_NS = "http://www.wefine.com/schema/we";
    private static final String WE_REMOTING = "remoting";
    private static final String WE_SERVICE = "service";

    public void init() {
    }

    @Override
    public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder definition, ParserContext parserContext) {
        if (isWeNs(node)) {
            Attr attr = (Attr) node;
            String name = attr.getLocalName();
            if (name.equalsIgnoreCase(WE_REMOTING) || name.equalsIgnoreCase(WE_SERVICE)) {
                BeanDefinition beanDefinition = definition.getBeanDefinition();
                beanDefinition.setAttribute(name, attr.getValue());

                return definition;
            }
        }
        return super.decorate(node, definition, parserContext);
    }

    private boolean isWeNs(Node node) {
        return node.getNamespaceURI() != null && node.getNamespaceURI().equalsIgnoreCase(WE_NS);
    }
}
