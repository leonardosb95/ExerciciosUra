package br.com.a5.exerciciosjava.controllers;

import br.com.a5.exerciciosjava.dao.AplicacaoBD;
import br.com.a5.exerciciosjava.models.Usuario;

public class IsTelefoneExisteController {

	private AplicacaoBD consulta= new AplicacaoBD();
	private ValidaIsTelefoneController validaTelefone= new ValidaIsTelefoneController();
	
	public boolean verificaTelefone(String telefone) {
		
		boolean isNumero=validaTelefone.isCelular(telefone);
		
		boolean telefoneExiste=false;
		
		if(isNumero) {
		System.out.println(consulta.getTelefone(telefone).getAni());
		telefoneExiste=true;
			
		}
		
		return telefoneExiste;
		
		
		
		
		
	}
	
	
	
	
	
}
