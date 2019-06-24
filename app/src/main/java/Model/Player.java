package Model;

/**
 * Player class
 * @author Ryan Bryla
 * contains player data for game or overall stats
 */

public class Player {
    public final String NAME;
    public final int PLAYER_NUMBER;
    private int atBats;
    private int hits;
    private int singles;
    private int doubles;
    private int triples;
    private int homeRuns;
    private int grandSlams;
    private int groundRollDoubles;
    private int squantos;
    private int rbis;
    private int wins;
    private int outs;

    public Player(String NAME, int PLAYER_NUMBER, int atBats, int hits, int singles, int doubles,
                  int triples, int homeRuns, int grandSlams, int groundRollDoubles, int squantos, int rbis, int wins, int outs) {
        this.NAME = NAME;
        this.PLAYER_NUMBER = PLAYER_NUMBER;
        this.atBats = atBats;
        this.hits = hits;
        this.singles = singles;
        this.doubles = doubles;
        this.triples = triples;
        this.homeRuns = homeRuns;
        this.grandSlams = grandSlams;
        this.groundRollDoubles = groundRollDoubles;
        this.squantos = squantos;
        this.rbis = rbis;
        this.wins = wins;
        this.outs = outs;
    }

    public Player(String NAME, int PLAYER_NUMBER) {
        this.NAME = NAME;
        this.PLAYER_NUMBER = PLAYER_NUMBER;
        this.atBats = 0;
        this.hits = 0;
        this.singles = 0;
        this.doubles = 0;
        this.triples = 0;
        this.homeRuns = 0;
        this.grandSlams = 0;
        this.groundRollDoubles = 0;
        this.squantos = 0;
        this.rbis = 0;
        this.wins = 0;
        this.outs = 0;
    }


    public int basesReached() {
        return this.singles + this.doubles*2 + this.triples*3 +
                this.homeRuns*4 + this.grandSlams*4 + this.groundRollDoubles*2 + this.squantos;
    }

    public int getAtBats() {
        return atBats;
    }

    public int getHits() {
        return hits;
    }

    public int getSingles() {
        return singles;
    }

    public int getDoubles() {
        return doubles;
    }

    public int getTriples() {
        return triples;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public int getGrandSlams() {
        return grandSlams;
    }

    public int getSquantos() {
        return squantos;
    }

    public int getRbis() {
        return rbis;
    }

    public int getWins() {
        return wins;
    }

    public int getOuts() {
        return outs;
    }

    public void setAtBats(int atBats) {
        this.atBats = atBats;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setSingles(int singles) {
        this.singles = singles;
    }

    public void setDoubles(int doubles) {
        this.doubles = doubles;
    }

    public void setTriples(int triples) {
        this.triples = triples;
    }

    public void setHomeRuns(int homeRuns) {
        this.homeRuns = homeRuns;
    }

    public void setGrandSlams(int grandSlams) {
        this.grandSlams = grandSlams;
    }

    public void setSquantos(int squantos) {
        this.squantos = squantos;
    }

    public void setRbis(int rbis) {
        this.rbis = rbis;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }

}
