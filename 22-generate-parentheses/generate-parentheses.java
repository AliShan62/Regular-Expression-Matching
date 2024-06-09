class Solution {

    public List<String> generateParenthesis(int n) {
        generateParenthesisHelper(n, 0, 0, "");
        return ans;
    }

    List<String> ans = new ArrayList<>();

    public void generateParenthesisHelper(int n, int openCount, int closeCount, String current){

        //if total number of open and close brackets is n*2 because n pairs are allowed
        if(openCount + closeCount == n*2){
            ans.add(new String(current));
            return;
        }

        //If we have more open brackets, we can add a closing one
        if(openCount > closeCount && openCount < n){

            //add open bracket
            generateParenthesisHelper(n, openCount+1, closeCount, current += "(");

            //bracktack
            current = current.substring(0, current.length()-1);

            //add closing bracket
            generateParenthesisHelper(n, openCount, closeCount+1, current += ")");

        //if open brackets are equal to n, we cannot add anymore open brackets
        }else if(openCount == n){
            generateParenthesisHelper(n, openCount, closeCount+1, current += ")");

        //otherwise, the only option is to start with open bracket
        }else{
            generateParenthesisHelper(n, openCount+1, closeCount, current += "(");
        }

    }

}