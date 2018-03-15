package com.kayan.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("01/31/1979");
        System.out.println(d);
    }

}
