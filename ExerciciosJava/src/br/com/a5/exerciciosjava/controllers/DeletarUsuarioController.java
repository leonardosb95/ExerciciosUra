package br.com.a5.exerciciosjava.controllers;

import br.com.a5.exerciciosjava.dao.AplicacaoBD;

public class DeletarUsuarioController {
	AplicacaoBD consulta= new AplicacaoBD();
	
	public Boolean excluirUsuario(String id) {
		
		
		Boolean resultado=consulta.deleteUsuario(id);
		
		if(!resultado)
		{
			System.out.println("id não existe");
			return false;
			
		}
		return true;
	
	
	}
	
	
}
