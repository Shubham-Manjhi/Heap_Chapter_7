import java.lang.*; 

public class Heap_Chapter_7
{
    public int[] array;                                     
    public int count;                                       // Number of elements in Heap.
    public int capacity;                                    // Size of the heap.
    public int heap_type;                                   // Min Heap or max Heap.
    public void Heap(int capacity,int heap_type)
    {
        this.heap_type = heap_type;
        this.count=0;
        this.capacity = capacity;
        this.array=new int[capacity];
    }
    
    public int Parent(int i)
    {
        if(i<=0 || i>=this.count)
            return -1;
        return i-1/2;
    }
    
    public int LeftChild(int i)
    {
        int left=2*i+1;
        if(left>=this.count)
            return -1;
        return left;
    }
    
    public int RightChild(int i)
    {
        int right = 2*i+2;
        if(right>=this.count)
            return -1;
        return right;
    }
    
    public int GetMaximum(int i)
    {
        if(this.count==0)
            return -1;
        return this.array[0];
    }
    
    public void PercolateDown(int i)
    {
        int l,r,max,temp;
        l = LeftChild(i);
        r = RightChild(i);
        if(l!=-1 && this.array[l]>this.array[i])
            max=l;
        else 
            max=i;
        if(r!=-1 && this.array[r] > this.array[max])
            max=r;
        if(max!=i)
        {
            temp=this.array[i];
            this.array[i] = this.array[max];
            this.array[max]=temp;
        }
        PercolateDown(max);
    }

    int DeleteMax()
    {
        if(this.count==0)
            return -1;
        int data=this.array[0];
        this.array[0]=this.array[this.count-1];
        this.count--;
        PercolateDown(0);
        return data;
    }
    
    public void ResizeHeap()
    {
        int[] array_old=new int[this.capacity];
        System.arraycopy(this.array,0,array_old,0,this.count-1);
        this.array=new int[this.capacity*2];
        if(this.array==null)
        {
            System.out.println("Memory Error");
            return;
        }
        for(int i=0;i<this.capacity;i++)
            this.array[i]=array_old[i];
        this.capacity*=2;
        array_old=null;
    }
    
    public void Insert(int data)
    {
        int i;
        if(this.count==this.capacity)
            ResizeHeap();
        this.count++;
        i=this.count++;
        i=this.count-1;
        while(i>=0 && data > this.array[(i-1)/2])
        {
            this.array[i]=this.array[(i-1)/2];
            i=i-1/2;
        }
        this.array[i]=data;
    }
    
    
    public void DestroyHeap()
    {
        this.count=0;
        this.array=null;
    }
    
    public void BuilHeap(Heap_Chapter_7 h,int[] A, int n)
    {
        if(h==null) return;
        while(n>this.capacity)
            h.ResizeHeap();
        for(int i=0;i<n;i++)
            h.array[i] = A[i];
        this.count=n;
        for(int i=(n-1)/2;i>=0;i--)
            h.PercolateDown(i);
    }
    
    
    
    public static void main(String[] args)
    {
        System.out.println(" Code was Debbugs Sucssful ");
    }
    
    
}