import java.util.*;

class SegmentTree{
    int[] tree;

    SegmentTree(int n){
        tree = new int[n];
    }

    void build(int[] arr, int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
        }
        else{
            int mid = (start + end)/2;
            build(arr, 2*node + 1, start, mid);
            build(arr, 2*node + 2, mid + 1, end);
            tree[node] = (tree[2*node + 1] + tree[2*node + 2]);
        }
    }

    void update(int[] arr, int node, int index, int val, int start, int end){
        if(start == end){
            tree[node] += val;
            arr[start] += val;
        } 
        else{
            int mid = (start + end)/2;
            if(start <= index && index <= mid){
                update(arr, 2*node + 1, index, val, start, mid);
            }
            else{
                update(arr, 2*node + 2, index, val, mid + 1, end);
            }
            tree[node] = tree[2*node + 1] + tree[2*node + 2];
        }
    }

    int query(int node, int start, int end, int left, int right){
        if(right < start || end < left){
            return 0;
        }
        if(start>=left&& end<=right){
            return tree[node];
        }
        int mid = (start + end)/2;
        int l=query(2*node+1,start,mid,left,right);
        int r=query(2*node+2,mid+1,end,left,right);
        return (l+r);
    }
}

public class SegTree_Test{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        int height = (int)(Math.log(n)/Math.log(2)) + 1;
        int tree_nodes = (int) Math.pow(2, height + 1);
        SegmentTree ob = new SegmentTree(tree_nodes);
        ob.build(arr, 0, 0, n - 1);
        for(int i = 0; i < tree_nodes; i++){
            System.out.print(ob.tree[i] + " ");
        }
        System.out.println();
        System.out.println(ob.query(0, 0, n - 1, 3, 5));
    }
}