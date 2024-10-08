package com.example.demo;

import java.math.BigInteger;

public class UtilityClass {

    public static String stringValue(Object value) {
        if (value == null || value.toString().equalsIgnoreCase("undefined") || value.toString().equalsIgnoreCase("null")) {
            return "";
        }
        return (value.toString()).trim();
    }

    public static Long longValue(Object value) {
        if (value instanceof String) {
            value = stringValue(value);
            String svalue = stringValue(value);
            if (svalue.equalsIgnoreCase("all") || svalue.equalsIgnoreCase("null") || svalue.length() == 0) {
                return null;
            }
            if (svalue.contains("null")) {
                return null;
            }

            float fvalue = floatObjectValue(value);
            Long val = (long) (float) fvalue;
            return val;
        }
        if (value instanceof Double) {
            Double svalue = (Double) value;
            Long val = (long) (float) (double) svalue;
            return val;
        }
        if (value instanceof Float) {
            Float svalue = (Float) value;
            Long val = (long) (float) svalue;
            return val;
        }
        if (value instanceof BigInteger) {
            BigInteger svalue = (BigInteger) value;
            Long val = svalue.longValue();
            return val;
        }
        if (value instanceof Integer) {
            return (long) (int) (Integer) value;
        }
        return (value == null ? null : (Long) value);
    }

    public static Float floatObjectValue(Object value) {
        try {
            if (value instanceof Float) {
                return ((Float) value).floatValue();
            } else if (value instanceof Integer) {
                return (float) ((Integer) value).intValue();
            } else if (value instanceof Long) {
                return (float) ((Long) value).longValue();
            } else if (value instanceof String) {
                if (stringValue(value).length() > 0) {
                    return (float) (double) Double.parseDouble(stringValue(value));
                }
                return null;
            } else if (value instanceof Double) {
                return (float) ((Double) value).doubleValue();
            }

            return (value == null ? null : (Float) value);
        } catch (Exception e) {
            return 0f;
        }
    }


}

