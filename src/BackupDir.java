import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BackupDir {
    /**
     * Метод реализует резервное копирование указанной директории
     *
     * @param dirOrigin - директория для которой нужно создать резервную копию
     * @param dirBackup - директория куда будет произведено резервное копирование файлов и папок (в том числе из поддиректорий)
     * @throws IOException - возможна ошибка при вводе-выводе данных (Input-Output);
     */

    public static void backup(String dirOrigin, String dirBackup) {
        // Создание резервной директории
        File backupDir = new File(dirBackup);
        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }

        File workFolder = new File(dirOrigin);

        for (File item : workFolder.listFiles()) {

            // Проверка на директорию (файл).
            if (item.isDirectory()) {
                File currentFolder = new File((backupDir.getName() + "/" + item.getName()));
                currentFolder.mkdirs();

                // Если проверяемая директория не пуста, запускается рекурсия.
                if (item.list().length != 0) {
                    backup(item.getPath().replaceAll("\\\\", "/"), (dirBackup + "/" + item.getName()));
                }

            } else {
                Path copied = Paths.get((backupDir.getPath() + "\\" + item.getName()));
                try {
                    Files.copy(item.toPath(), copied, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
