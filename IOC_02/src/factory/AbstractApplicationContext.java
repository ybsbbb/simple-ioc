package factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import bean.BeanDefinition;

public abstract class AbstractApplicationContext implements ApplicationContext {
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	private Map<Class<?>, BeanDefinition> beanDefinitionClassMap = new ConcurrentHashMap<Class<?>, BeanDefinition>();
	
	@Override
	public Object getBean(String beanName) {
		return this.beanDefinitionMap.get(beanName).getBean();
	}

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition, boolean isCreatedBean) {
		if(!isCreatedBean){
			beanDefinition = GetCreatedBean(beanDefinition);
		}
		this.beanDefinitionMap.put(beanName, beanDefinition);
	}

	protected void registerBeanDefinationWithClass(Class<?> type, BeanDefinition bd){
		this.beanDefinitionClassMap.put(type,bd);
	}
	protected BeanDefinition findBeanByClass(Class<?> t) {
		
		return this.beanDefinitionClassMap.get(t);
	}
	protected abstract BeanDefinition GetCreatedBean(BeanDefinition beanDefinition);

}
