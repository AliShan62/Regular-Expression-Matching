public class Solution {
 public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
    ArrayList<Integer> result=new ArrayList<Integer>();
    if(matrix.length==0) return result; 
		spiralOrder(result, matrix, 0, matrix.length-1, 0, matrix[0].length-1); 
		return result; 
    }
	void spiralOrder(ArrayList<Integer> result, int[][] matrix, int upBound, int lowBound, int leftBound, int rightBound)
	{
	for(int i=leftBound; i<=rightBound; i++ )
	{
	result.add(matrix[upBound][i]); 
	}
	upBound++; if(upBound>lowBound) return; 
	for(int i=upBound; i<=lowBound; i++)
	{
	result.add(matrix[i][rightBound]); 
	}
	rightBound--; if(rightBound<leftBound) return; 
	for(int i=rightBound; i>=leftBound; i--)
	{
	result.add(matrix[lowBound][i]);
	}
	lowBound--; if(lowBound<upBound) return; 
	for(int i=lowBound; i>=upBound; i--)
	{
	result.add(matrix[i][leftBound]);
	}
	leftBound++; if(leftBound>rightBound) return; 
	spiralOrder(result,  matrix,  upBound,  lowBound,  leftBound,  rightBound); 
	}
}