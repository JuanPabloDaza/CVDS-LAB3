package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry {
    private ArrayList<Integer> idRegistered = new ArrayList<Integer>();
    
    public RegisterResult registerVoter(Person p) {
        if(!p.isAlive()){
            return RegisterResult.DEAD;
        }else if(p.getAge() < 0){
            return RegisterResult.INVALID_AGE;
        }else if(p.getAge() < 18){
            return RegisterResult.UNDERAGE;
        }else if(idRegistered.contains(p.getId())){
            return RegisterResult.DUPLICATED;
        }else{
            idRegistered.add(p.getId());
            return RegisterResult.VALID;
        }
    }
}