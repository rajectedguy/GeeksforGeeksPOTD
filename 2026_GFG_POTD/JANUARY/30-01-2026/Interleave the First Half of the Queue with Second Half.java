class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        while (q.size() != queue.size()) {
            queue.add(q.poll());
        }
        while(!q.isEmpty() && !queue.isEmpty()){
            res.add(queue.poll());
            res.add(q.poll());
        }
        for (Integer val : res) {
            System.out.print(val + " ");
        }
    }
}