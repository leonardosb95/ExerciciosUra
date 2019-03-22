package br.com.a5.exerciciosjava.controllers;

import br.com.a5.exerciciosjava.dao.AplicacaoBD;
import br.com.a5.exerciciosjava.models.Usuario;

public class VerificaVinculoController {
	
	private AplicacaoBD consulta= new AplicacaoBD();
	private Usuario usuario= new Usuario();
	
	
	public int validaVinculo(String telefone,String cpf) {
		int resultado=0;
		String cpfResultado=consulta.verificaTelefone(telefone).getCpf();
		if (cpfResultado.equals(cpf)) {
			
			resultado=1;
		}
		return resultado;
	}
	
	

}
