package br.com.a5.exerciciosjava.controllers;

import java.util.List;

import br.com.a5.exerciciosjava.dao.AplicacaoBD;
import br.com.a5.exerciciosjava.models.Usuario;

public class ValidaData_nascimentoController {
	private AplicacaoBD consulta= new AplicacaoBD();
	private Usuario usuario= new Usuario();
	
	public Boolean dataNascimentoController() {
		
	Boolean resultado=true;	
	List<Usuario> listaDataNascimento= consulta.getAllDataNascimento();
	
	
	for(Usuario usuario: listaDataNascimento) {
		
		
		System.out.println(usuario.Dt_nasc);
		
	}
		
		return resultado;
		
		
		
	}
	
	

}
