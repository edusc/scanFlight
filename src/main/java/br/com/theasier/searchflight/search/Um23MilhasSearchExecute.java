package br.com.theasier.searchflight.search;

import br.com.theasier.searchflight.domain.Scan;
import br.com.theasier.searchflight.infra.AbstractSearchExecutor;

public class Um23MilhasSearchExecute extends AbstractSearchExecutor<Scan>{

	@Override
	public void execute() {
		System.out.println("Executando 123 Milhas........");
	}

}
