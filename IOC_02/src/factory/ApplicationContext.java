package factory;

import bean.BeanDefinition;

public interface ApplicationContext {
	Object getBean(String string);
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition, boolean isCreatedBean);
}
