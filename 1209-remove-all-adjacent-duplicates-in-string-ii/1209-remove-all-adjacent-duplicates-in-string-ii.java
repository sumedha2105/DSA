class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<int[]> st = new Stack<>();
        int n = s.length();
        String res = "";

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (st.isEmpty()) {
                st.push(new int[]{c, 1});
                continue;
            }

            if (st.peek()[0] != c) {
                st.push(new int[]{c, 1});
                continue;
            }

            if (st.peek()[1] < k - 1) {
                int[] p = st.pop();
                st.push(new int[]{p[0], p[1] + 1});
                continue;
            }

            // count has reached k
            st.pop();
        }

        while (!st.isEmpty()) {
            int[] p = st.pop();

            while (p[1]-- > 0) {
                res += (char)p[0];
            }
        }

        return new StringBuilder(res).reverse().toString();
    }
}