import java.util.*;

import java.lang.*;

class Fcfs implements Comparable<Fcfs>{
    public String s;
            int at,bt;
            int[] waitingT;
            int turnaround=0;
        public Fcfs(int n)
        {
            waitingT=new int[n];
        }
        public Fcfs(String s,int at,int bt){
            this.at=at;
            this.bt=bt;
            this.s=s;
        }
        int getAt(){
            return at;
        }
        int getBt(){
            return bt;
        }
        public int compareTo(Fcfs o) {
            return this.at - o.getAt();
        }
        public void waitingTime(Fcfs[] f)
        {
            
            int wait,total=0,totAvg=0;
            for(int i=0;i<f.length;i++)
            {
                if(i==0)
                {
                    wait=f[i].getAt()-f[i].getAt();
                    total=f[i].getAt()+f[i].getBt();
                }
                else
                {
                    wait=total-f[i].getAt();
                    total+=f[i].getBt();
                }
                waitingT[i]=wait;
                System.out.println("Waiting time for process "+f[i].s+" is "+wait);
                totAvg+=wait;
            }
            System.out.println("Average Waiting time is: "+getAvgWaitingTime(totAvg,f.length));
        }
        float getAvgWaitingTime(int tot,int len)
        {
            return (float)tot/len;
        }
        public void turnaroundTime(int[] wai,Fcfs[] f){
            int totTurn=0;
            for (int i = 0; i < f.length; i++) {
                turnaround=wai[i]+f[i].getBt();
                //System.out.println(turnaround);
                totTurn+=turnaround;
            }
            System.out.println("Average turnaround time is:"+getAvgTurnaroundTime(totTurn, f.length));
        }
        float getAvgTurnaroundTime(int turn,int no){
            return (float)turn/no;
        }
}
public class fcf{
    
    public static void main(String args[]) {
        int n,at,bt;
        int arr[];
        String s;
        System.out.println("Enter number of process in the system?\n");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        Fcfs[] f=new Fcfs[n];
        Fcfs f1=new Fcfs(n);
        for (int i = 0; i < f.length; i++) {
            System.out.println("Enter name of process:\n");
            s=sc.next();
            System.out.println("Enter arrival time of process\n");
            at=sc.nextInt();
            System.out.println("Enter burst time of process\n");
            bt=sc.nextInt();

            f[i]=new Fcfs(s, at, bt);
        }
        Arrays.sort(f);
        /*for(int i=0;i<n;i++)
        {
            System.out.println("Arrival Time "+f[i].getAt()+"\tBurst Time "+f[i].getBt());
        }
        */
        f1.waitingTime(f);
        /*arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=f1.waitingT[i];
        }*/
        f1.turnaroundTime(f1.waitingT, f);
    }
}
