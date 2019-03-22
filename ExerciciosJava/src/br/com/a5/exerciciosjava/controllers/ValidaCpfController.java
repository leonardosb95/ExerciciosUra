package br.com.a5.exerciciosjava.controllers;

public class ValidaCpfController {
	

	public boolean validaCPF(String strCpf)
	{		
	    int iDigito1Aux = 0; 
	    int iDigito2Aux = 0; 
	    int iDigitoCPF;
	    
	    
	    int iDigito1 = 0; 
	    int iDigito2 = 0; 
	    int iRestoDivisao = 0;
	    String strDigitoVerificador, strDigitoResultado;
	    String strZeroAesquerda="";

	    if (! strCpf.substring(0,1).equals("")){
	        try{
	        	strCpf = strCpf.replace('.',' ');
	            strCpf = strCpf.replace('-',' ');
	            strCpf = strCpf.replaceAll(" ","");
	            
	            if(strCpf.equals("00000000000") || strCpf.equals("11111111111") ||
	            strCpf.equals("22222222222") || strCpf.equals("33333333333") ||
	            strCpf.equals("44444444444") || strCpf.equals("55555555555") ||	
	            strCpf.equals("66666666666") || strCpf.equals("77777777777") ||
	            strCpf.equals("88888888888") || strCpf.equals("99999999999")      		
	            		
	            ){	           
	            	
	            	return false;
	            }
	            
	            if(strCpf.length()==9)
	            {
	            StringBuilder a= new StringBuilder();
	            a.append("00");
	            
	             strCpf  = a.toString()+strCpf;
	            }
	            else if(strCpf.length()==10) {
	            	StringBuilder a= new StringBuilder();
		            a.append("0");
		            
		             strCpf  = a.toString()+strCpf;
	            }
	            
	            
	            for (int iCont = 1; iCont < strCpf.length() -1; iCont++) {
	                iDigitoCPF = Integer.valueOf(strCpf.substring(iCont -1, iCont)).intValue();
	                iDigito1Aux = iDigito1Aux + (11 - iCont) * iDigitoCPF;
	                iDigito2Aux = iDigito2Aux + (12 - iCont) * iDigitoCPF;
	            }
	            iRestoDivisao = (iDigito1Aux % 11);
	            if (iRestoDivisao < 2) {
	                iDigito1 = 0;
	            } else {
	                iDigito1 = 11 - iRestoDivisao;
	            }
	            iDigito2Aux += 2 * iDigito1;
	            iRestoDivisao = (iDigito2Aux % 11);
	            if (iRestoDivisao < 2) {
	                iDigito2 = 0;
	            } else {
	                iDigito2 = 11 - iRestoDivisao;
	            }
	            strDigitoVerificador = strCpf.substring(strCpf.length()-2, strCpf.length());
	            strDigitoResultado = String.valueOf(iDigito1) + String.valueOf(iDigito2);
	           
	            
	            
	            
	            
	            
	            return strDigitoVerificador.equals(strDigitoResultado);
	        } catch (Exception e) {
	            return false;
	        }
	    } 
	    
	    else
	    {
	        return false;
	    }
	}
	
	
	

}
