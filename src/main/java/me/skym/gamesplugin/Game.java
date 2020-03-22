package me.skym.gamesplugin;

import me.skym.gamesplugin.Role.Role;

import java.util.ArrayList;

public class Game {
    private ArrayList<Fighter> fighters;
    private boolean isLive;
    private Map map;

    public Game() {
        this.fighters = new ArrayList<>();
        this.isLive = false;
    }

    public void chooseRole(String playerName, Role role){
        for(Fighter fighter : fighters){
            if(fighter.getName().equalsIgnoreCase(playerName)){
                fighter.setRole(role);
            }
        }
    }

    public Role getRole(String playerName){
        for(Fighter fighter : fighters){
            if(fighter.getName().equalsIgnoreCase(playerName)){
                return fighter.getRole();
            }
        }
        return null;
    }

    public void removePlayer(String playerName){
        int index = -1;
        for(Fighter fighter : fighters){
            if(fighter.getName().equalsIgnoreCase(playerName)){
                index = fighters.indexOf(fighter);
            }
        }
        if (index != -1){
            fighters.remove(index);
        }
    }

    public ArrayList<Fighter> getFighters() {
        return fighters;
    }

    public void addPlayer(Fighter name){
        fighters.add(name);
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public boolean isPlaying(String name){
        boolean isPlaying = false;
        for (Fighter fighter : fighters){
            if(fighter.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return isPlaying;
    }

    public boolean isLive(){
        return this.isLive;
    }

    public void setStatus(boolean status){
        this.isLive = status;
    }

}
