package br.com.theasier.searchflight.infra;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

public abstract class AbstractSearchExecutor<T extends GenericEntitySearch> {
	
	/** Próximo processo a ser executado */
	public AbstractSearchExecutor<T> next;
	
	/** Executa o processo de extração do site corrente*/
	public abstract void execute();
	
	private Class<T> entityClass;
	
	/***/
	@SuppressWarnings("unchecked")
	public void process(final AbstractSearchExecutor<T> next) {
		
		if (next != null) {
			
			String label = next.getClass().getSimpleName().substring(0, next.getClass().getSimpleName().indexOf("Execute"));
			
			try {
				
				addInfo("Executando " + label);
				
				if (next.getEntityClass() == null) {
					Class<?> clazz = next.getClass();
					next.setEntityClass((Class<T>) ((ParameterizedType)clazz.getGenericSuperclass()).getActualTypeArguments()[0]);
				}
				
				long ticks = new Date().getTime();
				
				next.execute();
				
				addInfo(String.format("Tempo gasto com " + label + ": %.2f segundos", (new Date().getTime() - ticks) / 1000.0));
				
				
			} catch (Exception e) {
				 e.printStackTrace();
			} finally {
				
				addInfo("Finalizando "+label+"...");
				addInfo("");
				
				if (next.getNext() != null)
					process(next.getNext());
				
			}
			
		}
		
	}
	
	
	public AbstractSearchExecutor<T> getNext() {
		return next;
	}
	
	public AbstractSearchExecutor<T> setNext(AbstractSearchExecutor<T> next) {
		this.next = next;
		return next;
	}
	
	public void addErro(String msg){
		System.err.println("ERRO: " + msg);
	}
	
	public void addInfo(String msg){
		System.out.println(msg);
	}


	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	

}
