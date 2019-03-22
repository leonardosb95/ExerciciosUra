package br.com.a5.exerciciosjava.controllers;

import java.sql.SQLException;
import java.util.List;

import br.com.a5.exerciciosjava.dao.AplicacaoBD;
import br.com.a5.exerciciosjava.models.Usuario;

public class ValidaCPFeCNPJController {
	
	
private ValidaCnpjController objCnpj= new ValidaCnpjController();
private ValidaCpfController objCpf= new ValidaCpfController();
private AplicacaoBD consulta= new AplicacaoBD();
private Usuario usuario= new Usuario();

	public int verificaSeECPFouCnpj(String documento) {
		boolean resultadoCPF=false;
		boolean resultadoCNPJ=false;
		
		
		String cpf=consulta.getDocumento(documento).getCpf();
		String cnpj=consulta.getDocumento(documento).getCnpj();
		
		if(cnpj!=null && cpf==null) {
			
			cpf="0";
		}
		else if(cpf!=null && cnpj==null) {
			cnpj="0";
		}
		else if(cpf==null && cnpj==null) {
			cpf="0";
			cnpj="0";
			
		}
		
		int isCpforisCnpj=0;
		resultadoCPF=objCpf.validaCPF(cpf);
		resultadoCNPJ=objCnpj.validaCNPJ(cnpj);
			
			 if(resultadoCPF && cpf.equals(documento))
			{
				
				isCpforisCnpj=1;// verifica que é CPF
				
			}
			else if(resultadoCNPJ && cnpj.equals(documento)) 
			{
				
				isCpforisCnpj=2;//// verifica que é CNPJ
			}
			else 
			{
				isCpforisCnpj=0;//Verifica que não é nem CPF e nem CNPJ
			}
		
		return isCpforisCnpj;
	
		
	}
	
	
	
	
}
