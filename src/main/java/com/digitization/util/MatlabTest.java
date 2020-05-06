package com.digitization.util;

import org.n52.matlab.control.*;
import org.n52.matlab.control.extensions.MatlabNumericArray;
import org.n52.matlab.control.extensions.MatlabTypeConverter;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class MatlabTest {

    private static final String matlabFile = "C:\\Users\\Administrator\\Desktop\\matlab";

    public static void main(String[] args) throws MatlabConnectionException, MatlabInvocationException, FileNotFoundException {
        File file = null;
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>>>> Mtalab文件获取开始...");
            file = ResourceUtils.getFile(matlabFile);
        } catch (FileNotFoundException e) {
            System.out.println("Mtalab文件获取失败!");
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>> Mtalab文件获取成功！");
        System.out.println(">>>>>>>>>>>>>>>>>>>>> Mtalab建立连接...");
        MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder()
                .setProxyTimeout(300000L)
                .setMatlabStartingDirectory(file)
                .setHidden(false)
                .setMatlabLocation("G:\\MATLAB\\R2018a\\bin\\matlab.exe")
                .build();
        System.out.println(">>>>>>>>>>>>>>>>>>>>> 开始拉起MATLAB程序...");
        MatlabProxyFactory factory = new MatlabProxyFactory(options);
        MatlabProxy proxy = factory.getProxy();
        System.out.println(">>>>>>>>>>>>>>>>>>>>> MATLAB程序启动成功！");
        System.out.println(">>>>>>>>>>>>>>>>>>>>> MATLAB连接成功!");
        System.out.println(">>>>>>>>>>>>>>>>>>>>> JAVA 调用 MATLAB 程序...");
        double[][] in = createMockInputDataArray();
        MatlabNumericArray input = new MatlabNumericArray(in, null);
        MatlabTypeConverter converter = new MatlabTypeConverter(proxy);
        converter.setNumericArray("in", input);
        proxy.eval("[out]=main(in,path)");
        double[][] out = converter.getNumericArray("out").getRealArray2D();
        System.out.println(">>>>>>>>>>>>>>>>>>>>> java invoke matlab success");
        // 断开连接proxy.exit();
    }

    private static double[][] createMockInputDataArray() {
        String p = "1	1	2	3	6	3;1	2	2	8	16	1; 1	3	2	9	18	2; 1	4	2	2	4	4; 1	5	2	3	6	6; 1	6	2	2	4	5; 2	1	3	6	18	2; 2	2	3	8	24	3; 2	3	3	2	6	6; 2	4	3	5	15	5; 2	5	3	3	9	1; 2	6	3	3	9	4;3	1	2	4	8	3;3	2	2	7	14	4;3	3	2	6	12	6;3	4	2	5	10	1;3	5	2	9	18	1;3	6	2	1	2	5;4	1	4	2	8	4;4	2	4	4	16	1;4	3	4	4	16	3;4	4	4	1	4	2;4	5	4	1	4	5;4	6	4	3	12	6;5	1	3	6	18	2;5	2	3	8	24	2;5	3	3	7	21	3;5	4	3	8	24	6;5	5	3	5	15	1;5	6	3	4	12	4;6	1	2	2	4	2;6	2	2	4	8	4;6	3	2	6	12	6;6	4	2	1	2	1;6	5	2	5	10	5;6	6	2	3	6	3";
        String[] p1 = p.split(";");
        double[][] input = new double[p1.length][6];
        for (int i = 0; i < p1.length; i++) {
            String[] num = p1[i].split("\t");
            input[i][0] = Integer.parseInt(num[0].trim());
            input[i][1] = Integer.parseInt(num[1].trim());
            input[i][2] = Integer.parseInt(num[2].trim());
            input[i][3] = Integer.parseInt(num[3].trim());
            input[i][4] = Integer.parseInt(num[4].trim());
            input[i][5] = Integer.parseInt(num[5].trim());
        }
        return input;
    }
}
