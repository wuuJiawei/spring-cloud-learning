package com.example.elasticsearchclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wujiawei
 * @see
 * @since 2021/6/26 9:45 下午
 */
@RequestMapping("cat")
@RestController
public class CatController {
    
    @Autowired
    private CatDao catDao;
    
    @GetMapping("save")
    public Object save() {
        Cat cat = new Cat();
        cat.setColor("黑色");
        cat.setName("煤球");
        cat.setId(0L);
        cat.setVersion(0L);
        
        Cat result = catDao.save(cat);
        return result;
    }
    
    @GetMapping("save/batch/{index}")
    public Object saveBatch(@PathVariable Long index) throws InterruptedException {
        int max = 77;
        CountDownLatch latch = new CountDownLatch(max);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        AtomicLong atomic = new AtomicLong(index);
        while (atomic.get() <= max) {
            executorService.execute(()->{
                long i = atomic.getAndIncrement();
                Cat cat = new Cat();
                cat.setColor("黑色");
                cat.setName(i + "号煤球");
                cat.setId(i);
                cat.setVersion(0L);
                catDao.save(cat);
                latch.countDown();
            });
        }
        
        latch.await();
        
        return max;
    }
    
    @GetMapping("query")
    public Object query(Integer pageNo) {
        List<Cat> list = new ArrayList<>();
        Iterable<Cat> iterable = catDao.findAll(PageRequest.of(pageNo, 20));
        iterable.forEach(list::add);
        return list;
    }
    
}
