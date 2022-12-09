import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Movie mv = new Adventure("Star Wars");//!!!!
//        mv.watchMovie();
//        System.out.println();
//
//        Adventure advMv = new Adventure("Time");
//        advMv.watchMovie();
//        System.out.println();
//
//        Comedy comMv = new Comedy("According to Jim");
//        comMv.watchMovie();
//        System.out.println();
//
//        SciFi scMv = new SciFi("Star Wars");
//        scMv.watchMovie();
//        System.out.println();

        Movie theMovie = Movie.getMovie("Adventure", "Indiana Jones");
        theMovie.watchMovie();

        Movie theMovie01 = Movie.getMovie("Comedy", "Friends");
        theMovie01.watchMovie();

        Movie theMovie02 = Movie.getMovie("SciFi", "Independents Day");
        theMovie02.watchMovie();

        Scanner sc = new Scanner(System.in);


        while (true){
            System.out.println("Enter Type (A for Adventure, C fro Comedy and S for SciFi or Q for quit):");
            String type = sc.nextLine();
            if("Qq".contains(type)) break;
            System.out.println("Enter the Title of wander movie: ");
            String title = sc.nextLine();

            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
            }

        }



    }

