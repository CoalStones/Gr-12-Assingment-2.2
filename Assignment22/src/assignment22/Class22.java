package assignment22;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Class22 {
    public static ArrayList<String> names=new ArrayList<String>();
    public static ArrayList<Integer> marks=new ArrayList<Integer>();
    
    public void entire(){
        gather();
        insertionSort();
        namesAndScores();
        average();
        median();
        mode();
    }
    
    private void namesAndScores(){
        for(int count=0; count<marks.size(); count++){
            System.out.format("%-8s %-3s \n",names.get(count),marks.get(count));
        }
    }
    
    private void gather(){
        Scanner input=new Scanner(System.in);
        String sUin,sHolder; int iUin=0; boolean finish=false;
        System.out.println("Enter -1 in place of the name or mark to end adding items");
        //taking in the marks and names
        while(!finish){
            //taking in the name
            System.out.println("Enter a name");
                sUin=input.nextLine();
                if(sUin.equals("-1"))break;
                    names.add(sUin);
                    //taking in the mark
            System.out.println("Enter a mark");
                sHolder=input.nextLine();
            if(sHolder.equals("-1"))finish=true;
                iUin=Integer.parseInt(sHolder);
                //if a mark is not in the range, it takes it in again
                while(iUin>100||iUin<-2){
                    System.out.println("Incorrect item added, please enter a mark between 0-100");
                    iUin=input.nextInt();
                }
                    marks.add(iUin);
        }
    }
    
    private void average(){
        int total=0;
        //adds all the elements in the marks array then divides by the array size
        for(int count=0; count<marks.size(); count++){
            total+=marks.get(count);
        }
        System.out.format("The average mark is %.1f",(double)total/marks.size());
        //System.out.format doesn't end the line and i don't want to add \n so this line is needed. The % sign also looks nice
        System.out.println("%");
    }
    
    private void median(){
        //the sort is needed to put the elements in order for the median
        int pos;
        if(marks.size()%2==0){
            pos=(marks.size()/2)-1;
            //median mark
            System.out.format("The median mark is %.1f",(double)(marks.get(pos)+marks.get(pos+1))/2);
            System.out.println("%");
            //person 1 and their mark
            System.out.print("It was between "+names.get(pos)+" with a mark of "+marks.get(pos));
            //person 2 and their mark
            System.out.println(" and "+names.get(pos+1)+" with a mark of "+marks.get(pos+1));
        }
        if(marks.size()%2!=0){
            pos=(marks.size()/2);
            System.out.println(names.get(pos)+" got the median mark of "+marks.get(pos));
        }
        
    }
    private void insertionSort(){
        //taken from the note on the insertion sort
        int iHolder;
        for(int count=0; count<marks.size(); count++){
            iHolder=count;
            //while the counter is greater than 0 and the marks at the counter are greater than 0 swap
            //the positions of marks and names
            while(iHolder>0&&marks.get(iHolder).compareTo(marks.get(iHolder+1))>0){
                Collections.swap(marks,iHolder,iHolder-1);
                Collections.swap(names,iHolder,iHolder-1);
                iHolder--;
            }
        }
    }
    
    private void mode(){
        int[] numHolder=new int[101];
        int most=0,iHolder=0,otherHolder=0;
        String markHolder="";
        for(int count=0; count<marks.size(); count++){
            numHolder[marks.get(count)]++;
        }
        for(int count=0; count<numHolder.length; count++){
            if(most<numHolder[count]&&numHolder[count]>1){
                most=numHolder[count];
                iHolder=count;
            }
        }
        if(most==0)System.out.println("There is no mode");
        else System.out.print("The mode(s) are "+iHolder);
        
        for(int count=0; count<numHolder.length; count++){
            if(most==numHolder[count]&&count!=iHolder&&iHolder>1)System.out.print(", "+count);
        }
        System.out.println();
        if(iHolder>1){
            System.out.print("The people who achieved the mode of "+iHolder+" are ");
                for(int count=0; count<names.size(); count++){
                if(marks.get(count)==iHolder)System.out.print(names.get(count)+", ");
            }
            System.out.println();
        
        for(int count=0; count<numHolder.length; count++){
            if(most==numHolder[count]&&iHolder!=count){
                otherHolder=count;
                System.out.print("The people who achieved the mode of "+otherHolder+" are ");
                for(int i=0; i<names.size(); i++){
                if(marks.get(i)==otherHolder)System.out.print(names.get(i)+", ");
            }
                System.out.println();
            }
        }
        }
        
    }
    
}
