package br.com.a5.exerciciosjava.controllers;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import br.com.a5.exerciciosjava.util.CaminhosProperties;
import br.com.a5.exerciciosjava.util.LerArquivoProperties;

public class ValidaIsFeriadoController {
	
	
	
	    public Boolean isFeriado(String data) {
	    
	    	 ArrayList<String> feriados=new ArrayList<String>();
	    	 
	    	 LerArquivoProperties lerArquivo= new LerArquivoProperties();
	 		CaminhosProperties caminho= new CaminhosProperties();
	 		Properties prop= lerArquivo.getProp(caminho.propFeriado);
	    	
	    	for (int i = 1; i < 3; i++) {
				
				feriados.add(prop.getProperty("feriado"+i));
				
				
			}  
	    	
	    	
	    	if (!feriados.contains(data)) {
				return false;
			}
	    	
	    	return true;
	    }
	    

}
