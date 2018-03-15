package kayan.lambdaj;

public class ParamValue {
	
	String arg1;
	String currency =  null;
	
	public ParamValue(String arg1){
		this.arg1 = arg1;
		
	}

	@Override
	public String toString() {
		return "ParamValue [arg1=" + arg1 + ", currency=" + currency + "]";
	}
	
	

}
