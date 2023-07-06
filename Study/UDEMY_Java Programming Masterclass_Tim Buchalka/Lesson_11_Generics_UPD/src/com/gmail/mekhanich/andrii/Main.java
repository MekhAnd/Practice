package com.gmail.mekhanich.andrii;

interface Player {
    String name();
}

record BaseballPlayer (String name, String position) implements Player {}
record FootballPlayer(String name, String position) implements Player {}
record VolleyballPlayer(String name, String position) implements Player {}

public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("city", "Philadelphia, PA", "US");
        BaseballTeam philliies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");

        scoreResult(philliies1, 3, astros1, 5);

//*******************************************************************

        SportsTeam philliies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");

        scoreResult(philliies2, 3, astros2, 5);

//*******************************************************************

        Team <BaseballPlayer, Affiliation> philliies = new Team <>("Philadelphia Phillies", philly);
        Team <BaseballPlayer, Affiliation> astros = new Team<>("Houston Astros", philly);

        scoreResult(philliies, 3, astros, 5);


        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        var guthrie = new BaseballPlayer("D. Guthrie", "Center Fielder");

        philliies.addTeamMember(guthrie);
        philliies.addTeamMember(harper);
        philliies.addTeamMember(marsh);
        philliies.listTeamMembers();

        SportsTeam afc1 = new SportsTeam("Adelaide Crowws");
        Team <FootballPlayer, String>afc = new Team<>("Adelaide Crowws", "City of Adelaide, South Austrlia, in Australia");
        var tex = new FootballPlayer("T Walker", "Center half forward");
        afc.addTeamMember(tex);
        var rory = new FootballPlayer("R Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team <VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts", "Setter") );
        adelaide.listTeamMembers();

        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heart");
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        scoreResult(canberra, 0, adelaide, 1);

//        Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");
    }

    public static void scoreResult (SportsTeam team1, int t1Score, SportsTeam team2, int t2Score){
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score,t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult (BaseballTeam team1, int t1Score, BaseballTeam team2, int t2Score){
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score,t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult (Team team1, int t1Score, Team team2, int t2Score){
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score,t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
