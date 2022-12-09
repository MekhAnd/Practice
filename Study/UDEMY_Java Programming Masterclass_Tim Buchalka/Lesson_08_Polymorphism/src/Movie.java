import java.sql.SQLOutput;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie() {
        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");
    }

    public static Movie getMovie(String type, String title) {
        return switch (type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case  'C' -> new Comedy(title);
            case 'S'-> new SciFi(title);
            default -> new Movie(title);
        };
    }
}

class Adventure extends Movie {

    private String title;

    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("... %s%n".repeat(3), "Pleasant Scene", "Scary Music", "Something Bad Happens");
    }

    public void watchAdventure(){
        System.out.println("Watching an Adventure!");
    }
}

class SciFi extends Movie {

    private String title;

    public SciFi(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("... %s%n".repeat(3),
                "Bad Aliens do Bad Stuff", "Space Guys Chase Aliens", "Planet Blows Up");
    }

    public void watchSciFi(){
        System.out.println("Watching a SciFi!");
    }

}

class Comedy extends Movie {

    private String title;

    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("... %s%n".repeat(3),
                "Something Funny Happens", "Something Even Funnier Happens", "Happy End");
    }

    public void watchComedy(){
        System.out.println("Watching a Comedy!");
    }

}