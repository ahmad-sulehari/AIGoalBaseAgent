
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahma
 */
public class Driver {
    public static void main(String[] args) {
        int noOfStates = 0, actions = 0, noOfPlans = 0;
        
        Scanner inp = new Scanner(System.in);
        
        System.out.println("enter number of states, actions and plans");
        
        noOfStates = inp.nextInt();
        actions = inp.nextInt();
        noOfPlans = inp.nextInt();
        
        System.out.println(noOfStates);
        System.out.println(actions);
        System.out.println(noOfPlans);
        
        String[] states = new String[noOfStates]; 
        
        inp.nextLine();
        
        for (int i = 0; i < noOfStates; i++) {
            states[i] = inp.nextLine();
        }
        
        
        for (int i = 0; i < noOfStates; i++) {
            System.out.println(states[i]);
        }
        
        
        String[] act = new String[actions];
        
        
        for (int i = 0; i < actions; i++) {
            act[i] = inp.nextLine();
        }
        
        
        for (int i = 0; i < actions; i++) {
            System.out.println(act[i]);
        }
        
        int table[][] = new int[noOfStates][actions];
        
        for (int i = 0; i < noOfStates; i++) {
            
            for (int j = 0; j < actions; j++) {
                table[i][j] =  inp.nextInt();
            }
        }
        
        for (int i = 0; i < noOfStates; i++) {
            
            for (int j = 0; j < actions; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println(" ");
        }        
        
        String start,goal;
        

        System.out.println("enter start state"); 
                inp.nextLine();
        start = inp.nextLine();
        goal = inp.nextLine();        
        System.out.println(start+" "+goal);
        
        int start_index = -1, goal_index = -1;
        
        for (int i = 0; i < noOfStates; i++) {
            if(states[i].compareTo(start)  == 0){
                start_index = i;
                break;
            }
        }

        for (int i = 0; i < noOfStates; i++) {
            if(states[i].compareTo(goal)==0){
                goal_index = i;
                break;
            }
        }        
        if(start_index == -1 || goal_index == -1){
            System.out.println("invalid start or goal state");
        
        }
        else{
            
            if(start == goal){
                System.out.println("Goal already reaced");
            }
            
            Queue<Node> frontier = new LinkedList<>();
            Set<Node> explored = new HashSet<Node>();
            
            Node stnode = new Node(start_index,-1,0,null);
            frontier.add(stnode);
            
            int cost = 0;
            
            while(!frontier.isEmpty()){
                Node check = new Node();
                
                check = frontier.remove();
                
                if(check.getState() != goal_index){
                    
                    explored.add(check);
                    
                    for (int i = 0; i < actions; i++) {
                        
                        stnode.setState( table[check.getState()][i]);
                        stnode.setCost(cost+1);
                        stnode.setAction(i);
                        stnode.setParent(check);
                        if(check.getState() != stnode.getState()){
                            frontier.add(stnode);
                        }
                    }
                    cost++;
                    
                }
                else{
                    LinkedList<Node> plan = new LinkedList<Node>();
                    while(check!= null){
                        
                        plan.addFirst(check.getParent());
                        check = check.getParent();
                    }
                    
                    while(!plan.isEmpty()){
                        
                        int i = plan.getLast().getAction();
                        System.out.println(act[i]+"->");
                        plan.removeLast();
                    }
                    
                }
            }
            
            
            
//            else{
//                String sstate[] = start.split(",");
//                String gstate[] = goal.split(",");
//                
//                if(sstate[0] != gstate[0]){
//                    
//                    if(sstate[0].indexOf("1") != -1){
//                        for (int i = 0; i < 10; i++) {
//                            
//                        }
//                        
//                    }
//                }
//                
//                
//            }
        }
        
        
    }

    
    
}
