package com.biblioteca.util;

import java.util.Date;

import com.biblioteca.enums.SituacaoEnum;

public class Randomico {
	
	public static void main(String[] args) {
		
		String valorEnum = SituacaoEnum.A.toString();
		System.out.println(valorEnum);
		
		SituacaoEnum enums = SituacaoEnum.valueOf("P");
		System.out.println(enums);
		
		Date teste = new Date();
		System.out.println(teste.getTime());
				
		
	}
/*
	private static void random() {
		long inicio = System.currentTimeMillis();
		List<String> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		int cont = 0;
		Random r = new Random();
		for (int i = 0; i < 100000; i++) {									
			for (int j = 0; j < 6; j++) {			
				sb.append(r.nextInt(10));				
			}			
			if(!list.contains(sb.toString())){	
				list.add(sb.toString());
			}else{
				cont++;
			}			
			sb = new StringBuffer();	
		}
		
		System.out.println("contador: "+cont);
		
		System.out.println("tamanho lista: "+list.size());
		long fim = System.currentTimeMillis();
		
		long tempo  = (fim - inicio) / 1000;
		
		
		System.out.println(tempo);
	}*/

}
