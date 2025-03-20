package com;

import com.model.Combinacion;

public class Principal {

	public static void main(String[] args) {
		Integer[] numeros = new Integer[TOTAL];
		Integer[] estrellas = null;
		
		Combinacion comb1 = new Combinacion(numeros, estrellas);
		System.out.println(comb1.toString());
	}

}
