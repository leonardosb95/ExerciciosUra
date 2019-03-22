package br.com.a5.exerciciosjava.controllers;

import java.util.ArrayList;

import br.com.a5.exerciciosjava.models.CEP;
import br.com.a5.exerciciosjava.webservicesClientRest.WebServicesRest;

public class ConsumoRestCepController {
private WebServicesRest consumo= new WebServicesRest();

public Boolean ValidaConsumoRest() {
	Boolean resultado=false;
	try 
	{
		ArrayList<CEP> ceps=consumo.ConsumoWebServiceRest();
		
		System.out.println(ceps.toString());
		resultado=true;
		
	} 
	
	catch (Exception e) 
	{
		System.out.println("Erro na funcao");
		resultado=false;
	}

	
	
	
	return resultado;
}




}
