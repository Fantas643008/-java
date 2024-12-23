
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число ");
        float num1 = scan.nextFloat();
        float num2 = scan.nextFloat();
        if (num1==(int)num1 && num2==(int)num2){
            System.out.println(num1+num2);
        }
        else {
            System.out.println("Ошибка");
        }

    }
}


















































