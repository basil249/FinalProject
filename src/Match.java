//chris

public class Match {

    private Team home, away, winner, loser;
    private boolean isTie, isOverTime, knockout;
    private int homePts, awayPts;
    private int numKicks;
    private int homeScore, awayScore;
    private int OverTimeRounds;

    public Match() {
        home = new Team();
        away = new Team();
        this.numKicks = 5;
        homePts = 0;
        awayPts = 0;
        isTie = false;
        homeScore = 0;
        awayScore = 0;
        isOverTime = false;
        knockout = false;//tells the class if this cant end in a tie
        this.OverTimeRounds = 0;
    }

    public Match(Team home, Team away, boolean knockout) {
        this.home = home;
        this.away = away;
        this.numKicks = 5;
        homePts = 0;
        awayPts = 0;
        homeScore = 0;
        awayScore = 0;
        isTie = false;
        isOverTime = false;
        this.knockout = knockout;//tells the class if this cant end in a tie
        this.OverTimeRounds = 0;
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public int getTotalHomeScore() {
        return homeScore;
    }

    public int getTotalAwayScore() {
        return awayScore;
    }

    public void setHome(Team t) {
        this.home = t;
    }

    public void setAway(Team t) {
        this.away = t;
    }

    public void setNumKicks(int i) {
        this.numKicks = i;
    }

    public int getNumKicks() {
        return this.numKicks;
    }
    //returns the winning team. Or null if it is a tie

    public void playMatch() {
        int temp = home.score(numKicks);
        int temp2 = away.score(numKicks);
        homeScore += temp;
        awayScore += temp2;
        home.setScore(temp);
        away.setScore(temp2);
        decideWinner();
        System.out.println(home.getName() + ": " + homeScore + away.getName() + ": " + awayScore);

    }

    public int getHomePts() {
        return homePts;
    }

    public int getAwayPts() {
        return awayPts;
    }
    //tells you whether the match resulted in a tie

    public boolean isTie() {
        return isTie;
    }

    public boolean hasWinner() {
        if (winner != null) {
            return true;
        }
        return false;
    }

    public boolean hasLoser() {
        if (loser != null) {
            return true;
        }
        return false;
    }
    //returns the winner, or null if there isnt one

    public Team getWinner() {
        if (hasWinner()) {
            return winner;
        }
        return null;
    }
    //returns the loser, or null if there isnt one

    public Team getLoser() {
        if (hasLoser()) {
            return loser;
        }
        return null;
    }
    /**
    * @runOverTime
    * Max Hernandez
    * settles a tie
    * if this is the first roud of overtime it will add extra playtime
    * if the second it does the best out of 5 penalty kicks
    * any rounds after that are sudden death penalty kicks
    */
    public void runOvertime() {
        isOverTime = true;
        if(OverTimeRounds == 1){
            numKicks = 2;
            playMatch();
        }
        else if(OverTimeRounds == 2){
            shootout();
        }
        else{
            finalShootout();
        }
    }
    /**
     * @shootout
     * Max Hernandez
     * settles a tie with the best out of 5 score attempts
    */
    public void shootout(){
        int homeShots = 0;
        int awayShots = 0;
        for(int n = 0; n<5; n++){
            homeShots+=home.score();
            awayShots+=away.score();
        }
        homeScore=homeShots;
        awayScore=awayShots;
        decideWinner();
    }
    
    /**
     * @finalShootout
     * Max Hernandez
     * gives each team one attempt at a penalty kick
     * if only one team makes it they win
     */
    public void finalShootout(){
        boolean noWinner = true;
        while(noWinner){
            boolean homeSuccess = false;
            boolean awaySuccess = false;
            if(home.score() == 1){
                homeSuccess = true;
            }
            if(away.score() == 1){
                awaySuccess = true;
            }
            if(homeSuccess && !awaySuccess){
                homeScore = 1;
                awayScore = 0;
                noWinner = false;
                decideWinner();
            }
            else if(awaySuccess && !homeSuccess){
                homeScore = 0;
                awayScore = 1;
                noWinner = false;
                decideWinner();
            }
        }
    }
    
    public boolean playedOverTime() {
        return isOverTime;
    }
    /**
     * @decideWinner
     * Max Hernandez
     * uses the score to return the winner of the match
     */
    public void decideWinner(){
         if (homeScore > awayScore) {
            winner = home;
            loser = away;
            homePts = 3;
            awayPts = 0;
            isTie = false;
            home.setPoints(homePts);
            away.setPoints(awayPts);
            System.out.println("The " + home.getName() + " have won!");
        } else if (homeScore < awayScore) {
            winner = away;
            awayPts = 3;
            homePts = 0;
            loser = home;
            isTie = false;
            home.setPoints(homePts);
            away.setPoints(awayPts);
            System.out.println("The " + away.getName() + " have won!");
        } else {
            if (knockout == false) {
                System.out.println("Its a tie!");
                home.setPoints(1);
                away.setPoints(1);
                isTie = true;
                winner = null;
                loser = null;
            }
            else{
                this.OverTimeRounds++;
                runOvertime();
            }
        }
    }

}
