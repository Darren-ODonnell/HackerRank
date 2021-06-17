package CurrencyFormatter;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Solution {
    int payment;


    NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
    String us = n.format(payment);
    NumberFormat n1 = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
    String india = n1.format(payment);
    NumberFormat n2 = NumberFormat.getCurrencyInstance(Locale.CHINA);
    String china = n2.format(payment);
    NumberFormat n3 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    String france = n3.format(payment);


}
