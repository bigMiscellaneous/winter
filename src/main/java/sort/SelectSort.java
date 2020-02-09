package sort;

public class SelectSort<E> {

    public void selectSort(int[] array){
        for(int i = 0 ; i < array.length - 1 ; i ++){
            for(int j = i + 1 ; j < array.length ; j ++){
                if(array[j] < array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void main(String[] args){
        E[] array = (E[])new Object[]{1,4,2,3,5,8,6,7,9};
        SelectSort sort = new SelectSort();
        //sort.selectSort(array);
        SortHelpTest help = new SortHelpTest();
        help.printArray(array);
    }
}
