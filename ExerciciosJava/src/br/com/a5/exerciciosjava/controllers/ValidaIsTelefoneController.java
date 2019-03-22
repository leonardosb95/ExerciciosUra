package br.com.a5.exerciciosjava.controllers;

import java.util.ArrayList;
import java.util.Properties;

import br.com.a5.exerciciosjava.util.CaminhosProperties;
import br.com.a5.exerciciosjava.util.LerArquivoProperties;

public class ValidaIsTelefoneController {
	
public Boolean isCelular(String telefone) {

	Boolean celular=false;	
	String DDD=null;
	char digito=' ';
	ArrayList<String> dddList=new ArrayList<String>();
	ArrayList<String> ValidaDuplicidadeList=new ArrayList<String>();
	
	LerArquivoProperties lerArquivo= new LerArquivoProperties();
	CaminhosProperties caminho= new CaminhosProperties();
	Properties prop=lerArquivo.getProp(caminho.propDDD);
	Properties prop2=lerArquivo.getProp(caminho.propDuplicidadeDigitos);
	
	for (int i = 0; i < telefone.length(); i++) {
        
        if (telefone.charAt(i) == '*' || telefone.charAt(i) == '#')
        {
             celular= false;
            break;
        }
        
    }

	
	
	
//	Tirando o zero a esquerda
	if(telefone.substring(0,1).equals("0")) {
		
		telefone.substring(0,1).replaceAll("0","");
		telefone=telefone.substring(1,telefone.length());	
		
	}	
	
	
	for(int i=1;i<67;i++) {		
		dddList.add(prop.getProperty("DDD"+i));
		
	}	
		if(dddList.contains(telefone.substring(0,2))) {
			DDD=telefone.substring(0,2);
			
			
			
			
		}
		else {
			DDD="";
			System.out.println(DDD);
			celular=false;
		}
			
		
		if(telefone.charAt(2)=='9' && DDD!="" && telefone.length()==11) {
			
			digito=telefone.charAt(2);
			
			telefone=DDD+digito+telefone.substring(3,telefone.length());
			
			
			celular=true;
		}
		else {
			celular=false;
		}
		
		return celular;
	}
	

}
