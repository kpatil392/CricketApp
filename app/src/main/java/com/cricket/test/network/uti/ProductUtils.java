package com.cricket.test.network.uti;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductUtils {
    public static final String TAG = "Utils------>";
    public static final String ONE_WAY = "1";
    public static final String ROUND_TRIP = "2";
    private static final String DATE_REGEX = "^\\d{2}-\\d{2}-\\d{4}$";

    public static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }

    public static void getMandatoryField(TextInputLayout edt, String lbl) {
        final Spannable spannable1 = new SpannableString(lbl);
        spannable1.setSpan(new ForegroundColorSpan(Color.parseColor("#FA162B5A")), 0,
                spannable1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable1.setSpan(new ForegroundColorSpan(Color.RED),
                spannable1.length() - 1, spannable1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        edt.setHint(spannable1);
    }

    public static void getToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static boolean getName(String filename) {
        if (filename.length() < 1 || !filename.matches("^[a-zA-Z ]+$"))
            return false;
        else
            return true;
    }   public static boolean getOlderName(String filename) {
        if (filename.length() < 1 || !filename.matches("^[a-zA-Z .]+$"))
            return false;
        else
            return true;
    }

    public static void getAadharSecure(String strd) {
        String str = "748596329871";
        String strPan = "ABCD1234F";
        String msg = str.substring(1, 2);

        String msg1 = strPan.substring(10, 14);
        //Log.i("TAG---->","xxxx-xxxx-"+msg);
        Log.i("TAG---->", "xx" + msg);


    }



    public static String currentDateFlightBooking() {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a", Locale.getDefault()).format(new Date());
        return currentDate;
    }

    public static String getDateFlightBooking(String dateTime) {
        String inputPattern = "dd-MM-yyyy HH:mm:ss a";
        String outputPattern = "dd-MM-yyyy";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(dateTime);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.i(TAG, "DateToTime - " + str);
            str = dateTime;
        }
        Log.i(TAG, "DateToTime - " + str);

        return str;
    }

    public static String getTimeFlightBooking(String dateTime) {
        String inputPattern = "dd-MM-yyyy HH:mm:ss a";
        String outputPattern = "HH:mm a";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(dateTime);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.i(TAG, "DateToTime - " + str);
            str = "12:00 PM";
        }
        Log.i(TAG, "DateToTime - " + str);

        return str;
    }


    public static String currentDateShow() {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        return currentDate;
    }

    public static boolean isValidEmail(String target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }




    public static String getDateToTime(String time) {
        //02/10/2022 12:15:00 AM

        /*String inputPattern = "dd/MM/yyyy HH:mm:ss a";
        String outputPattern = "HH:mm a";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.i(TAG, "DateToTime - " + str);
        }
        Log.i(TAG, "DateToTime - " + str);*/
        String timess[] = time.split(" ");
        String hors[] = timess[1].split(":");
        String finalTime = hors[0] + ":" + hors[1] + " " + timess[2];
        Log.i(TAG, "DateToTime - " + finalTime);
        return finalTime;
    }

    public static String getDateToTimewithouta(String time) {
        //02/10/2022 12:15:00 AM

        String inputPattern = "MM/dd/yyyy HH:mm:ss a";
        String outputPattern = "hh:mm";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "DateToTimewithouta - " + str);
        return str;
    }

    public static String getDateToDayofWeek(String time) {
        //02/10/2022 12:15:00 AM
        String inputPattern = "MM/dd/yyyy HH:mm:ss a";
        String outputPattern = "EE";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "DateToDayofWeek - " + str);
        return str;
    }

    public static String getDateToMonth(String time) {
        //02/10/2022 12:15:00 AM
        String inputPattern = "MM/dd/yyyy HH:mm:ss a";
        String outputPattern = "MMM";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "DateToMonth - " + str);
        return str;
    }

    public static String getDateToDay(String time) {
        //02/10/2022 12:15:00 AM
        String inputPattern = "MM/dd/yyyy HH:mm:ss a";
        String outputPattern = "dd";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);

        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "DateToDay - " + str);
        return str;
    }

    public static String getDateToDDMMYYY(String time) {
        //02/10/2022 12:15:00 AM
        String inputPattern = "MM/dd/yyyy HH:mm:ss a";
        String outputPattern = "dd-MM-yyyy";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);

        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getDateTab(String time) {
        //02/10/2022 12:15:00 AM
        String inputPattern = "dd-MM-yyyy";
        String outputPattern = "dd-MMM-yyyy";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);

        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getTime(String time) {
        //02/10/2022 12:15:00 AM
        String inputPattern = "MM/dd/yyyy HH:mm:ss a";
        String outputPattern = "HH:mm a";
        SimpleDateFormat inputFormat = null;
        inputFormat = new SimpleDateFormat(inputPattern);

        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getAmountRound(Double amt) {
        String value = "";
        value = new DecimalFormat("##.##").format(amt);
        Log.i("Amount====>", value);
        return value;
    }

    public static Double getAmountRoundDouble(Double amt) {
        String value = "";
        value = new DecimalFormat("##.##").format(amt);
        Log.i("Amount====>", value);
        return Double.parseDouble(value);
    }

    public static Double getCommission90(Double amt) {
        String value = "";
        double res9 = (amt / 100.0f) * 90;
        value = new DecimalFormat("##.##").format(res9);
        Log.i("Amount====>", value);
        return Double.parseDouble(value);
    }

    public static Double getCommission10(Double amt) {
        String value = "";
        double res1 = (amt / 100.0f) * 10;
        value = new DecimalFormat("##.##").format(res1);
        Log.i("Amount====>", value);
        return Double.parseDouble(value);
    }


    public static final boolean isValidPhoneNumber(CharSequence target) {
        if (target.length() != 10) {
            return false;
        } else {
            return Patterns.PHONE.matcher(target).matches();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String ageCalculatess(String dob) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(dob);
            Instant instant = date.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate givenDate = zone.toLocalDate();
            Period period = Period.between(givenDate, LocalDate.now());
            Log.i("TAG", "RadioButton--->" + period.getYears());
            return String.valueOf(period.getYears());
        } catch (Exception e) {
        }
        return "0";
    }

    public static int ageCalculateInfant(String dobDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = null;//"29/11/1981");
        try {
            birthDate = sdf.parse(dobDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int years = 0;
        int months = 0;
        int days = 0;

        //create calendar object for birth day
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(birthDate.getTime());

        //create calendar object for current day
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);

        //Get difference between years
        years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = now.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;

        //Get difference between months
        months = currMonth - birthMonth;

        //if month difference is in negative then reduce years by one
        //and calculate the number of months.
        if (months < 0) {
            years--;
            months = 12 - birthMonth + currMonth;
            if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
                months--;
        } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            years--;
            months = 11;
        }

        //Calculate the days
        if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
            days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            int today = now.get(Calendar.DAY_OF_MONTH);
            now.add(Calendar.MONTH, -1);
            days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
        } else {
            days = 0;
            if (months == 12) {
                years++;
                months = 0;
            }
        }
        return years;
    }

    public static String ageCalculate(String dobDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = null;
        try {
            birthDate = sdf.parse(dobDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int years = 0;
        int months = 0;
        int days = 0;

        //create calendar object for birth day
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(birthDate.getTime());

        //create calendar object for current day
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);

        //Get difference between years
        years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = now.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;

        //Get difference between months
        months = currMonth - birthMonth;

        //if month difference is in negative then reduce years by one
        //and calculate the number of months.
        if (months < 0) {
            years--;
            months = 12 - birthMonth + currMonth;
            if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
                months--;
        } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            years--;
            months = 11;
        }

        //Calculate the days
        if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
            days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            int today = now.get(Calendar.DAY_OF_MONTH);
            now.add(Calendar.MONTH, -1);
            days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
        } else {
            days = 0;
            if (months == 12) {
                years++;
                months = 0;
            }
        }
        return String.valueOf(years);
    }

    public static boolean isValidPassportNo(String str) {
        // Regex to check valid.
        String regexa = "^[A-Z0-9<]{9}[0-9]{1}[A-Z]{3}[0-9]{7}[A-Z]{1}[0-9]{7}[A-Z0-9<]{14}[0-9]{2}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regexa);

        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(str);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }

    public static boolean isValidPassportNom(EditText editText) {
        boolean required = false;
        // Regex to check valid.
        String regexa = "^[A-Z0-9<]{9}[0-9]{1}[A-Z]{3}[0-9]{7}[A-Z]{1}[0-9]{7}[A-Z0-9<]{14}[0-9]{2}$";
        // passport number of India
        String regex = "^[A-PR-WYa-pr-wy][1-9]\\d" + "\\s?\\d{4}[1-9]$";

        editText.setError(null);

        if (required && !hasText(editText, "Valid Passport")) return false;

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(editText.getText().toString());
        if (required && !m.matches()) {
            editText.setError("Valid Passport Number");
            return false;
        }
        ;
        // Return if the string
        // matched the ReGex
        return false;
    }


    public static boolean isValidInfant(EditText editText, String errMsg) {
        String regex = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((?:19|20)[0-9][0-9])";
        boolean required = true;
        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if (required && !hasText(editText, errMsg)) return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        }
        ;
        if (required && Pattern.matches(regex, text)) {
            if (!compareDates(text)) {
                int age = ageCalculateInfant(text);
                Log.i(TAG, "-------" + age);
                if (age == 0 || age < 3) {
                    Log.i(TAG, "compareDates" + "---" + "true" + age);
                    return true;
                } else {
                    Log.i(TAG, "compareDates" + "---" + "false" + age);
                    editText.setError(errMsg);
                    return false;

                }
            } else {
                editText.setError(errMsg);
            }
        }

        return true;
    }

    public static boolean isValidAdult(EditText editText, String errMsg) {
        String regex = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((?:19|20)[0-9][0-9])";
        boolean required = true;
        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if (required && !hasText(editText, errMsg)) return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        }
        ;
        if (required && Pattern.matches(regex, text)) {
            if (!compareDates(text)) {
                int age = ageCalculateInfant(text);
                Log.i(TAG, "-------" + age);
                if (age < 120 && age > 12) {
                    Log.i(TAG, "compareDates" + "---" + "true" + age);
                    return true;
                } else {
                    Log.i(TAG, "compareDates" + "---" + "false" + age);
                    editText.setError(errMsg);
                    return false;

                }
            } else {
                editText.setError(errMsg);
            }
        }

        return true;
    }

    public static boolean isValidChild(EditText editText, String errMsg) {
        String regex = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((?:19|20)[0-9][0-9])";
        boolean required = true;
        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if (required && !hasText(editText, errMsg)) return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        }
        ;
        if (required && Pattern.matches(regex, text)) {
            if (!compareDates(text)) {
                int age = ageCalculateInfant(text);
                Log.i(TAG, "-------" + age);
                if (age < 13 && age > 1) {
                    Log.i(TAG, "compareDates" + "---" + "true" + age);
                    return true;
                } else {
                    Log.i(TAG, "compareDates" + "---" + "false" + age);
                    editText.setError(errMsg);
                    return false;
                }
            } else {
                editText.setError(errMsg);
            }
        }

        return true;
    }

    public static boolean isValid(EditText editText, String errMsg) {
        String regex = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((?:19|20)[0-9][0-9])";
        boolean required = true;
        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if (required && !hasText(editText, errMsg)) return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        }
        ;

        return true;
    }

    public static boolean hasText(EditText editText, String errMsg) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(errMsg);
            return false;
        }

        return true;
    }

    public static boolean compareDates(String psDate2) {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = dateFormat.parse(currentDate);
            date2 = dateFormat.parse(psDate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date2.after(date1)) {
            Log.i(TAG, "compareDates" + "---" + "After");
            return true;
        } else {
            Log.i(TAG, "compareDates" + "---" + "Before");
            return false;
        }
    }





    public static void checkPermission(String permission, int requestCode, Activity mActivity) {
        if (ContextCompat.checkSelfPermission(mActivity, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(mActivity, new String[]{permission}, requestCode);
        } else {
            Toast.makeText(mActivity, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isValidPanCardNo(String str) {
        return (isNullCheck(str) ? false : Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}").matcher(str).matches());
    }

    public static boolean isValidIFSCCode(String str) {
        return (isNullCheck(str) ? false : Pattern.compile("^[A-Z]{4}0[A-Z0-9]{6}$").matcher(str).matches());
    }

    public static boolean isValidPinCode(String str) {
        return (isNullCheck(str) ? false : Pattern.compile("^[1-9]{1}[0-9]{2}\\\\s{0,1}[0-9]{3}$").matcher(str).matches());
    }

    public static boolean isValidDrivingLicense(String str) {
        String regex = "^[A-Z]{2}[0-9]{2}[A-Z]{1}[0-9]{11}$";//([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}
        return (isNullCheck(str) ? false : Pattern.compile(regex).matcher(str).matches());
    }

    public static boolean isValidIndianPassport(String str) {
        return (isNullCheck(str) ? false : Pattern.compile("^[A-PR-WYa-pr-wy][1-9]\\d\\s?\\d{4}[1-9]$").matcher(str).matches());
    }

    public static boolean isValidGST(String str) {
        return (isNullCheck(str) ? false : Pattern.compile("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$").matcher(str).matches());
    }

    public static boolean isValidEmailId(String str) {
        return (isNullCheck(str) ? false : Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$").matcher(str).matches());
    }

    public static boolean isValidMobileNo(String str) {
        return (isNullCheck(str) ? false : Pattern.compile("^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$").matcher(str).matches());
    }
}
