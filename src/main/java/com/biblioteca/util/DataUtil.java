package com.biblioteca.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static Date converterDataTextoParaFormatoData(String dataString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public static Boolean verificarSeLivroEstaAtrazado(Date dataPrevDevolucao) {
		Boolean response = Boolean.FALSE;
		if(dataPrevDevolucao.before(new Date())){
			response = Boolean.TRUE;
		}
		return response;
	}

}
