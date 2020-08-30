import java.util.*;
import java.lang.*;

class priorityProcess implements Comparable<priorityProcess>{
    public int at,bt,priority;
           String s;
           int[] waitingT;
            int turnaround=0;

           public priorityProcess(int n)
           {
               waitingT=new int[n];
           }
           public priorityProcess(String s,int at,int bt,int priority){
               this.at=at;
               this.bt=bt;
               this.s=s;
               this.priority=priority;
           }
           int getAt(){
               return at;
           }
           int getBt(){
               return bt;
           }
           int getPriority(){
               return priority;
           }
           public int compareTo(priorityProcess o) {
            return this.priority - o.getPriority();
            }
           public void waitingTime(priorityProcess[] p)
           {
            
            int wait,total=0,totAvg=0;
            for(int i=0;i<p.length;i++)
            {
                if(i==0)
                {
                    wait=p[i].getAt()-p[i].getAt();
                    total=p[i].getAt()+p[i].getBt();
                }
                else
                {
                    wait=total-p[i].getAt();
                    total+=p[i].getBt();
                }
                waitingT[i]=wait;
                System.out.println("Waiting time for process "+p[i].s+" is "+wait);
                totAvg+=wait;
            }
            System.out.println("Average Waiting time is: "+getAvgWaitingTime(totAvg,p.length));
        }
        float getAvgWaitingTime(int tot,int len)
        {
            return (float)tot/len;
        }
        public void turnaroundTime(int[] wai,priorityProcess[] p){
            int totTurn=0;
            for (int i = 0; i < p.length; i++) {
                turnaround=wai[i]+p[i].getBt();
                //System.out.println(turnaround);
                totTurn+=turnaround;
            }
            System.out.println("Average turnaround time is:"+getAvgTurnaroundTime(totTurn, p.length));
        }
        float getAvgTurnaroundTime(int turn,int no){
            return (float)turn/no;
        }
}
public class priority{
    
    public static void main(String args[]) {
        int n,at,bt,priority;
        int arr[];
        String s;
        System.out.println("Enter number of process in the system?\n");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        priorityProcess[] p=new priorityProcess[n];
        priorityProcess p1=new priorityProcess(n);
        for (int i = 0; i < p.length; i++) {
            System.out.println("Enter name of process:\n");
            s=sc.next();
            System.out.println("Enter arrival time of process\n");
            at=sc.nextInt();
            System.out.println("Enter burst time of process\n");
            bt=sc.nextInt();
            System.out.println("Enter priority of process");
            priority=sc.nextInt();

            p[i]=new priorityProcess(s, at, bt,priority);
        }
        Arrays.sort(p);
        /*for(int i=0;i<n;i++)
        {
            System.out.println("Arrival Time "+f[i].getAt()+"\tBurst Time "+f[i].getBt());
        }
        */
        p1.waitingTime(p);
        /*arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=f1.waitingT[i];
        }*/
        p1.turnaroundTime(p1.waitingT, p);
    }
}

