public class Solution {
    public int longestValidParentheses(String s) {
      Stack<Integer> stack=new Stack<Integer>(); 
      int max=0; 
      int start=s.length()+1; 
      int current=0; 
      for(int i=0; i<s.length(); i++)
      {
        if(s.charAt(i)=='('){
          stack.push(i);
          continue; 
        }
        if(s.charAt(i)==')')
        {
          if(stack.isEmpty())
          {
            start=s.length()+1; 
          }else
          {
            start=Math.min(start, stack.pop());
          }
          if(stack.isEmpty())
          {
            current=i-start+1;
          }else
          {
              //the index haven't been poped up
            current=i-stack.peek();
          }
          max=Math.max(max, current);
       }
    }
    return max; 
}
}