package me.skym.gamesplugin;

import org.bukkit.Location;

import java.util.ArrayList;

public class Map {
    private String name;
    private ArrayList<Location> spawns;

    public Map(String name) {
        this.name = name.toLowerCase();
        spawns = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Location> getSpawns() {
        return spawns;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpawns(ArrayList<Location> spawns) {
        this.spawns = spawns;
    }

    public void addSpawn(Location loc) {
        spawns.add(loc);
    }

    public Location getSpawnAt(int i){
        if(i < numberOfSpawn() ){
            return spawns.get(i);
        }
        else {
            System.out.println("Map Error : Out of Spawns length");
            return null;
        }
    }

    public int numberOfSpawn(){
        int numberOfSpawn = 0;
        for(Location loc : spawns){
            numberOfSpawn++;
        }
        return numberOfSpawn;
    }
}
