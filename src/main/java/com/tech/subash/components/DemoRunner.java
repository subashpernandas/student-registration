package com.tech.subash.components;

import com.tech.subash.entity.UrbanEntity;
import com.tech.subash.repository.UrbanRepository;
import com.tech.subash.service.ReaderService;
import com.tech.subash.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DemoRunner {//implements CommandLineRunner{

    private final WriterService writerService;
    private final ReaderService readerService;
    private final UrbanRepository urbanRepository;


    //@Override
    public void run(String... args) throws Exception {
        // Create test data
        UrbanEntity u = new UrbanEntity();
        u.setName("Test City");
        u.setAge(20);
        u = urbanRepository.save(u);

        Long id = u.getId();

        // Thread 1: Writer (updates but sleeps before commit)
        new Thread(() -> writerService.updateUrban(id, 99)).start();

        // Wait 1 sec so update starts but isn't committed
        Thread.sleep(1000);

        // Thread 2: Reader (reads uncommitted data)
        readerService.readUrban(id);
    }
}
