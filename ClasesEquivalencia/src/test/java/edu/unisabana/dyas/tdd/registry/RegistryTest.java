package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void ValidVoter()
    {
        Person p = new Person("yuta",1,19,Gender.MALE,true);
        RegisterResult r= registry.registerVoter(p);
        Assert.assertEquals(RegisterResult.VALID, r);
    }
    @Test
    public void Dead()
    {
        Person p = new Person("gojo",6,22,Gender.MALE,false);
        RegisterResult r= registry.registerVoter(p);
        Assert.assertEquals(RegisterResult.DEAD, r);
    }
    @Test
    public void UnderAge()
    {
        Person p = new Person("itadori",2,15,Gender.MALE,true);
        RegisterResult r= registry.registerVoter(p);
        Assert.assertEquals(RegisterResult.UNDERAGE, r);
    }
    @Test
    public void InvalidAge()
    {
        Person p = new Person("tengen",10,300,Gender.MALE,true);
        RegisterResult r= registry.registerVoter(p);
        Assert.assertEquals(RegisterResult.INVALID_AGE, r);
    }
    @Test
    public void Duplicated()
    {
        Person p = new Person("geto",9,35,Gender.MALE,true);
        registry.registerVoter(p);
        Person p2 = new Person("kenjaku",9,40,Gender.MALE,true);
        RegisterResult r= registry.registerVoter(p2);
        Assert.assertEquals(RegisterResult.DUPLICATED, r);
    }
    // TODO Complete with more test cases
}
