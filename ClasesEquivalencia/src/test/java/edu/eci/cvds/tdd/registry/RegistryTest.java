package edu.eci.cvds.tdd.registry;


import org.junit.Assert;
import org.junit.Test;
public class RegistryTest {
private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
    Person person = new Person();
    RegisterResult result = registry.registerVoter(person);
    Assert.assertEquals(RegisterResult.VALID, result);
    } 
    
    @Test
    public void underAgeRegistryResult() {
        Person person = new Person("Juan Pablo",1,17,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void deadRegistryResult() {
        Person person = new Person("Jhon Piñeros",2,22,Gender.UNIDENTIFIED,false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD,result); 
    }

    @Test
    public void invalidAgeRegistryResult() {
        Person person = new Person("Lionela James",3,-36,Gender.FEMALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void duplicatedRegistryResult() {
        Person person = new Person("Cristiano Ronaldo",7,38,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED,result);
    }
}