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

	   
	    public Combinacion() {
	        Random random = new Random();
	        Set<Integer> numerosSet = new HashSet<>();
	        Set<Integer> estrellasSet = new HashSet<>();

	        while (numerosSet.size() < TOTAL_NUMEROS) {
	            numerosSet.add(random.nextInt(MAXIMO_NUMEROS) + MINIMO);
	        }

	        while (estrellasSet.size() < TOTAL_ESTRELLAS) {
	            estrellasSet.add(random.nextInt(MAXIMO_ESTRELLAS) + MINIMO);
	        }

	        this.numeros = new ArrayList<>(numerosSet);
	        this.estrellas = new ArrayList<>(estrellasSet);

	        Collections.sort(numeros);
	        Collections.sort(estrellas);
	    }

	    
	    public Combinacion(int num1 ,int num2,int num3,int num4,int num5,int estrella1,int estrella2) {
	    	this(new Integer[] {num1 , num2, num3, num4, num5} , new Integer[] {estrella1, estrella2});
	    }

	    public Combinacion(Integer[] numeros,Integer[] estrellas) {
	    	 this.numeros = new ArrayList<Integer>(Arrays.asList(numeros));
		     this.estrellas = new ArrayList<Integer>(Arrays.asList(estrellas));
	    }
	    	    
	    public List<Integer> getNumeros() {
	        return numeros;
	    }

	    public List<Integer> getEstrellas() {
	        return estrellas;
	    } 
	    
	    public int comprobarCombinacion(Combinacion combinacion) {
	        int aciertos = 0;
	        if(this.numeros.equals(combinacion.numeros) && this.estrellas.equals(combinacion.estrellas)) {
	            aciertos = numeros.size()+estrellas.size();
	        } else {
	            for (int i = 0; i < estrellas.size(); i++) {
	                if(combinacion.getEstrellas().contains(estrellas.get(i))) {
	                    aciertos++;
	                }
	            }
	            for (int i = 0; i < numeros.size(); i++) {
	                if(combinacion.getNumeros().contains(numeros.get(i))) {
	                    aciertos++;
	                }
	            }
	        }
	        return aciertos;
	    }
	    
	    

	    @Override
	    public String toString() {
	        String imprimir = "";
	        for (int i = 0; i < numeros.size(); i++) {
	            if(i == numeros.size()-1) {
	                imprimir += numeros.get(i);
	            } else {
	                imprimir += numeros.get(i) + "-";
	            }

	        }
	        imprimir += " Estrellas: ";

	        for (int i = 0; i < estrellas.size(); i++) {
	            if(i == estrellas.size()-1) {
	                imprimir += estrellas.get(i);
	            } else {
	                imprimir += estrellas.get(i) + "-";
	            }
	        }

	        return imprimir;


	    }

		@Override
		public int hashCode() {
			return Objects.hash(estrellas, numeros);
		}

		@Override
		public boolean equals(Object obj) {
			return this==obj || obj!=null && obj instanceof Combinacion && this.hashCode() == obj.hashCode();
		}
	}




