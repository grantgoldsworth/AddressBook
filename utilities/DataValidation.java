package utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This class contains a few methods used to validate data input.
 * <p> Strings are checked using {@code ensureValidString(paramName, paramValue)} which throws {@code Exception} if
 * {@code paramValue} is {@code null} or empty.
 * <p> {@code Date} objects are checked using {@code ensureValidDate(paramName, date)} which throws {@code Exception}
 * if {@code date} is less than {@code MINUMUM_DATE} = January 1 2000. 
 */
public final class DataValidation {
    private static final Date MINIMUM_DATE = new Date(2000, 1, 1);

    private DataValidation() {}

    public static void ensureValidString(String paramName, String paramValue) throws Exception {
        if (paramValue == null || paramValue.trim().equals(""))
            throw new Exception(String.format("{0} cannot be null or blank", paramName));
    }

	public static void ensureValidDate(String paramName, Date date) throws Exception {
        if (date.compareTo(MINIMUM_DATE) == -1)
            throw new Exception(String.format("{0} cannot be less than {1}", paramName, MINIMUM_DATE));
    }    
}
