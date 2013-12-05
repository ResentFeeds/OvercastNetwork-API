package me.jake0oo0;

import java.math.BigDecimal;

/**
 * Created by jake on 12/4/13.
 */
public class NumberUtils {

	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
}
