public class Solution{
    public int trap(int[] A) { 
        // skip zeros  
        int cur = 0;  
        while (cur < A.length && A[cur] == 0) 
            ++cur;  
       
        // check each one  
        int vol = 0;  
        Stack<Integer> stack = new Stack<Integer>();  
        while (cur < A.length) {  
            while (!stack.isEmpty() && A[cur] >= A[stack.peek()]) {  
               int b = stack.pop();  
               if (stack.isEmpty()) 
                break;  
               vol += ((cur - stack.peek() - 1) * (Math.min(A[cur], A[stack.peek()]) - A[b]));  
            }  
            stack.push(cur);  
            ++cur;  
        }  
       
       return vol;  
 }  
}