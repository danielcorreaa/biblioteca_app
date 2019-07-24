package com.biblioteca.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class SqlResources {
	
	private static Properties properties;
	private static final String PATH = "/sql.properties";
	private static SqlResources instance = null;
	private SqlResources() {}
	
	public static SqlResources getInstance(){
		if(instance == null){
			instance = new SqlResources();
			leitura();
		}
		return instance;
	}

	public static void leitura(){		
		properties = new Properties();
		InputStream inputStream = SqlResources.class.getResourceAsStream(PATH);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("static-access")
	public String querieSql(String chave){
		return this.properties.getProperty(chave);
	}
	@SuppressWarnings("static-access")
	public String querieSql(String chave, int inicio, int quantidade){
		return MessageFormat.format(this.properties.getProperty(chave), inicio, quantidade);
	}

}
