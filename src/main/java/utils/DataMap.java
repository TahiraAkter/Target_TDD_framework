package utils;

public enum DataMap {
	
	Title("Title"), URL("URL"), Email("Email"), Password("Password");
	
private String value;
	
	private DataMap(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
