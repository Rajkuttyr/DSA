public class SegmentTree {
    int tree[];
    int n;
    SegmentTree(int[] arr){
        n=arr.length;
        tree=new int[4*n];
        build(arr,0,0,n-1);
    }
    void build(int[] arr,int node,int start,int end){
        if(start==end){
            tree[node]=arr[start];
        }
        else{
            int mid = start +(end-start)/2;
            build(arr,2*node+1,start,mid);
            build(arr,2*node+2,mid+1,end);
            tree[node]=tree[2*node+1]+tree[node*2+2];
        }
    }
    int query(int node,int start,int end, int l,int r){
        if(r<start||l>end) return 0;
        if(l<=start && r>=end)return tree[node];
        else{
            int mid = start+end/2;
            int leftsum= query(2*node+1, start, mid, l, r);
            int rightsum= query(2*node+2,mid+1, end, l, r);
            return leftsum+rightsum;
        }
        
    }

    public static void main(String args[]) {

        int arr[] = {2,4,6,8};

        SegmentTree st = new SegmentTree(arr);

        // Query sum from index 1 to 3
        System.out.println("Sum (1,3): " +
            st.query(0,0,arr.length-1,1,3));


    }
    
}
