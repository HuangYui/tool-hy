package com.hy.tool;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : HY
 * @version : V1.0
 * @ClassName : FindFileAndModifyClass
 * @Description:
 * @date : 2023/9/18 16:57
 */
public class FindFileAndModifyUtil {

    public static void main(String[] args) {

        String path = "C:\\project\\ddyk\\ddyk-server-new";

        String fileName = "config";
        String sourceStr = "192.168.1.108";
        String replaceStr = "192.168.1.60";

        List<File> files = FileUtil.loopFiles(path, a -> fileName.equals(a.getName()));
        for (File file : files) {
            List<String> list = FileUtil.readLines(file, Charset.defaultCharset());
            List<String> replaceList = new ArrayList<>();
            list.forEach(a -> {
                if (a.contains(sourceStr)) {
                    replaceList.add(a.replace(sourceStr, replaceStr));
                } else {
                    replaceList.add(a);
                }
            });

            FileUtil.writeLines(replaceList, file, Charset.defaultCharset());
        }
    }
}
