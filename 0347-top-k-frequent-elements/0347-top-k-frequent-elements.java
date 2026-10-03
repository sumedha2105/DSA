class Solution {
    class Pair {
    int first;
    int second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Pair> pq= new PriorityQueue<>(
            (a, b) -> {
                if (a.first != b.first)
                    return a.first - b.first;      
                return a.second-b.second; 
            }
        );

        HashMap<Integer,Integer> f=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            f.put(nums[i],f.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:f.entrySet())
        {
            int element=entry.getKey();
            int freq=entry.getValue();
            Pair curr=new Pair(freq,element);
            if(pq.size() <k)
            {
                pq.add(curr);
                continue;
            }
            if(curr.first <pq.peek().first)
            continue;
            pq.poll();
            pq.add(curr);
        }
        int[] res=new int[k];
        int i = k - 1;

        while (!pq.isEmpty()) {
            res[i] = pq.peek().second;
            pq.poll();
            i--;
        }

        return res;


        
    }
}