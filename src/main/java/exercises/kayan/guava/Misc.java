package kayan.guava;

import static com.google.common.base.Objects.firstNonNull;
import static com.google.common.base.Optional.fromNullable;
import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

public class Misc {

	public static void main(String[] args) throws InterruptedException {
		String s = null;
		// s = "";
		System.out.println(isNullOrEmpty(s));

		System.out.println(firstNonNull(null, "default"));
		System.out.println(firstNonNull("non default", "default"));

		/////
		
		// String value = "ddd";
		String value = null;
		Optional<String> optional = fromNullable(value);
		System.out.println(optional.isPresent());
		System.out.println(optional.or("default"));

		
		//////////
		Supplier<String> dbsuSupplier = new Db();
		
		
		System.out.println(dbsuSupplier.get());
		Thread.sleep(1000);
		System.out.println(dbsuSupplier.get());
		Thread.sleep(1000);
		System.out.println(dbsuSupplier.get());
		
		Supplier<String> dbsuSupplierMemo =	Suppliers.memoize(dbsuSupplier);
		
		
		System.out.println(dbsuSupplierMemo.get());
		Thread.sleep(1000);
		System.out.println(dbsuSupplierMemo.get());
		Thread.sleep(1000);
		System.out.println(dbsuSupplierMemo.get());
		
		System.out.println("with exp");
		
		Supplier<String> dbsuSupplierMemoWithExp =	Suppliers.memoizeWithExpiration(dbsuSupplier, 2L, TimeUnit.SECONDS);

		System.out.println(dbsuSupplierMemoWithExp.get());
		Thread.sleep(1000);
		System.out.println(dbsuSupplierMemoWithExp.get());
		Thread.sleep(1000);
		System.out.println(dbsuSupplierMemoWithExp.get());
		
		
	
		

	}
}
