/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtraLogical;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvenTree_InterviewStreet {
    
    private static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        List<Integer> list = null;
        for( int i=0; i<m; i++ ) {
            line = br.readLine();
            int b = Integer.parseInt(line.split(" ")[0]);
            int a = Integer.parseInt(line.split(" ")[1]);
            list = map.get(a);
            if( list == null ) {
                list = new ArrayList<Integer>();
            }
            list.add(b);
            map.put(a, list);
        }
        int res = compute( );
        System.out.println(res);
    }
    
    
    private static int compute() {
        int total = 0;
        int node = 1;
        List<Integer> list = map.get(node);
        List<Integer> list2 = null;
        while(!list.isEmpty()) {
            int child = list.remove(0);
            int count = getCount( child );
            if( count%2 == 1) {
                total++;
            }
            list2 = map.get( child );
            if( list2 != null ) {
                list.addAll(list2);
            }
        }
        return total;
    }
    
    private static int getCount( int node ) {
        List<Integer> list = map.get(node);
        if( list != null ) {
            int count1 = list.size();
            int count2 = 0;
            for(int v: list ) {
                count2 += getCount( v );
            }
            return count1 + count2;
        }
        return 0;
    }

}