class Solution {
    public String[] classifyFieldTypes(String[] fields) {
       String[] ret = new String[fields.length];
       
       for (int i = 0; i < fields.length; i++) {
        String f = fields[i];
        if (isInt(f)) {
            ret[i] = "int";
        } else if (isBool(f)) {
            ret[i] = "bool";
        } else if (isDate(f)) {
            ret[i] = "date";
        } else {
            ret[i] = "string";
        }
       }

       return ret;
    }

    boolean isInt(String x) {
        if (x.length() < 1) {
            return false;
        }
        if (isNonNegativeInt(x)) {
            return true;
        }
        char c = x.charAt(0);
        if (c == '-') {
            return isNonNegativeInt(x.substring(1));
        }
        return false;
    }

    boolean isNonNegativeInt(String x) {
        int len = x.length();
        if (len < 1 || len > 18) {
            return false;
        }
        for (char c : x.toCharArray()) {
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    boolean isBool(String x) {
        return x.equalsIgnoreCase("true") || x.equalsIgnoreCase("false");
    }

    boolean isDate(String x) {
        String[] tokens = x.split("/");

        if (tokens.length != 3) {
            return false;
        }
        String dd = tokens[0];
        String mm = tokens[1];
        String yy = tokens[2];
        if (dd.length() != 2) {
            return false;
        }
        if (mm.length() != 2) {
            return false;
        }
        if (yy.length() != 4) {
            return false;
        }
        if (!isNonNegativeInt(dd) || !isNonNegativeInt(mm) 
        || !isNonNegativeInt(yy)) {
            return false;
        }
        Integer day = Integer.parseInt(dd);
        Integer month = Integer.parseInt(mm);
        Integer year = Integer.parseInt(yy);
        if (!(month >= 01 && month <= 12)) {
            return false;
        }
        int[] dayz = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    dayz[1]++;
                }
            } else {
                dayz[1]++;
            }
        }
        
        if (day >= 1 && day <= dayz[month - 1]) {
            return true;
        }
        
        return false;
    }
}
