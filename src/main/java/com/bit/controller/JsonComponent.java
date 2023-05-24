package com.example.boardweb.component;


import java.lang.reflect.Field;
import java.util.List;

public class JsonComponent {
    private JsonComponent() {
    }
    private static JsonComponent inst = null;
    public static JsonComponent getInst() {
        if(inst == null) inst = new JsonComponent();
        return inst;
    }

    //List<Object> -> Object는 원하는 객체를 Object로 다운캐스팅해서 만들어주면댐
    // ex) List<Object> list = new List<Bean>();
    //리스트 를 받아서 Json 형태의 문자열로 반환해줌
    public String getStringFromList(List<Object> list) {
        String jsonStr = "[";
        Field[] fields = list.get(0).getClass().getDeclaredFields();

        int count = 0;
        for (Object obj: list) {
            String node = "{";
            try {
                for(int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    Object val = fields[i].get(obj);
                    node += "\""+ fields[i].getName() + "\":"+ "\""+ val + "\"";
                    if(i != fields.length - 1) node += ",";
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            node += "}";
            if(count < list.size() - 1) node += ",";
            jsonStr += node;
            count++;
        }
        jsonStr += "]";
        return jsonStr;
    }
}
