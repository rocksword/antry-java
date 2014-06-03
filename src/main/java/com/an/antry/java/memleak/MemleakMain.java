package com.an.antry.java.memleak;

import java.util.HashSet;
import java.util.Set;

public class MemleakMain {

    public static void main(String[] args) {
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("tangseng", "pwd1", 25);
        Person p2 = new Person("sunwukong", "pwd2", 26);
        Person p3 = new Person("zhubajie", "pwd3", 27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("Total element count: " + set.size());
        // 结果：总共有:3个元素!

        // 修改p3的年龄,此时p3元素对应的hashcode值发生改变
        p3.setAge(2);

        // 此时remove不掉，造成内存泄漏
        set.remove(p3);

        // 重新添加，居然添加成功
        set.add(p3);
        // 结果：总共有:4个元素!
        System.out.println("Total element count: " + set.size());

        for (Person person : set) {
            System.out.println(person);
        }
    }
}
