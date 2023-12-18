package basics;

public class StringUtils {

    public static int count(String s, char c){
        int count=0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == c){count++;}
        }
        return count;
    }


    /**
     * Split a string according to a delimiter
     *
     * @param str The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     *          between two consecutive occurence of the delimiter.
     *          If there is no occurence of the delimiter, it should
     *          return an array of size 1 with the string at element 0
     */
    public static String [] split(String str, char delimiter){
        String [] A = new String[count(str, delimiter)+1];
        int j =0;
        String s = "";

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == delimiter){
                A[j] = s;
                s = "";
                j++;
            }
            if(c!= delimiter){
            s+=c;
            }
        }
        A[j] =s;
        return A;
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     *          the substring in str or -1 if sub does not appear
     *          in str
     */
    public static int indexOf(String str, String sub){
        if(str==sub){return 0;}
        for(int i=0; i < str.length()-sub.length()+1; i++){
            int n =0;
            for(int j=0; j<sub.length();j++){
                char a = str.charAt(i+j);
                char b = sub.charAt(j);
                if (a==b){n++;}
                if (n==sub.length()){return i;}
            }
        }
        return -1;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     *          character put to lower case.
     */
    public static String toLowerCase(String str){
         return str.toLowerCase();
    }


    /**
     * Check if a string is a palyndrome
     *
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){return false;}
        }
         return true;
    }


}