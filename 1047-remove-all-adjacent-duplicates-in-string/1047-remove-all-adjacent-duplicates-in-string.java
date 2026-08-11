class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        StringBuilder res=new StringBuilder();

        for(int i=0;i<n;i++)
        {
            if(st.empty())
            {
                st.push(s.charAt(i));
                continue;
            }
            if(st.peek() == s.charAt(i))
            {
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        while(!st.empty())
        {
            res.append(st.peek());
            st.pop();
        }

        res.reverse();
        return res.toString();
    }
}