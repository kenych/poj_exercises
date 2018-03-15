package kayan.guava;

import static com.google.common.collect.Iterators.find;
import static java.util.Arrays.asList;

import com.google.common.base.Predicate;

public enum Enum {

	Element1(0), Element2(1);

	private int id;

	Enum(int id) {
		this.id = id;
	}

	public static Enum byId(final int id) {

		return find(asList(values()).iterator(), new Predicate<Enum>() {
			public boolean apply(Enum input) {
				return input.id == id;
			}
		});

	}




}
