package br.com.a5.exerciciosjava.controllers;

import br.com.a5.exerciciosjava.dao.AplicacaoBD;
import br.com.a5.exerciciosjava.models.Usuario;

public class InserirUsuarioController {
AplicacaoBD consulta= new AplicacaoBD();
Usuario usuario= new Usuario();	
ValidaCpfController validaCpf= new ValidaCpfController();
ValidaCnpjController validaCnpj= new ValidaCnpjController();
ValidaIsTelefoneController validaTelefone= new ValidaIsTelefoneController();

	public Boolean inserirUsuarioController(String documento,String dt_nasc, String ani) {
		Usuario cliente= new Usuario();
		String regexAno="\\d{4}";
		Boolean resultado=false;
		boolean validaQtdAno=dt_nasc.matches(regexAno);
		boolean resultadoCpf=validaCpf.validaCPF(documento);
		boolean resultadoCnpj=validaCnpj.validaCNPJ(documento);
		
		if(resultadoCpf) {
			
			cliente.setCpf(documento);
			
		}
		else if(resultadoCnpj) {
			
			cliente.setCnpj(documento);
		}	
		
		
		if(validaTelefone.isCelular(ani) && dt_nasc.length()==4 && dt_nasc.matches(regexAno))
		{
			cliente.setAni(ani);
			cliente.setDt_nasc(dt_nasc);
			resultado=true;
		}
		
		else
		{
			resultado=false;
		}
		consulta.InsertUsuario(cliente);
		
		return resultado;
	}
	
	
	
}
