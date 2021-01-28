package com.company.Controller;

import java.io.*;

public class HandleData {


    public static void writeObject(Object object,String filename) {


        try (FileOutputStream fileOutputStream = new FileOutputStream(filename,false );
                ObjectOutputStream objectOutputStream= new
                ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static Object readObject (String filename){

        Object object =null;
        try(InputStream input = new FileInputStream(filename);

            ObjectInputStream objectInputStream = new ObjectInputStream(input)){
            object = (Object) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

}
