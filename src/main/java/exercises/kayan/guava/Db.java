package kayan.guava;

import java.util.Calendar;

import com.google.common.base.Supplier;

public class Db implements Supplier<String> {

	public String get() {
		return Calendar.getInstance().getTime().toString();
	}

}
