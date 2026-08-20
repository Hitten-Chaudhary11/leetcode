class Solution {
    public int[] resultArray(int[] a) {
        int n=a.length, x=1, y=1;
        int[] b=new int[n], c=new int[n];

        b[0]=a[0];
        c[0]=a[1];

        for(int i=2;i<n;i++)
            if(b[x-1]>c[y-1]) b[x++]=a[i];
            else c[y++]=a[i];

        for(int i=0;i<y;i++) b[x+i]=c[i];
        return b;
    }
}