package br.com.a5.exerciciosjava.controllers;

public class ValidaCnpjController {

public Boolean validaCNPJ(String strCnpj) {
		
		strCnpj = strCnpj.replace('.',' ');
	    strCnpj = strCnpj.replace('/',' ');
	    strCnpj = strCnpj.replace('-',' ');
	    strCnpj= strCnpj.replaceAll(" ","");
	    String validaCnpj="\\d[0-9]";
	    
	   
	    
	    if(!(strCnpj.length()==14 || strCnpj.length()==13)) {
	    	
	    	return false;
	    	
	    }
	    
		if(strCnpj.equals("00000000000000") || strCnpj.equals("11111111111111") ||
        strCnpj.equals("22222222222222") || strCnpj.equals("33333333333333") ||
        strCnpj.equals("44444444444444") || strCnpj.equals("55555555555555") ||	
        strCnpj.equals("66666666666666") || strCnpj.equals("77777777777777") ||
        strCnpj.equals("88888888888888") || strCnpj.equals("99999999999999")        		
	            		
        ){	    
		
        	return false;
        }
		
		
		char dig13, dig14;
	    int sm, i, r, num, peso;
	    
	    
        
        
	// "try" - protege o código para eventuais erros de conversao de tipo (int)
	    try {
	// Calculo do 1o. Digito Verificador
	      sm = 0;
	      peso = 2;
	      for (i=11; i>=0; i--) {
	// converte o i-ésimo caractere do CNPJ em um número:
	// por exemplo, transforma o caractere '0' no inteiro 0
	// (48 eh a posição de '0' na tabela ASCII)
	        num = (int)(strCnpj.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }
	 
	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig13 = '0';
	      else dig13 = (char)((11-r) + 48);
	 
	// Calculo do 2o. Digito Verificador
	      sm = 0;
	      peso = 2;
	      for (i=12; i>=0; i--) {
	        num = (int)(strCnpj.charAt(i)- 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }
	 
	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig14 = '0';
	      else dig14 = (char)((11-r) + 48);
	 
	// Verifica se os dígitos calculados conferem com os dígitos informados.
	      if ((dig13 == strCnpj.charAt(12)) && (dig14 == strCnpj.charAt(13)))
	         return(true);
	      else return(false);
	    } 
	    catch (Exception erro) {
	        return(false);
	    }
	}	
	
}
