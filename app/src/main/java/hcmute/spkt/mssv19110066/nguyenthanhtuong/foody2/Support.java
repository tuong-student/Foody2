package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2;

import java.text.NumberFormat;
import java.util.Locale;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartDB;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartView;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.User.User;

public class Support {
    public static User user = null;
    public static CartDB cartDB = null;

    public static String CurrencyFormat(int price) {
        Locale locale = new Locale( "vi", "VN" );
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance( locale );

        return currencyFormatter.format( price );
    }

    public static User CreateUser(String name, String email, String password){
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
}
