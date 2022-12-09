public class NextMain {
    public static void main(String[] args) {
        Movie movie = Movie.getMovie("a", "Jaws");
        movie.watchMovie();

        Adventure adventure = (Adventure) Movie.getMovie("A", "Jaws");
        adventure.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchComedy();

        var airplane = Movie.getMovie("c", "Airplane");  /// !!!!!!!!!!!!!!!!!!!!!!!!!!!
        airplane.watchMovie();

        var plane = new Comedy("Airplane");
        plane.watchComedy();
//        plane.watchMovie();

        Object unknownObject = Movie.getMovie("S", "Airplane");
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if(unknownObject instanceof Adventure){
            ((Adventure)unknownObject).watchAdventure();
        } else if(unknownObject instanceof SciFi syfy){
            syfy.watchSciFi();
        }

    }


}
