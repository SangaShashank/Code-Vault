public class Sort_Array_By_Parity_905{
    public int[] sortArrayByParity(int[] nums) {
        int res [] = new int[nums.length];
        int i = 0, j= nums.length-1;
        for (int x :nums){
            if(x %2 == 0) {
                res[i] = x;
                i++;
            }
            else{
                res[j] = x; j--;
            }
        }
        return res;
    }
}