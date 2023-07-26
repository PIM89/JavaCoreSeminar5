public class Main {

    /*
    Задание 1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку.

    Задание 2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
    например, состояния ячеек поля для игры в крестики-нолики, где 0 – это пустое поле, 1 – это поле с крестиком,
    2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
    Записать в файл состояние поля и добавить возможность восстановить состояние поля из файла
    */
    public static void main(String[] args) {
        // Задание 1
        BackupDir.backup("./test", "./backupTest");
        // Задание 2
        FieldStatus fieldStatus = new FieldStatus();
        System.out.println(fieldStatus);
        fieldStatus.recordFieldStatus();


        FieldStatus fieldStatus2 = new FieldStatus("fieldStatus.txt");
        System.out.println(fieldStatus2);
    }
}