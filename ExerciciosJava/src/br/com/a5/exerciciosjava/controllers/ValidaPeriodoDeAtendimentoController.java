package br.com.a5.exerciciosjava.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;

import br.com.a5.exerciciosjava.util.CaminhosProperties;
import br.com.a5.exerciciosjava.util.LerArquivoProperties;

public class ValidaPeriodoDeAtendimentoController {
	
	
	public Boolean horarioAtendimento() {
	
	LerArquivoProperties lerArquivo= new LerArquivoProperties();
	CaminhosProperties caminho= new CaminhosProperties();
	Properties prop= lerArquivo.getProp(caminho.propPeriodoDeAtendimento);
	
	int manha=Integer.parseInt(prop.getProperty("manha"));
	int tarde=Integer.parseInt(prop.getProperty("tarde"));
	int noite=Integer.parseInt(prop.getProperty("noite"));
	String periodo;
		
	Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
	int ano = calendar.get(Calendar.YEAR);
	int mes = calendar.get(Calendar.MONTH); // O mês vai de 0 a 11.
	int semana = calendar.get(Calendar.WEEK_OF_MONTH);
	int dia = calendar.get(Calendar.DAY_OF_MONTH);
	int hora = calendar.get(Calendar.HOUR_OF_DAY);
	int minuto = calendar.get(Calendar.MINUTE);
	int segundo = calendar.get(Calendar.SECOND);
	
	
	if (hora>=manha && hora<tarde) {
		
		periodo= "manha";
		System.out.println(periodo);
	}
	else if(hora>=tarde && hora<noite) {
		
		periodo= "tarde";
		System.out.println(periodo);
	}
	
	else if(hora>noite) {
		
		periodo= "noite";
		System.out.println(periodo);
	}
		 return true;
		 
		  
		  

        
		
	
	}
	

}
