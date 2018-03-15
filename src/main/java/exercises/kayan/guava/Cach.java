package kayan.guava;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class Cach {
    
    private static final LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterAccess(3, TimeUnit.SECONDS)
            .build(new CacheLoader<Integer, String>() {
                public String load(Integer gameId) {
                    System.out.println("getting from db");
//                    return multishotCoreService.getGameInfo(gameId).getGameProvider();
                    return "hello";
                }
            });

    public static String getGameProvider(int gameId) {
        try {
            return cache.get(gameId);
        } catch (ExecutionException e) {
            System.out.println("Error loading game provider from cache {}, will get from db");
            //return multishotCoreService.getGameInfo(gameId).getGameProvider();
            return "ssss";
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
     getGameProvider(1);
     getGameProvider(1);
     Thread.sleep(4000);
     getGameProvider(1);   
    }
    

}
