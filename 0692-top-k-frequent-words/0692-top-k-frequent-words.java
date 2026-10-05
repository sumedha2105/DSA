class Solution {
    class Pair {
    int first;
    String second;

    Pair(int f, String s) {
        first = f;
        second = s;
    }
}
    public List<String> topKFrequent(String[] words, int k) {
        int n=words.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first)
                return a.first-b.first;
                return b.second.compareTo(a.second);
            }
        );

        HashMap<String,Integer> f=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            f.put(words[i],f.getOrDefault(words[i],0)+1);
        }

        for(Map.Entry<String,Integer> entry:f.entrySet())
        {
            String element=entry.getKey();
            int freq=entry.getValue();
            Pair curr=new Pair(freq,element);
            if(pq.size()<k)
            {
                pq.add(curr);
                continue;
            }
            if(curr.first<pq.peek().first)
                continue;

            if(curr.first == pq.peek().first &&
   curr.second.compareTo(pq.peek().second) > 0)
    continue;
            pq.poll();
            pq.add(curr);
        }
        List<String> res=new ArrayList<>();

        while(!pq.isEmpty())
        {
            res.add(pq.peek().second);
            pq.poll();
        }
        Collections.reverse(res);

        return res;

        
    }
}