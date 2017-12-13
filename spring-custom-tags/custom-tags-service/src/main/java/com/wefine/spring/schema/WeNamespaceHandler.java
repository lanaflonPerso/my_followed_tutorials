package com.wefine.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class WeNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("service", new WeServiceBeanDefinitionParser());
	}

}
