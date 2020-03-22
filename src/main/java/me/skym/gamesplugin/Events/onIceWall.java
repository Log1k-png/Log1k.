package me.skym.gamesplugin.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.ArrayList;
import static org.bukkit.Bukkit.getServer;

public class onIceWall implements Listener {
    private static ArrayList<Location> wall = new ArrayList<>();
    private static Location oLoc;

    private void createBlockFromO(int x, int y, int z){
        Location loc = new Location(getServer().getWorld("world"),oLoc.getX(),oLoc.getY(),oLoc.getZ());
        loc.add(x,y,z);
        wall.add(loc);
    }

    private void createBlockFromOreverse(int x, int y, int z){
        Location loc = new Location(getServer().getWorld("world"),oLoc.getX(),oLoc.getY(),oLoc.getZ());
        loc.add(z,y,x);
        wall.add(loc);
    }

    private void createWallSide(int u, int n){
        int o;
        int i;
        if (n==1){
            for(o = 0;o <= 2; o++){
                for(i = 1;i <= 3; i++){
                    createBlockFromO(u*i,o,0);
                }
            }
            o = 1;
            createBlockFromO(u*o,3,0);
            createBlockFromO(u*o,4,0);
            o++;
            createBlockFromO(u*o,3,0);
        }

        else if(n==-1){
            for(o = 0;o <= 2; o++){
                for(i = 1;i <= 3; i++){
                    createBlockFromO(0, o,u*i);
                }
            }
            o = 1;
            createBlockFromO(0,3,u*o);
            createBlockFromO(0,4,u*o);
            o++;
            createBlockFromO(0,3,u*o);
        }
    }

    private void createSmallWall(int u, int n){
        if(n==1){
            createBlockFromO(u,0,0);
            createBlockFromO(u,1,0);
            createBlockFromO(u,2,0);
            createBlockFromO(u,3,0);

            createBlockFromO(u,0,1);
            createBlockFromO(u,1,1);

            createBlockFromO(u,0,-1);
            createBlockFromO(u,1,-1);
        }
        else if(n==-1){
            createBlockFromO(0,0,u);
            createBlockFromO(0,1,u);
            createBlockFromO(0,2,u);
            createBlockFromO(0,3,u);

            createBlockFromO(1,0,u);
            createBlockFromO(1,1,u);

            createBlockFromO(-1,0,u);
            createBlockFromO(-1,1,u);
        }
    }

    private void createWall(String orientation){
        switch(orientation){
            case "south":
                wall.add(oLoc);
                createBlockFromO(0,1,0);
                createBlockFromO(0,2,0);
                createBlockFromO(0,3,0);
                createBlockFromO(0,4,0);
                createWallSide(1,1);
                createWallSide(-1,1);
                createSmallWall(1,-1);
                break;
            case "north":
                wall.add(oLoc);
                createBlockFromO(0,1,0);
                createBlockFromO(0,2,0);
                createBlockFromO(0,3,0);
                createBlockFromO(0,4,0);
                createWallSide(1,1);
                createWallSide(-1,1);
                createSmallWall(-1,-1);
                break;
            case "west":
                wall.add(oLoc);
                createBlockFromO(0,1,0);
                createBlockFromO(0,2,0);
                createBlockFromO(0,3,0);
                createBlockFromO(0,4,0);
                createWallSide(1,-1);
                createWallSide(-1,-1);
                createSmallWall(-1,1);
                break;
            case "east":
                wall.add(oLoc);
                createBlockFromO(0,1,0);
                createBlockFromO(0,2,0);
                createBlockFromO(0,3,0);
                createBlockFromO(0,4,0);
                createWallSide(1,-1);
                createWallSide(-1,-1);
                createSmallWall(1,1);
                break;
            case "northeast":
                wall.add(oLoc);
                createDiagWall(1,1);
                break;
            case "southeast":
                wall.add(oLoc);
                createDiagWall(-1,1);
                break;
            case "southwest":
                wall.add(oLoc);
                createDiagWall(1,-1);
                break;
            case "northwest":
                wall.add(oLoc);
                int u = -1;
                for(int i =0;i<3;i++){
                    createBlockFromO(u*1,i,0);
                    createBlockFromO(u*2,i,1);
                    createBlockFromO(u*3,i,2);

                    createBlockFromO(u*0,i,-1);
                    createBlockFromO(u*-1,i,-2);
                    createBlockFromO(u*-2,i,-3);
                }

                createBlockFromO(u*1,3,0);
                createBlockFromO(u*2,3,1);
                createBlockFromO(u*0,3,-1);
                createBlockFromO(u*-1,3,-2);

                createBlockFromO(u*1,4,0);
                createBlockFromO(u*0,4,-1);

                for(int i=0;i<2;i++){
                    createBlockFromO(u*2,i,0);
                    createBlockFromO(u*1,i,-1);
                    createBlockFromO(u*0,i,-2);
                }

                createBlockFromO(u*1,2,-1);
                createBlockFromO(u*1,3,-1);
                break;
        }
    }

    private void createDiagWall(int u, int n){
        if(n==1){
            for(int i =0;i<3;i++){
                createBlockFromO(1,i,u*0);
                createBlockFromO(2,i,u*1);
                createBlockFromO(3,i,u*2);

                createBlockFromO(0,i,u*-1);
                createBlockFromO(-1,i,u*-2);
                createBlockFromO(-2,i,u*-3);
            }

            createBlockFromO(1,3,u*0);
            createBlockFromO(2,3,u*1);
            createBlockFromO(0,3,u*-1);
            createBlockFromO(-1,3,u*-2);

            createBlockFromO(1,4,u*0);
            createBlockFromO(0,4,u*-1);

            for(int i=0;i<2;i++){
                createBlockFromO(2,i,u*0);
                createBlockFromO(1,i,u*-1);
                createBlockFromO(0,i,u*-2);
            }

            createBlockFromO(1,2,u*-1);
            createBlockFromO(1,3,u*-1);
        }

        else if(n==-1){
            for(int i =0;i<3;i++){
                createBlockFromOreverse(1,i,u*0);
                createBlockFromOreverse(2,i,u*1);
                createBlockFromOreverse(3,i,u*2);

                createBlockFromOreverse(0,i,u*-1);
                createBlockFromOreverse(-1,i,u*-2);
                createBlockFromOreverse(-2,i,u*-3);
            }

            createBlockFromOreverse(1,3,u*0);
            createBlockFromOreverse(2,3,u*1);
            createBlockFromOreverse(0,3,u*-1);
            createBlockFromOreverse(-1,3,u*-2);

            createBlockFromOreverse(1,4,u*0);
            createBlockFromOreverse(0,4,u*-1);

            for(int i=0;i<2;i++){
                createBlockFromOreverse(2,i,u*0);
                createBlockFromOreverse(1,i,u*-1);
                createBlockFromOreverse(0,i,u*-2);
            }

            createBlockFromOreverse(1,2,u*-1);
            createBlockFromOreverse(1,3,u*-1);
        }
    }

    public static void removeWall(){
        for(Location loc : wall){
            if(loc.getBlock().getType()==Material.ICE){
                loc.getBlock().setType(Material.AIR);
            }
            oLoc.getBlock().setType(Material.AIR);
        }
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent e){
        wall.clear();


        //methods that create the wall
        Player p = e.getPlayer();
        Block b = e.getBlock();
        oLoc = b.getLocation();

        PotionEffect tired = new PotionEffect(PotionEffectType.SLOW,100,0,true,false);
        p.addPotionEffect(tired);

        if (b.getType().equals(Material.BLUE_ICE)){
            //getting the orientation of the wall
            String orientation ="none";
            Location bLoc = b.getLocation();
            Location pLoc = p.getLocation();
            int xDiff = bLoc.getBlockX() - pLoc.getBlockX();
            int zDiff = bLoc.getBlockZ() - pLoc.getBlockZ();
            int xzDiff = Math.abs(xDiff)-Math.abs(zDiff);

            if(xzDiff < 0){
                if(zDiff < 0){
                    orientation = "north";
                }
                else if(zDiff > 0){
                    orientation = "south";
                }
            }
            else if(xzDiff > 0){
                if(xDiff < 0){
                    orientation = "west";
                }
                else if(xDiff > 0){
                    orientation = "east";
                }
            }
            else if(xzDiff == 0){
                if(xDiff < 0 & zDiff < 0){
                    orientation = "northwest";
                }
                else if(xDiff > 0 & zDiff > 0){
                    orientation = "southeast";
                }
                else if(xDiff > 0 & zDiff < 0){
                    orientation = "northeast";
                }
                else if(xDiff < 0 & zDiff > 0){
                    orientation = "southwest";
                }
            }

            createWall(orientation);

            //set wall on map
            for(Location loc : wall){
                if(loc.getBlock().getType()==Material.AIR){
                    loc.getBlock().setType(Material.ICE);
                }
                bLoc.getBlock().setType(Material.ICE);
            }

        }
    }
}
