package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLOutput;
import java.util.Arrays;

public class ReadFrom {
    public static DataArray readFrom (){
        DataArray array = new DataArray();
        final Class<?> cls = array.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field:fields) {
            if(field.isAnnotationPresent(Save.class)){
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                    StringBuffer sb = new StringBuffer();
                    String tmp = "";
                    try (BufferedReader bfr = new BufferedReader(new FileReader("data.txt"))){
                         String line = "";
                         for(;(line = bfr.readLine())!=null;){
                            sb.append(line);
                         }
                         tmp = sb.toString();
                } catch (IOException e){
                    e.printStackTrace();
                }
                String [] tmpar = tmp.split(";");

                try {
                    for (int i = 0; i < tmpar.length; i++) {
                        String[] fieldar = tmpar[i].split(",");
                            String type = fieldar[0];
                            String value = fieldar[2];
                            if (field.getType() == int.class && type.contains("int")) {
                                Method me = cls.getMethod("setA", int.class);
                                me.invoke(array,Integer.parseInt(value));
                                field.setInt(array, Integer.parseInt(value));
                            } else if(field.getType() == String.class && type.contains("String")){
                                Method me = cls.getMethod("setB", String.class);
                                me.invoke(array,value);
                                field.set(array, value);
                            }
                        }
                    }catch(IllegalAccessException e){
                        e.printStackTrace();
                    }catch (NoSuchMethodException ex){
                        ex.printStackTrace();
                    } catch (java.lang.reflect.InvocationTargetException exe){
                        exe.printStackTrace();
                }
                }

            }
        }
        return array;
    }
}
