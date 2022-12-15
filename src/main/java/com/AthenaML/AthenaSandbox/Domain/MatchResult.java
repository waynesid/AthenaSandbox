package com.AthenaML.AthenaSandbox.Domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

/**
 * @author Wayne Sidney
 * Created on {14/12/2022}
 */


@Table(name = "matchResults")
@Entity
public class MatchResult {

    @Id
    @Column(name="id")
    private long id;

    @Column(name="country")
    private String country;

    @Column(name="league")
    private String league;

    @Column(name="season")
    private String season;

    @Temporal(TemporalType.DATE)
    private String date;

    @Temporal(TemporalType.TIME)
    private String time;

    @Column(name="Home")
    private int home;
    @Column(name="Away")
    private String away;

    @Column(name="HG")
    private int homeGoals;

    @Column(name="AG")
    private int awayGoals;
    @Column(name="RESULT")
    private String result;
    @Column(name="PH")
    private int pHomeOdds;

    @Column(name="PD")
    private int pDrawOdds;
    @Column(name="PA")
    private int pAwayOdds;
    @Column(name="maxH")
    private int maxHomeWinOdds;

    @Column(name="maxD")
    private int maxDrawOdds;

    @Column(name="maxA")
    private int maxAwayOdds;

    @Column(name="avgH")
    private int avgHomeOdds;

    @Column(name="avgD")
    private int avgDrawOdds;

    @Column(name="avgA")
    private int avgAwayOdds;

    public MatchResult(long id, String country, String league, String season, String date, String time, String home, String away, String homeGoals, String awayGoals, String result, String pHomeOdds, String pDrawOdds, String pAwayOdds, String maxHomeWinOdds, String maxDrawOdds, String maxAwayOdds, String avgHomeOdds, String avgDrawOdds, String avgAwayOdds) {
        this.id = id;
        this.country = country;
        this.league = league;
        this.season = season;
        this.date = date;
        this.time = time;
        this.home = Integer.parseInt(home);
        this.away = away;
        this.homeGoals = Integer.parseInt(homeGoals);
        this.awayGoals = Integer.parseInt(awayGoals);
        this.result = result;
        this.pHomeOdds = Integer.parseInt(pHomeOdds);
        this.pDrawOdds = Integer.parseInt(pDrawOdds);
        this.pAwayOdds = Integer.parseInt(pAwayOdds);
        this.maxHomeWinOdds = Integer.parseInt(maxHomeWinOdds);
        this.maxDrawOdds = Integer.parseInt(maxDrawOdds);
        this.maxAwayOdds = Integer.parseInt(maxAwayOdds);
        this.avgHomeOdds = Integer.parseInt(avgHomeOdds);
        this.avgDrawOdds = Integer.parseInt(avgDrawOdds);
        this.avgAwayOdds = Integer.parseInt(avgAwayOdds);
    }

    public MatchResult() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getpHomeOdds() {
        return pHomeOdds;
    }

    public void setpHomeOdds(int pHomeOdds) {
        this.pHomeOdds = pHomeOdds;
    }

    public int getpDrawOdds() {
        return pDrawOdds;
    }

    public void setpDrawOdds(int pDrawOdds) {
        this.pDrawOdds = pDrawOdds;
    }

    public int getpAwayOdds() {
        return pAwayOdds;
    }

    public void setpAwayOdds(int pAwayOdds) {
        this.pAwayOdds = pAwayOdds;
    }

    public int getMaxHomeWinOdds() {
        return maxHomeWinOdds;
    }

    public void setMaxHomeWinOdds(int maxHomeWinOdds) {
        this.maxHomeWinOdds = maxHomeWinOdds;
    }

    public int getMaxDrawOdds() {
        return maxDrawOdds;
    }

    public void setMaxDrawOdds(int maxDrawOdds) {
        this.maxDrawOdds = maxDrawOdds;
    }

    public int getMaxAwayOdds() {
        return maxAwayOdds;
    }

    public void setMaxAwayOdds(int maxAwayOdds) {
        this.maxAwayOdds = maxAwayOdds;
    }

    public int getAvgHomeOdds() {
        return avgHomeOdds;
    }

    public void setAvgHomeOdds(int avgHomeOdds) {
        this.avgHomeOdds = avgHomeOdds;
    }

    public int getAvgDrawOdds() {
        return avgDrawOdds;
    }

    public void setAvgDrawOdds(int avgDrawOdds) {
        this.avgDrawOdds = avgDrawOdds;
    }

    public int getAvgAwayOdds() {
        return avgAwayOdds;
    }

    public void setAvgAwayOdds(int avgAwayOdds) {
        this.avgAwayOdds = avgAwayOdds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return id == that.id && home == that.home && homeGoals == that.homeGoals && awayGoals == that.awayGoals && result == that.result && pHomeOdds == that.pHomeOdds && pDrawOdds == that.pDrawOdds && pAwayOdds == that.pAwayOdds && maxHomeWinOdds == that.maxHomeWinOdds && maxDrawOdds == that.maxDrawOdds && maxAwayOdds == that.maxAwayOdds && avgHomeOdds == that.avgHomeOdds && avgDrawOdds == that.avgDrawOdds && avgAwayOdds == that.avgAwayOdds && Objects.equals(country, that.country) && Objects.equals(league, that.league) && Objects.equals(season, that.season) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(away, that.away);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, league, season, date, time, home, away, homeGoals, awayGoals, result, pHomeOdds, pDrawOdds, pAwayOdds, maxHomeWinOdds, maxDrawOdds, maxAwayOdds, avgHomeOdds, avgDrawOdds, avgAwayOdds);
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", league='" + league + '\'' +
                ", season=" + season +
                ", date=" + date +
                ", time=" + time +
                ", home=" + home +
                ", away=" + away +
                ", homeGoals=" + homeGoals +
                ", awayGoals=" + awayGoals +
                ", result=" + result +
                ", pHomeOdds=" + pHomeOdds +
                ", pDrawOdds=" + pDrawOdds +
                ", pAwayOdds=" + pAwayOdds +
                ", maxHomeWinOdds=" + maxHomeWinOdds +
                ", maxDrawOdds=" + maxDrawOdds +
                ", maxAwayOdds=" + maxAwayOdds +
                ", avgHomeOdds=" + avgHomeOdds +
                ", avgDrawOdds=" + avgDrawOdds +
                ", avgAwayOdds=" + avgAwayOdds +
                '}';
    }
}

