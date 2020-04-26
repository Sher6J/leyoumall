package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-24-15:18
 */
@Service
public class UploadService {

    private static final List<String> CONTENT_TYPES
            = Arrays.asList("image/png", "image/gif", "image/jpg", "image/jpeg");

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    @Autowired
    private FastFileStorageClient storageClient;

    public String uploadImage(MultipartFile file) {
        /*//校验文件类型
        String originalFilename = file.getOriginalFilename(); //获取原始文件名
        String contentType = file.getContentType();//获取文件类型
        if (!CONTENT_TYPES.contains(contentType)) {
            LOGGER.info("文件类型不合法：{}", originalFilename);
            return null;
        }

        try {
            //校验文件内容是不是图片
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null) {
                LOGGER.info("文件内容不合法：{}", originalFilename);
                return null;
            }

            //保存到服务器
//            file.transferTo(new File("D:\\IdeaProjects\\leyou\\image\\" + originalFilename));
            String ext = StringUtils.substringAfterLast(originalFilename, "."); //得到文件后缀名
            StorePath storePath = this.storageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);


            //返回url，进行回显
//            return "http://image.leyou.com/" + originalFilename;
            return "http://image.leyou.com/" + storePath.getFullPath();
        } catch (IOException e) {
            LOGGER.info("服务器内部错误：" + originalFilename);
            e.printStackTrace();
        }
        return null;*/
        /**
         * 1.图片信息校验
         *      1)校验文件类型
         *      2)校验图片内容
         * 2.保存图片
         *      1)生成保存目录
         *      2)保存图片
         *      3)拼接图片地址
         */
        try {
            String type = file.getContentType();
            if (!CONTENT_TYPES.contains(type)) {
                LOGGER.info("上传文件失败，文件类型不匹配：{}", type);
                return null;
            }
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                LOGGER.info("上传失败，文件内容不符合要求");
                return null;
            }

//            File dir = new File("G:\\LeYou\\upload");
//            if (!dir.exists()){
//                dir.mkdirs();
//            }
//            file.transferTo(new File(dir, Objects.requireNonNull(file.getOriginalFilename())));

            StorePath storePath = this.storageClient.uploadFile(
                    file.getInputStream(), file.getSize(), getExtension(file.getOriginalFilename()), null);

            //String url = "http://image.leyou.com/upload/"+file.getOriginalFilename();
            String url = "http://image.leyou.com/"+storePath.getFullPath();
//            System.out.println(url);
            return url;
        }catch (Exception e){
            return null;
        }
    }

    public String getExtension(String fileName){
        return StringUtils.substringAfterLast(fileName,".");
    }
}
