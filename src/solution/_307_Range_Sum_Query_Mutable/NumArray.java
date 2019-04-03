package solution._307_Range_Sum_Query_Mutable;

class NumArray {

    private int[] recodes;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        recodes = new int[nums.length];
    }

    public void update(int i, int val) {

    }

    public int sumRange(int i, int j) {
        return 0;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */