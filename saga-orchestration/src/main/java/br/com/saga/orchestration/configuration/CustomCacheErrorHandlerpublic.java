package br.com.saga.orchestration.configuration;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

public class CustomCacheErrorHandlerpublic implements CacheErrorHandler {
    @Override
    public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {

    }

    @Override
    public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {

    }

    @Override
    public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
    }

    @Override
    public void handleCacheClearError(RuntimeException e, Cache cache) {

    }
}
