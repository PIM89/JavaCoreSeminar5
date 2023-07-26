import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FieldStatus {
    private int[] field;

    /** Создание объекта из случайных чисел от 0 до 3 (включительно).*/
    public FieldStatus() {
        this.field = createRandomField();
    }

    /** Создание объекта с загрузкой поля из файла.*/
    public FieldStatus(String fileName) {
        this.field = loadFieldStatus(fileName);
    }

    public int[] getField() {
        return field;
    }

    public void setField(int[] field) {
        this.field = field;
    }

    private int[] createRandomField() {
        int[] res = new int[9];
        for (int i = 0; i < 9; i++) {
            res[i] = (int) (Math.random() * (3 + 1));
        }
        return res;
    }

    /** Метод реализует запись состояния поля в файл.*/

    public void recordFieldStatus() {
        try (FileWriter writer = new FileWriter("fieldStatus.txt", StandardCharsets.UTF_8, false)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < getField().length; i++) {
                stringBuilder.append(getField()[i] + " ");
            }
            writer.write(stringBuilder.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод возвращает массив целых чисел. Информация подгружается из файла.
     * @param fileName - название файла.
     * @return - массив целых чисел.
     */

    public int[] loadFieldStatus(String fileName) {
        int[] res = new int[9];
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int i = 0;
            while (scanner.hasNextInt()) {
                res[i++] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getField().length; i++) {
            stringBuilder.append(getField()[i] + " ");
        }
        return stringBuilder.toString();
    }
}
