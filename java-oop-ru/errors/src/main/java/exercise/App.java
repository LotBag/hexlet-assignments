package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            double result = Math.round(circle.getSquare());
            int resultInt = (int) result;
            System.out.println(resultInt);
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
