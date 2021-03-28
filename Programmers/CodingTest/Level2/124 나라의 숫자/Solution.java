class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int remainder;

        while (n > 0) {
            remainder = n % 3;
            n /= 3;

            if (remainder == 0) {
                n -= 1;
                remainder = 4;
            }
            sb.append(remainder);
        }

        return sb.reverse().toString();
    }
}