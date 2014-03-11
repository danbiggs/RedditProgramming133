package redditprogramming133;

import java.util.ArrayList;
import java.util.Scanner;
public class RedditProgramming133 {

    public static void main(String[] args) {
        
        //Sample Input Line: ID, Room #, I or O, time
        //Sample:             3, 20, I, 540
        
        Scanner StringInput=new Scanner(System.in);
        Scanner intInput=new Scanner(System.in);
        
        
        
        int n=intInput.nextInt();
        
        int[]id=new int[n];
        int[]room=new int[n];
        String[]IO=new String[n];
        int[]time=new int[n];
        
        int[]timeInRoom=new int[100];
        int[]visitorsInRoom=new int[100];
        
        for(int i=0;i<100;i++){
            timeInRoom[i]=0;
            visitorsInRoom[i]=0;
        }
        
        for(int i=0;i<n;i++){
            System.out.println("Input id");
            id[i]=intInput.nextInt();
            System.out.println("Input room");
            room[i]=intInput.nextInt();
            System.out.println("Input IO");
            IO[i]=StringInput.nextLine();
            System.out.println("Input time");
            time[i]=intInput.nextInt();
        }
        
        //this counts the total number of minutes and visitors (not distinguishing unique visits)
        for(int i=0;i<n;i++){
            if(IO[i].equals("I")){
                for(int j=i;j<n;j++){
                    if(IO[j].equals("O")&&id[j]==id[i]&&room[j]==room[i]){
                        timeInRoom[room[i]]+=time[j]-time[i];
                    }
                }
            }
            
            
        }
        
        ArrayList<Integer>bob=new ArrayList<Integer>();
        
        
        for(int i=0;i<100;i++){
            bob.clear();
            bob.add(-1);
            for(int j=0;j<n;j++){
                if(room[j]==i&&IO[j].equals("I")){
                    for(int k=0;k<bob.size();k++){
                        if(bob.get(k)!=i){
                            bob.add(i);
                        }
                    }
                }
            }
            visitorsInRoom[i]=bob.size()-1;
            
        }
        
        for(int i=0;i<100;i++){
            if(visitorsInRoom[i]!=0){
            timeInRoom[i]=timeInRoom[i]/visitorsInRoom[i];
        }
        }
        
        for(int i=0;i<100;i++){
            if(visitorsInRoom[i]!=0){
                System.out.println("Room "+i+", "+timeInRoom[i]+"-minute average visit, "+visitorsInRoom[i]+"total visitors");
            }
        }
        
    }
}
