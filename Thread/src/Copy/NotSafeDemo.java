package Copy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 * @Author jiangdong
 * @Description
 * @Date  2019/10/10 9:56
 **/
public class NotSafeDemo {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        // System.out.println(UUID.randomUUID().toString().substring(0,8));
        for (int i = 1; i <=30; i++) {
            new Thread(() -> {map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName()+ map); },String.valueOf(i)).start();
        }


    }

    public static void setnotSafe(){
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <=30; i++) {
            new Thread(() -> {set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set); },String.valueOf(i)).start();
        }
    }

    public  static void listNotSafe(){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <=30 ; i++) {
            new Thread(() -> {list.add(UUID.randomUUID().toString().substring(0,8)); },String.valueOf(i)).start();
        }

    }
}
