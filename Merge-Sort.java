
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
	    int arr[] = {7,3,2,16,24,4,11,9};
        int n = arr.length;

        MergeSort ms = new MergeSort();
        int[] sortedArray = ms.mergeSort(arr);

        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(sortedArray));
	}
}

class MergeSort {
    
     int[] mergeSort(int arr[])
    {
        if(arr.length <= 1){   //özyinelemeli fonksiyonun çıkış koşulu, alt dizi 1 elemanlı kalana kadar diziyi bölmeye devam et
            return arr;
        }

        int midPoint = arr.length / 2; 

        int[] leftSorted = mergeSort(Arrays.copyOfRange(arr, 0, midPoint));  // leftSorted kısmı dizinin başından orta noktaya kadar gelsin
        int[] rightSorted = mergeSort(Arrays.copyOfRange(arr, midPoint, arr.length));  // rightSorted kısmı dizinin ortasından sonuna kadar gelsin

        return mergeSortedArrays(leftSorted, rightSorted);  // elde edilen dizileri sırala ve birleştir
    }
    

    int[] mergeSortedArrays(int arr1[], int arr2[]){  //leftSorted ve rightSorted isimli önce sıralanıp sonra birleştirilecek olan diziler
        int n1=0; //arr1 için kullanılacak olan değişken
        int n2=0; //arr2 için kullanılacak olan değişken
        int k = 0;  //birleştirilecek olan dizi için kullanılacak olan değişken
        int[] result = new int[arr1.length+arr2.length];

        while(n1<arr1.length && n2<arr2.length){   //arr1 ya da arr2  dizilerinden herhangibiri bitene kadar devam et
            if(arr1[n1] < arr2[n2]){   //arr2 dizisine ait değer arr1 dizisine ait değerden büyük ise 
                result[k] = arr1[n1];   //ana diziye arr2 dizisine ait değeri ekle
                n1++;  //arr1 dizisine ait değer eklendiğinden  arr1 dizisine ait index (n1) artırılır
            }
            else{
                result[k] = arr2[n2];  //eğer koşul sağlanmıyorsa birleştirilecek olan ana diziye arr2 dizisinin o indexteki değeri eklenir
                n2++;               //arr2 dizisine ait değer eklendiğinden  arr2 dizisine ait index (n2) artırılır
            }
            k++;
        }

        while(n1<arr1.length){   //eğer  arr1 dizisinin içerisinde eleman kaldıysa bunu ana diziye ekle
            result[k] = arr1[n1];
            n1++;
            k++;
        }

        while(n2<arr2.length){ //eğer  arr2 dizisinin içerisinde eleman kaldıysa bunu ana diziye ekle
            result[k] = arr2[n2];
            n2++;
            k++;
        }

        return result;
    }

   
    
}




