package com.lhf.deviceMS.facade.web;

import com.lhf.deviceMS.common.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/toolbox")
public class ToolBoxController {

    protected Logger logger = LoggerFactory.getLogger(ToolBoxController.class);

    private String fileTempPath = "D://";
    @GetMapping
    public String toTest(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/fileupload")
    public String fileupload(@RequestParam("file")MultipartFile file) throws IOException {
        String newFileName = "";
        try{
            byte[] bytes = file.getBytes();

            String originalFilename = file.getOriginalFilename();
            int index = originalFilename.lastIndexOf(".");
            newFileName = RandomUtils.uuid()+originalFilename.substring(index);
            Path path = Paths.get(fileTempPath + newFileName);
            Files.write(path, bytes);
        }catch (IOException e) {
            logger.error("上传文件失败,msg={}",e);
            newFileName = "";
        }
        System.out.println(newFileName);
        return  newFileName;
    }

}
