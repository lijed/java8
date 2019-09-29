package com.me.ehcache;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

import org.ehcache.Cache;
import org.ehcache.Cache.Entry;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.ResourcePools;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.me.jvm.system.SystemInfo;

public class HelloHeapServiceImpl implements HelloHeapService {

    private static Map<String, InHeapClass> inHeapCache = Maps.newHashMap();

    private static Cache<String, OffHeapClass> offHeapCache;

    static {
    	
        ResourcePools resourcePools = ResourcePoolsBuilder.newResourcePoolsBuilder()
                .offheap(1, MemoryUnit.MB)
                .build();

        CacheConfiguration<String, OffHeapClass> configuration = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, OffHeapClass.class, resourcePools)
                .build();

        offHeapCache = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("cacher", configuration)
                .build(true)
                .getCache("cacher", String.class, OffHeapClass.class);
        for (int i = 1; i < 10001; i++) {
            inHeapCache.put("InHeapKey" + i, new InHeapClass("InHeapKey" + i, "InHeapValue" + i));
            offHeapCache.put("OffHeapKey" + i, new OffHeapClass("OffHeapKey" + i, "OffHeapValue" + i));
        }
        
    }

    static class InHeapClass implements Serializable {
		private static final long serialVersionUID = 1L;
		private String key;
        private String value;
		public InHeapClass(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
    }

    static class OffHeapClass implements Serializable {
		private static final long serialVersionUID = 1L;
		private String key;
        private String value;
		public OffHeapClass(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
    }

    public void helloHeap() {  
    	SystemInfo.displayJvmMemoryInfo();
    	
        System.out.println(JSON.toJSONString(inHeapCache.get("InHeapKey1")));
        System.out.println(JSON.toJSONString(offHeapCache.get("OffHeapKey1")));
        Iterator<Entry<String, OffHeapClass>> iterator = offHeapCache.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            System.out.println(JSON.toJSONString(iterator.next().getValue().value));
            sum++;
        }
        System.out.println(sum);
        
        SystemInfo.displayJvmMemoryInfo();
    }
    
    public static void main(String[] args) {
    	HelloHeapService service = new HelloHeapServiceImpl();
    	service.helloHeap();
	}
}
