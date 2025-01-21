package org.cp.LLD.fileSystem;

import org.cp.LLD.fileSystem.models.Command;
import org.cp.LLD.fileSystem.service.IFileSystem;
import org.cp.LLD.fileSystem.service.impl.FileSystem;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String ...args){
        IFileSystem fileSystem = new FileSystem();
        Scanner scanner = new Scanner(System.in);

        while(true){
            String cmd = scanner.next();
            Command command = Command.of(cmd);


            switch (Objects.requireNonNull(command)){
                case mkdir -> {
                    String path = scanner.next();
                    fileSystem.mkdir(path);
                }
                case read_file -> {
                    String path = scanner.next();
                    System.out.println(fileSystem.readFile(path));
                }
                case write_file -> {
                    String path = scanner.next();
                    String content = scanner.next();
                    fileSystem.writePath(path, content);
                }

                case exit -> {
                    return;
                }

                default -> {
                    break;
                }
            }
        }
    }
}
