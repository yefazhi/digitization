package com.digitization.config;

import com.digitization.util.DateUtil;
import org.n52.matlab.control.MatlabConnectionException;
import org.n52.matlab.control.MatlabProxy;
import org.n52.matlab.control.MatlabProxyFactory;
import org.n52.matlab.control.MatlabProxyFactoryOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Configuration
public class MatlabConfiguration {

    @Value("${matlab.file.path}")
    private String matlabFilePath;
    @Value("${matlab.exe.path}")
    private String matlabExePath;

    @Bean(name = "matlabProxy")
    public MatlabProxy createFactory() throws MatlabConnectionException {
        File file = null;
        try {
            System.out.println(DateUtil.getDateStr()+" -------------------------> MATLAB文件获取开始...");
            file = ResourceUtils.getFile(matlabFilePath);
        } catch (FileNotFoundException e) {
            System.out.println(DateUtil.getDateStr()+" -------------------------> MATLAB文件获取失败!");
        }
        System.out.println(DateUtil.getDateStr()+" -------------------------> MATLAB文件获取成功！");
        System.out.println(DateUtil.getDateStr()+" -------------------------> JAVA与MATLAB开始建立连接...");
        MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder()
                .setProxyTimeout(300000L)
                .setMatlabStartingDirectory(file)
                .setHidden(false)
                .setMatlabLocation(matlabExePath)
                .build();
        System.out.println(DateUtil.getDateStr()+" -------------------------> 开始拉起MATLAB应用程序...");
        MatlabProxyFactory factory = new MatlabProxyFactory(options);
        MatlabProxy proxy = factory.getProxy();
        System.out.println(DateUtil.getDateStr()+" -------------------------> MATLAB应用程序已经启动！");
        System.out.println(DateUtil.getDateStr()+" -------------------------> JAVA与MATLAB开始建立连接成功!");
        return proxy;
    }
}
