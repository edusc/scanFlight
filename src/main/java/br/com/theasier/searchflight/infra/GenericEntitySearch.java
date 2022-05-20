package br.com.theasier.searchflight.infra;

import java.io.Serializable;

/**
 * Interface implementada por todos os objetos que serão
 * persistidos pela camada de mapeamento objeto relacional.
 *  
 * @author Eduardo Costa
 *
 */
public interface GenericEntitySearch extends Serializable {
	
	public Integer getId();
	
	public void setId(Integer id);

}
