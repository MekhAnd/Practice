import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {

//        DirectoryStream.Filter<Path> filter =
//            new DirectoryStream.Filter<Path>() {
//                public boolean accept(Path path) throws IOException {
//                    return Files.isRegularFile(path);
//                }
//            };

        DirectoryStream.Filter<Path> filter = p-> Files.isRegularFile(p);
        Path directory = FileSystems.getDefault().getPath("FileTree"+File.separator +"Dir2");
//        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
                for(Path file: contents){
                    System.out.println(file.getFileName());
                }
            } catch (IOException | DirectoryIteratorException e){
            e.printStackTrace();
        }
        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("myApp", ".apptxt");
            System.out.println("Temp file path = "+ tempFile.toAbsolutePath());
        } catch(IOException e){
            e.printStackTrace();
        }

        Iterable<FileStore> fstore = FileSystems.getDefault().getFileStores();
        for(FileStore fs:fstore){
            System.out.println("------");
            System.out.println(fs);
            System.out.println("name "+fs.name());
            System.out.println("total space " +fs.getTotalSpace());
            System.out.println("BlockSize "+ fs.getBlockSize());
            System.out.println("Type "+ fs.type());

        }

        Iterable<Path> fsroot = FileSystems.getDefault().getRootDirectories();
        for(Path fs:fsroot){
            System.out.println("------");
            System.out.println(fs);
            System.out.println(fs.getFileName());
            System.out.println(fs.toAbsolutePath());

        }
    }
}