package com.tech.subash.utils;

import com.tech.subash.entity.UrbanEntity;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CacheUtil {

        @Autowired
        private CacheManager cacheManagerAutowired;

        private static CacheManager cacheManager;

        private static String customerImagePathCacheName;

        @PostConstruct
        private void load() {
        cacheManager = cacheManagerAutowired;
    }

        public void putToCache(String cacheName,String cacheKey, String cacheValue){
        Cache cache = cacheManager.getCache(cacheName);
        if(cache!=null) {
            cache.put(cacheKey, cacheValue);
        }
    }

        public <T> T getFromCache(String cacheName, long cacheKey, Class<T> clazz) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            Cache.ValueWrapper valueWrapper = cache.get(cacheKey);
            if (valueWrapper != null) {
                Object cachedObject = valueWrapper.get();
                if (clazz.isInstance(cachedObject)) {
                    return clazz.cast(cachedObject);
                }
            }
        }
        return null;
    }

        public UrbanEntity getLanguageCodeUsingAppId(long urbanId){
        UrbanEntity urbanDetails = getFromCache("urban_cache", urbanId, UrbanEntity.class);
        if(urbanDetails == null){
            urbanDetails = new UrbanEntity();
        }
        log.info("cache urban details {} ", urbanDetails);
        return urbanDetails;
    }
}
