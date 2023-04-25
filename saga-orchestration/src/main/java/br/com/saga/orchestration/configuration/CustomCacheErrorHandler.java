package br.com.saga.orchestration.configuration;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

public class CustomCacheErrorHandler implements CacheErrorHandler {
    @Override
    public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
        System.out.println(e);
    }

    @Override
    public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
        System.out.println(e);
    }

    @Override
    public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
        System.out.println(e);
    }

    @Override
    public void handleCacheClearError(RuntimeException e, Cache cache) {
        System.out.println(e);
    }
}
