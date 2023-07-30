//Если необходимо, исправьте данный код:
// try {
//     int d = 0;
//     double catchedRes1 = intArray[8] / d;
//     System.out.println("catchedRes1 = " + catchedRes1);
//  } catch (ArithmeticException e) {
//     System.out.println("Catching exception: " + e);
//  }
 
public class task2 {
    public static void main(String[] args) {
        //Какое-то объявление intArray:
        int[] intArray = new int[2];

        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
        catch (NullPointerException e) {
            System.out.println("Catching NullPointerException: " + e);  //на случай, если intArray = null 
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Catching IndexOutOfBoundsException: " + e); //на случай выхода за границы массива
        }
        catch (ArithmeticException e) {
            System.out.println("Catching ArithmeticException: " + e); // деление на 0
        }        
    }
}
