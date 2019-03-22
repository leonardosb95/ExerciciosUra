package br.com.a5.exerciciosjava.controllers;

import br.com.a5.exerciciosjava.dao.AplicacaoBD;
import br.com.a5.exerciciosjava.models.Usuario;

public class ValidaUpdateController {
AplicacaoBD consulta= new AplicacaoBD();
ValidaCpfController validaCpf= new ValidaCpfController();
ValidaCnpjController validaCnpj= new ValidaCnpjController();
ValidaIsTelefoneController validaTelefone=new ValidaIsTelefoneController();

	
	public Boolean atualizarDados(String documento, String dt_nasc,String ani,String id) {
		Usuario usuario= new Usuario();
		String regexAno="\\d{4}";
		Boolean resultado=false;
		boolean validaQtdAno=dt_nasc.matches(regexAno);
		boolean resultadoCpf=validaCpf.validaCPF(documento);
		boolean resultadoCnpj=validaCnpj.validaCNPJ(documento);
		
		if(resultadoCpf) {
			
			usuario.setCpf(documento);
			
		}
		else if(resultadoCnpj) {
			
			usuario.setCnpj(documento);
		}	
		
		
		if(validaTelefone.isCelular(ani) && dt_nasc.length()==4 && dt_nasc.matches(regexAno))
		{
			usuario.setAni(ani);
			usuario.setDt_nasc(dt_nasc);
			resultado=true;
		}
		
		else
		{
			resultado=false;
		}
		consulta.UpdateUsuario(usuario,id);
		
		return resultado;
		
		
	}
	
	
}
