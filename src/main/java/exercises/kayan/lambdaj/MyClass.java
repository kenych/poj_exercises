package kayan.lambdaj;

public class MyClass {

	private static final String DEFAIULT_KEY = "code";
	String key;
	String paramValue;

	public MyClass(Object key, Object paramValue) {
		this.key = (String)key;
		this.paramValue = (String)paramValue;
	}
	public MyClass(String key, String paramValue) {
		this.key = key;
		this.paramValue = paramValue;
	}

	public MyClass(String paramValue) {
		this(DEFAIULT_KEY, paramValue);
	}

	public String getKey() {
		return key;
	}

	public ParamValue getParamValue() {
		return new ParamValue(paramValue);
	}

	@Override
	public String toString() {
		return "MyClass [key=" + key + ", paramValue=" + paramValue + "]";
	}

}