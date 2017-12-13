package com.wefine.spring.schema;

import java.util.Arrays;

import com.wefine.spring.web.MyDAO;
import com.wefine.spring.web.MyService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class WeServiceBeanDefinitionParser implements BeanDefinitionParser {

	public BeanDefinition parse(Element element, ParserContext parserContext) {
		// 手动注册 MyDAO 的Bean
		BeanDefinitionBuilder daoBean = BeanDefinitionBuilder.genericBeanDefinition(MyDAO.class);
		daoBean.addPropertyValue("fields", Arrays.asList(element.getAttribute("fields").split(",")));

		String daoId = element.getAttribute("daoId");
		parserContext.getRegistry().registerBeanDefinition(daoId, daoBean.getBeanDefinition());

		ManagedMap<Object, Object> map = new ManagedMap<>();
		map.put("dao1", new RuntimeBeanReference(daoId));

        // 手动注册 MyService 的Bean
        BeanDefinitionBuilder serviceBean = BeanDefinitionBuilder.genericBeanDefinition(MyService.class);
        serviceBean.addPropertyValue("serviceName", "myservice");
        serviceBean.addPropertyReference("defaultDao", daoId);
        serviceBean.addPropertyValue("daoRegistry", map);

		parserContext.getRegistry().registerBeanDefinition(element.getAttribute("serviceId"), serviceBean.getBeanDefinition());

		return null;
	}
}
