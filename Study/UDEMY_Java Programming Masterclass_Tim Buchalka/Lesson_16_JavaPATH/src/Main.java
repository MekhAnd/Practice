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
//
//        try {
//            Path tempFile = Files.createTempFile("myApp", ".apptxt");
//            System.out.println("Temp file path = "+ tempFile.toAbsolutePath());
//        } catch(IOException e){
//            e.printStackTrace();
//        }
//
//        Iterable<FileStore> fstore = FileSystems.getDefault().getFileStores();
//        for(FileStore fs:fstore){
//            System.out.println("------");
//            System.out.println(fs);
//            System.out.println("name "+fs.name());
//            System.out.println("total space " +fs.getTotalSpace());
//            System.out.println("BlockSize "+ fs.getBlockSize());
//            System.out.println("Type "+ fs.type());
//
//        }
//
//        Iterable<Path> fsroot = FileSystems.getDefault().getRootDirectories();
//        for(Path fs:fsroot){
//            System.out.println("------");
//            System.out.println(fs);
//            System.out.println(fs.getFileName());
//            System.out.println(fs.toAbsolutePath());
//
//        }

        System.out.println(" ____ WALKING TREE FOR DIR2 ____");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

        System.out.println("___COPY DIR2 to DIR4/DIR2COPY____");
        Path copyPath = FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir4"+File.separator+"Dir2Copy");

        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

//        NIO IO
        File file = new File("G:\\git\\Practice\\Study\\UDEMY_Java Programming Masterclass_Tim Buchalka\\Lesson_16_JavaPATH\\Examples\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("\\Examples");
        File resolvedFile = new File(parent, "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("\\Examples", "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("\\Examples");
        Path childPath = Paths.get("\\dir\\file.txt");

        System.out.println(parentPath.resolve(childPath));

        File workingDir = new File ("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDir.getAbsoluteFile());

        System.out.println("_____ print Dir1 contents using lists()______");
        File dir2File = new File(workingDir, "\\FileTree\\Dir2");
        System.out.println(dir2File);
        String [] dir2Contents = dir2File.list();
        for (int i = 0; i<dir2Contents.length; i++){

            System.out.println("i = " + dir2Contents[i]);
        }

        System.out.println("++++++ Print Dir2 using listFilese()");
        File [] dir2FilesContents = dir2File.listFiles();
        for (int i = 0; i<dir2FilesContents.length; i++){

            System.out.println("i = " + dir2FilesContents[i]);
            System.out.println("i = " + dir2FilesContents[i].getName());
        }
    }
}