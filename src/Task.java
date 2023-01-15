/* Первый семинар.
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2 */
import java.util.Random;
public class Task {
    public static void main(String[] args) throws Exception{
        print("Домашнее задание к 1 семинару!");
        int I = getIntFronRange(0,2000);
        System.out.println("Random number = " + I);
        System.out.println("Binary = " + Integer.toBinaryString(I));
        System.out.println("Number of one bits = " + Integer.bitCount(I));
        int n = getHighBit(I);
        System.out.println("Highest one bit = " + n);
        int lengthM1 = (arrLenM1(I, n));
        System.out.println();
        int[] M1 = new int[lengthM1];
        fillArray2(M1, I, n);
        print("Saved array m1: ");
        printArray(M1);
        System.out.println();
        int lengthM2 = (arrLenM2(I, n));
        int[] M2 = new int[lengthM2];
        fillArray(M2, n);
        print("Saved array m2: ");
        printArray(M2);
        System.out.println();
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static int getIntFronRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int getHighBit(int x){
        int highBit = Integer.highestOneBit(x);
        return highBit;
    }

    public static int arrLenM1(int x, int y) {
        int count = 0;
        while (x <= Short.MAX_VALUE ) {
            if (x % y == 0){
                count++;
            }
            x++;  
        }
        return count;
      }
    
    public static int arrLenM2(int x, int y){
        int count = 0;
        for(int i = Short.MIN_VALUE; i <= x;  i++){
            if (i % y == 0){ 
            count++;
            }
        }
        return count;
    }

    public static void fillArray(int[] M2, int n) {
        int currentIndex = 0;
        for(int currentValue = Short.MIN_VALUE; currentIndex <= M2.length-1;  currentValue++){
            if (currentValue % n == 0){ 
                M2[currentIndex]=currentValue;
                    currentIndex++;
            }   
        }
    }

    public static void fillArray2(int[] M1, int I, int n) {
        int currentIndex = 0;
        for(int currentValue = I; currentIndex <= M1.length-1;  currentValue++){
           if (currentValue % n == 0){ 
                M1[currentIndex]=currentValue;
                    currentIndex++;
            }   
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
      }
}