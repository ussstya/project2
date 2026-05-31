/*Программа, определяющая, какая из двух точек   и   находится ближе к началу координат. 
Исходные данные: целые числа  ,  ,  ,  .
Данные, выводимые на экран: сообщение «Точка A находится ближе к началу координат», «Точка B находится ближе к началу координат» или «Точки равноудалены от начала координат».  
*/
import java.util.Scanner;


public class pr1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x1, y1, x2, y2;
            System.out.print("Введите координаты точки A (x1 y1): ");
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            System.out.print("Введите координаты точки B (x2 y2): ");
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            double distA = x1 * x1 + y1 * y1;
            double distB = x2 * x2 + y2 * y2;
            if (distA < distB) {
                System.out.println("Точка A находится ближе к началу координат");
            } else if (distB < distA) {
                System.out.println("Точка B находится ближе к началу координат");
            } else {
                System.out.println("Точки равноудалены от начала координат");
            }
        }
    }
}