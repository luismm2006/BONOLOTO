package com.model;

import java.time.LocalDate;
import java.util.*;
public class Combinacion {
	    private static final int MINIMO = 1;
	    private static final int MAXIMO_NUMEROS = 50;
	    private static final int MAXIMO_ESTRELLAS = 12;
	    private static final int TOTAL_NUMEROS = 5;
	    private static final int TOTAL_ESTRELLAS = 2;
	    private List<Integer> numeros;
	    private List<Integer> estrellas;

	   
	    
	    
	    public Combinacion(int num1 ,int num2,int num3,int num4,int num5,int estrella1,int estrella2) {
	    	this(new Integer[] {num1 , num2, num3, num4, num5} , new Integer[] {estrella1, estrella2});
	    }

	    public Combinacion(Integer[] numeros,Integer[] estrellas) {
	    	 Random random = new Random();
	    	 this.numeros = new ArrayList<Integer>();
		     this.estrellas = new ArrayList<Integer>();
	    	 
	    	for(int i = 0 ; i < TOTAL_NUMEROS; i++) {
	    		int numRandom = random.nextInt(MAXIMO_NUMEROS)+1;
	    		numeros[i] += numRandom;
	    	}
	    	for(int i = 0 ; i < TOTAL_ESTRELLAS; i++) {
	    		int numRandomEstre = random.nextInt(MAXIMO_ESTRELLAS)+1;
	    		numeros[i] += numRandomEstre;
	    	}
	        
	    }
	    	    
	    public List<Integer> getNumeros() {
	        return numeros;
	    }

	    public List<Integer> getEstrellas() {
	        return estrellas;
	    } 
	    
	    public int comprobarCombinación(Combinacion otraCombinacion) {
	    	int contador = 0;
	    	if (this.equals(otraCombinacion)) {
				contador = numeros.size() + estrellas.size();
			}else {
		    	List<Integer> copiaNumeros = new ArrayList<>(this.numeros);
		    	List<Integer> copiaEstrellas = new ArrayList<>(this.estrellas);
				copiaNumeros.retainAll(otraCombinacion.numeros);
				copiaEstrellas.retainAll(otraCombinacion.estrellas);
				contador = copiaNumeros.size()+copiaEstrellas.size();
				
				/*for (Integer num : this.getNumeros()) {
					if (otraCombinacion.getNumeros().contains(num)) {
						contador+=1;
					}
				}
				for (Integer estre : this.getEstrellas()) {
					if (otraCombinacion.getEstrellas().contains(estre)) {
						contador+=1;
					}
				}*/
				
			}
	    	return contador;
	    	
	    	/*SE PUEDE HACER CON RETAINALL Y LUEGO EL SIZE DE NUMEROS LO SUMAS CON EL DE ESTRELLAS*/
	    	
	    }
	    
	    

	    @Override
	    public String toString() {
	    	String numerosCadena = "";
	    	String estrellasCadena = "";
	        for (int i = 0; i < numeros.size(); i++) {
				if (i == numeros.size() - 1) {
					numerosCadena += numeros.get(i);
				}else {
					numerosCadena += numeros.get(i) + "-";
				}
			}
	        for (int i = 0; i < estrellas.size(); i++) {
				if (i == estrellas.size() - 1) {
					estrellasCadena += estrellas.get(i);
				}else {
					estrellasCadena += estrellas.get(i) + "-";
				}
			}
	        return "Los números son: "+ numerosCadena + " Estrellas son: " + estrellasCadena;
	    }

		@Override
		public int hashCode() {
			return Objects.hash(estrellas, numeros);
		}

		@Override
		public boolean equals(Object obj) {
			return obj==this || obj!=null && obj instanceof Combinacion && this.hashCode() == obj.hashCode();
		}
	}




