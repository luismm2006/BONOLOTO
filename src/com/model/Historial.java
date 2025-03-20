package com.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Historial {

	private Map<LocalDate, Combinacion> sorteos;
	private static final int SINCOMBINCACION = -1;
	public Historial() {
		super();
		this.sorteos = new HashMap<LocalDate, Combinacion>();
	}
	
	public boolean addSorteo(LocalDate localDate, Combinacion combinacion) {
		boolean añadir= false;
		if (sorteos.containsKey(localDate)) {
			añadir = false;
		}else {
			sorteos.put(localDate, combinacion);
			añadir = true;
		}
		return añadir;
	}
	public boolean addSorteo(int year, int month, int day, Combinacion combinacion) {
		boolean añadir= false;
		LocalDate fecha = LocalDate.of(year, month, day);
		if (sorteos.containsKey(fecha)) {
			añadir = false;
		}else {
			sorteos.put(fecha, combinacion);
			añadir = true;
		}
		return añadir;
	}
	
	public boolean actualizarSorteo(int year, int month, int day, Combinacion combinacionNueva) {
		boolean actualizada = false;
		LocalDate fecha = LocalDate.of(year, month, day);
		if (sorteos.containsKey(fecha)) {
			sorteos.replace(fecha, sorteos.get(fecha), combinacionNueva);
			actualizada = true;
		}
		return actualizada;
	}
	public boolean actualizarSorteo(LocalDate localDate, Combinacion combinacionNueva) {
		boolean actualizada = false;
		if (sorteos.containsKey(localDate)) {
			sorteos.replace(localDate, sorteos.get(localDate), combinacionNueva);
			actualizada = true;
		}
		return actualizada;
	}
	public boolean borrarSorteo(LocalDate localDate) {
		boolean seBorra= false;
		if (sorteos.containsKey(localDate)) {
			sorteos.remove(localDate);
			seBorra = true;
		}
		return seBorra;
	}
	
	
	
	public Map<LocalDate, Integer> comprobarAciertos(LocalDate localDate, Combinacion combinacion){
		int numAciertos = 0;
		if (sorteos.containsKey(localDate)) {
			if (sorteos.values().isEmpty() || sorteos.values()!=null) {
				 numAciertos = SINCOMBINCACION;
			}
			numAciertos=sorteos.get(localDate).comprobarCombinacion(combinacion);
		}
		Map<LocalDate, Integer> fechaAciertos = new HashMap<LocalDate, Integer>();
		fechaAciertos.put(localDate, numAciertos);
		return fechaAciertos;
	}
	
	public List<String> listarSorteosDesdeFecha(LocalDate localDate){
		
	}
	
	public List<String> mostrarHistoricoAsc(){
		
	}
	public List<String> mostrarHistoricoDesc(){
		
	}
}
