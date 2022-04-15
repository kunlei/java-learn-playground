package com.playground.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {
  public static void main(String[] args) {
    Object person = new Person();
    Field[] fields = person.getClass().getDeclaredFields();
    List<String> actualFieldNames = getfieldnames(fields);
    System.out.println(actualFieldNames.toString());
  }

  private static List<String> getfieldnames(Field[] fields) {
    List<String> fieldNames = new ArrayList<>();
    for (Field field : fields) {
      fieldNames.add(field.getName());
    }
    return fieldNames;
  }
}

class Person {
  private String name;
  private int age;
}
