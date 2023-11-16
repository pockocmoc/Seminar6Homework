import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        int numTests = 1000; // Количество тестов
        int numDoors = 3; // Количество дверей
        int wins = 0; // Количество побед
        int losses = 0; // Количество поражений

        Random random = new Random();
        Map<Integer, String> results = new HashMap<>();

        for (int i = 1; i <= numTests; i++) {
            // Генерация случайного номера двери, за которой находится приз
            int prizeDoor = random.nextInt(numDoors) + 1;

            // Игрок выбирает случайную дверь
            int playerChoice = random.nextInt(numDoors) + 1;

            // Ведущий открывает одну из оставшихся дверей без приза
            int revealedDoor;
            do {
                revealedDoor = random.nextInt(numDoors) + 1;
            } while (revealedDoor == prizeDoor || revealedDoor == playerChoice);

            // Игрок меняет свой выбор на оставшуюся закрытую дверь
            int remainingDoor;
            do {
                remainingDoor = random.nextInt(numDoors) + 1;
            } while (remainingDoor == playerChoice || remainingDoor == revealedDoor);

            // Проверка, выиграл ли игрок
            if (remainingDoor == prizeDoor) {
                wins++;
                results.put(i, "Победа");
            } else {
                losses++;
                results.put(i, "Поражение");
            }
        }

        // Вывод статистики
        System.out.println("Победы: " + wins);
        System.out.println("Поражения: " + losses);

        // Вывод результатов тестов
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println("Шаг " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
