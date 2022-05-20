package br.com.theasier.searchflight.main;

import java.util.Set;

import org.reflections.Reflections;

import br.com.theasier.searchflight.config.ConfigSearch;
import br.com.theasier.searchflight.infra.AbstractSearchExecutor;
import br.com.theasier.searchflight.util.ReflectionUtils;
import br.com.theasier.searchflight.util.ValidatorUtil;

@SuppressWarnings("rawtypes")
public class SearchFlightChain extends AbstractSearchExecutor {
	
	protected SearchFlightChain next;
	
	public SearchFlightChain() {
		loadChain();
	}
	
	/**
	 * Carrega a cadeira de extrações a serem realizadas
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public void loadChain() {
		
		setNext(null);
		
		String[] searchs = ConfigSearch.getActiveSearchs();
		Reflections reflections = new Reflections("br.com.theasier.searchflight.search");
		Set<Class<? extends AbstractSearchExecutor>> classes = reflections.getSubTypesOf(AbstractSearchExecutor.class);
		
		if (!ValidatorUtil.isEmpty(searchs)) {
			
			for (String item : searchs) {
				
				String value = item.trim();
				
				for (Class classe : classes) {
					if (classe.getSimpleName().equals(value+"Execute")){
						add( (AbstractSearchExecutor) ReflectionUtils.instantiateClass(classe) );
						break;
					}
				}
				
			}
			
		}
	}
	
	@SuppressWarnings("unchecked")
	private void add(AbstractSearchExecutor next, AbstractSearchExecutor current) {
		if (next.getNext() == null) {
			next.setNext(current);
		} else {
			add(next.getNext(), current);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void add(AbstractSearchExecutor current) {
		if (getNext() == null) {
			setNext(current);
		} else {
			add(getNext(), current);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		if (getNext() != null) {
			getNext().process(getNext());
		}
	}

}
