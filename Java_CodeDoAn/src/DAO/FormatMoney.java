
package DAO;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatMoney {
    public static String formatMoney(long money){
        // Format
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat decimalFormatter1 = (DecimalFormat) formatter.clone();
        decimalFormatter1.applyPattern("#,###");
        return decimalFormatter1.format(money);
    }
}
