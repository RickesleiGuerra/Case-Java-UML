package com.java.uml.domain.enums;

public enum TypeClient {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descryption;
	
	private TypeClient(int cod, String descryption) {
		this.cod = cod;
		this.descryption = descryption;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescryption() {
		return descryption;
	}
	
	public static TypeClient toEnum(Integer cod) {
		if ( cod==null ) {
			return null;
		}
		for (TypeClient x : TypeClient.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("ID invalid: "+cod);
	}
}


