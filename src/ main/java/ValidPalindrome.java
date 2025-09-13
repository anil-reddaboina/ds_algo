public class ValidPalindrome {

    public static void main(String[] args) {

        String input = "A man, a plan, a canal: Panama";
         Boolean result = approach2(input);

        System.out.println("result :" + result);
    }

    private static Boolean validPalindrome(String input) {
        StringBuilder sb = new StringBuilder();
        for(char ch: input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString().equals(sb.reverse().toString());

    }

    private static Boolean approach2(String input) {
        if(input.isEmpty()) {
            return true;
        }

        int start = 0;
        int last = input.length()-1;

        while(start <= last) {
            char currentStart = input.charAt(start);
            char curentLast = input.charAt(last);

            if(!Character.isLetterOrDigit(currentStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(curentLast)) {
                last--;
            }else {
                if (Character.toLowerCase(currentStart) != Character.toLowerCase(curentLast)) {
                    return false;
                }
                start ++;
                last --;
            }
        }
        return true;
    }
}
