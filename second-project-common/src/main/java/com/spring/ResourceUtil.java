package com.spring;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * created by zhouzhongyi on 2018/7/21
 */
public class ResourceUtil {
    //详细见Resource接口的详细api
    private static Resource res = new ClassPathResource("test.txt") ;//classpath路径下

    public File getFile() throws IOException{
        return res.getFile() ;
    }

    public InputStream getInputStream() throws IOException {
        return res.getInputStream() ;
    }
}
