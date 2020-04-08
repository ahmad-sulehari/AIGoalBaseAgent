/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahma
 */
public class Node {
    
    int state,
        action,
        cost;
    Node parent;

    public Node(int state, int action, int cost, Node parent) {
        this.state = state;
        this.action = action;
        this.cost = cost;
        this.parent = parent;
    }
    public Node(){
        this.state = -1;
        this.action = -1;
        this.cost = 0;
        this.parent = null;
    }
    public int getState() {
        return state;
    }

    public int getAction() {
        return action;
    }

    public int getCost() {
        return cost;
    }

    public Node getParent() {
        return parent;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
}
