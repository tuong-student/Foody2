package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2;

import java.text.NumberFormat;
import java.util.Locale;

public class Support {

    public static String CurrencyFormat(int price) {
        Locale locale = new Locale( "vi", "VN" );
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance( locale );

        return currencyFormatter.format( price );
    }
}
