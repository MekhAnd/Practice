package com.gmail.mekhanich.andrii;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class SaveTo {

    private DataArray array;

    public static void saveTo (Object o) {
        StringBuffer sb = new StringBuffer();
        final Class<?> cls = o.getClass();
        Field [] fields = cls.getDeclaredFields();
        for (Field field: fields) {
            if(field.isAnnotationPresent(Save.class)){
                if(Modifier.isPrivate(field.getModifiers())){
                    field.setAccessible(true);
                    try{
                        sb.append(field.getType() + "," + field.getName() + "," + field.get(o));
                        sb.append(";");
                   try(PrintWriter pw = new PrintWriter(new FileWriter("data.txt"))){
                        pw.print(sb);
                        pw.flush();
                   }catch (IOException e){
                        e.printStackTrace();
                        }
                    catch(Exception e){
                        e.printStackTrace();
                    }}
                    catch(IllegalAccessException e){
                        e.printStackTrace();
                    }

                }











            }
        }

    }
}
