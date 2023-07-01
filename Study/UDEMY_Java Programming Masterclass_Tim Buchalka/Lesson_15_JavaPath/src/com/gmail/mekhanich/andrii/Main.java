package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

//        Path path = FileSystems.getDefault().getPath("file1.txt");
//        printFile(path);
//
////        Path path01 = FileSystems.getDefault().getPath("files_folder","subdirectory_file.txt");
//        Path path01 = Paths.get(".","files_folder","subdirectory_file.txt");
//        printFile(path01);
//
//        Path path02 = Paths.get("G:\\Study\\Other_file_JavaPath.txt");
//        printFile(path02);
//
//        Path path03 = Paths.get("."); // ".." for parent folder
//        System.out.println(path03.toAbsolutePath());
//
//        Path path04 = FileSystems.getDefault().getPath(".", "files_folder", "..", "files_folder", "subdirectory_file.txt"); // bueeeeee
//        printFile(path04);
//
//        Path path05 = FileSystems.getDefault().getPath("thisfiledoesntexists.txt");
//        System.out.println(path05.toAbsolutePath());
//
//        Path path06 = Paths.get("/Volume/Tests/FirstTest", "abcdef", "whatever.txt");
//        System.out.println(path06.toAbsolutePath());
//
//        path = FileSystems.getDefault().getPath("");
//        System.out.println("exists = " + Files.exists(path));


        // CRUD files
        try {
//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
////            Files.copy(sourceFile, copyFile); // just copy file
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING); // copy file even if this file already exists

//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            Path copyFile01 = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile01, StandardCopyOption.REPLACE_EXISTING); // copy file even if this file already exists

//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Path destinations = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt"); // for rename the file just change third parametr - name in destination
//            Files.move(fileToMove, destinations);

//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.delete(fileToDelete);
////            Files.deleteIfExists(fileToDelete); //for avoid exception

//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file3.txt");
//            Files.createFile(fileToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectory(dirToCreate);

//            Path directoriesToCreate = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6"  ); // or "Examples\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6"
//            Files.createDirectories(directoriesToCreate);
// Files atributes

            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1\\file1.txt");
            long size = Files.size(filePath);
            System.out.println("File Size = "+ size );
            System.out.println("last modified =" + Files.getLastModifiedTime(filePath));
            System.out.println("Owner =" + Files.getOwner(filePath));

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);

            System.out.println(attrs.size() + " " + attrs.fileKey() + " " + attrs.isRegularFile() + " " + attrs.creationTime() +" "
                    + attrs.isDirectory() +" "+ attrs.isOther() +" "+ attrs.isSymbolicLink() +" "+ attrs.lastAccessTime());

        } catch(IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }

    public static void printFile(Path path){
        try(BufferedReader fileReader = Files.newBufferedReader(path)){
            String line;
            while((line = fileReader.readLine())!= null){
                System.out.println(line);
            }

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}