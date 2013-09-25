package xtraLogical;


class ArrayMerge {
    
    public static void main(String[] args)
    {
        
        int[] queue1 = { 4, 7, 2, 9, 12, 35, 8, 49 };
        int[] queue2 = { 24, 53, 6, 19, 41, 71, 1, 68, 11, 32, 99 };
        int[] mergeQ = new int[queue1.length + queue2.length];
        
        int p = 0;
        for (int i = 0 ; i < queue1.length || i < queue2.length ; i++) {
            if (i < queue1.length) {
                mergeQ[p++] = queue1[i];
            }
            if (i < queue2.length) {
                mergeQ[p++] = queue2[i];
            }
        }
        
        for (int i = 0; i < mergeQ.length; i++) {
            System.out.print(mergeQ[i] + ",");
        }
        
    }
}