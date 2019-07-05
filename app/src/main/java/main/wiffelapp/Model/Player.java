package main.wiffelapp.Model;

import android.support.annotation.Nullable;

/**
 * Player class
 * @author Ryan Bryla
 * contains player data for game or overall stats
 */

public class Player {
    public final String NAME;
    public final int PLAYER_NUMBER;
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

    public Player(String NAME, int PLAYER_NUMBER, int hits, int singles, int doubles,
                  int triples, int homeRuns, int grandSlams, int groundRollDoubles, int squantos, int rbis, int wins, int outs) {
        this.NAME = NAME;
        this.PLAYER_NUMBER = PLAYER_NUMBER;
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
        return -1;
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


    public void addSingle() {
        this.singles += 1;
    }

    public void addDouble() {
        this.doubles += 1;
    }

    public void addTriple() {
        this.triples += 1;
    }

    public void addHomeRun() {
        this.homeRuns += 1;
    }

    public void addGrandSlam() {
        this.grandSlams += 1;
    }

    public void addGroundRollDouble() {
        this.groundRollDoubles += 1;
    }

    public void addSquanto() {
        this.squantos += 1;
    }

    public void addRbis(int rbis) {
        this.rbis = rbis;
    }

    public void addWin() {
        this.wins += 1;
    }

    public void addOut() {
        this.outs += 1;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Player)) return false;
        Player other = (Player) obj;
        return this.NAME.equals(other.NAME) && (this.PLAYER_NUMBER == other.PLAYER_NUMBER);
    }
}
