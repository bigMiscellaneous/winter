public class DiGui {

    public static void main(String[] args) {
        int[] arr = new int[101];
        for(int i = 1 ; i < arr.length ; i ++){
            arr[i] = i;
        }
        int sum = add(arr);
        System.out.println(sum);
    }

    public static int add(int[] arr){
       return add(arr,0);
    }

    private static int add(int[] arr,int l){
        if(l == arr.length){
            return 0;
        }
        int sum = 0;
        sum = arr[l] + add(arr,l + 1);
        return sum;
    }
}
