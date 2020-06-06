package com.gzcb;
import com.gzcb.impl.PersonImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySaler implements InvocationHandler {

    public Person person;

    public Object newInstall(Person person)
    {
        this.person=person;
        return  Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前的操作");
        if (method.getName().equals("buy")) {
            person.buy();
        }
        if (method.getName().equals("buy1")) {
            person.buy1();
        }
        System.out.println("执行方法后的操作");
        return null;
    }

    public static void main(String[] args) {
        ProxySaler proxySaler=new ProxySaler();
        Person object= (Person) proxySaler.newInstall(new PersonImpl("黄豪强","南山区"));
        object.buy1();
        object.buy();
    }

}