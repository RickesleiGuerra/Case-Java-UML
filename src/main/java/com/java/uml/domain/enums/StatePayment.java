package com.java.uml.domain.enums;

public enum StatePayment {

	PENDING(1,"Pending"),
	SETTLED(2, "Settled"),
	CANCELED(3, "Cancceled");
	
	private int cod;
	private String descryption;
	
	private StatePayment(int cod, String descryption) {
		this.cod = cod;
		this.descryption = descryption;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescryption() {
		return descryption;
	}
	
	public static StatePayment toEnum(Integer cod) {
		if ( cod==null ) {
			return null;
		}
		for (StatePayment x : StatePayment.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("ID invalid: "+cod);
	}
}
