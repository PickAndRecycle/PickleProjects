package com.pickle.service.impl;

import com.pickle.converter.ArticleVoConverter;
import com.pickle.exception.ServiceException;
import com.pickle.persistence.domain.Article;
import com.pickle.persistence.repository.ArticleRepository;
import com.pickle.service.ArticleService;
import com.pickle.vo.ArticleVO;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yanuar Wicaksana on 11/14/15.
 */

@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {
    public static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    ArticleVoConverter articleVoConverter;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public ArticleVO add(ArticleVO vo) {

        Article article = articleVoConverter.transferVOToModel(vo,null);
        articleRepository.save(article);

        vo.setId(article.getSecureId());

        return vo;


    }

    @Override
    public ArticleVO findById(String s) {
        Article article = articleRepository.findBySecureId(s);

        if (article == null) {
            throw new ServiceException("Article item not found: " + s);
        }

        return articleVoConverter.transferModelToVO(article, null);
    }

    @Override
    public ArticleVO addTrash(ArticleVO vo, MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public Collection<ArticleVO> findAll() {
        Collection<Article> ArticleList = articleRepository.findAll();

        return articleVoConverter.transferListOfModelToListOfVO(ArticleList, null);
    }

    @Override
    public Boolean delete(String s) {
        return null;
    }

    @Override
    public ArticleVO update(String s, ArticleVO vo) {
        Article article = articleRepository.findBySecureId(s);

        article = articleVoConverter.transferVOToModel(vo,article);

        articleRepository.saveAndFlush(article);

        return articleVoConverter.transferModelToVO(article, null);
    }

    /**
     * Create photo directory if it doesn't exist
     * @return photoDirectory
     */
    public static String createPhotoDirectory(){

//        try{
        File photoDirectory = new File("/home/ubuntu/pickle-core/");
        //File photoDirectory = new File("Users/dedensukarna/");
        logger.info("photoBaseDir = {}", new Object[]{ photoDirectory });

        File newPhotoDirectory = new File(photoDirectory, "articleImages");
        logger.info("newPhotoDirectory = {}", new Object[]{ newPhotoDirectory });

        if(!newPhotoDirectory.exists()){
            boolean create = newPhotoDirectory.mkdirs();
            logger.info("Create directory photo " + newPhotoDirectory+ " -> "+create);
        } else {
            logger.info("Directory photo "+newPhotoDirectory+" is already exists");
        }
        return newPhotoDirectory.getAbsolutePath();

//        } catch (IOException ex){
//            logger.error("Can't create directory photo, "+ex.getMessage());
//        }
//
//        return null;

    }


    @Override
    public ArticleVO addArticle(ArticleVO vo, MultipartFile file) throws IOException {
        //input to database
        Article article = articleVoConverter.transferVOToModel(vo,null);

        List<String> url = sendToServer(file);
        article.setPhoto_url(url.get(0));
        article.setThumbnailUrl(url.get(1));

        articleRepository.save(article);

        vo.setId(article.getSecureId());

        return vo;
    }


    public static List<String> sendToServer(MultipartFile sourceFile) throws IOException {

        String path = createPhotoDirectory();

        String originalFilename = sourceFile.getOriginalFilename();
        String destFilename = StringUtils.isBlank(originalFilename) ? RandomStringUtils.randomAlphabetic(8) :
                originalFilename.replaceAll("/s", "_");

        String fileName = RandomStringUtils.randomNumeric(8) + "_" + destFilename;
        String fileName2 = RandomStringUtils.randomNumeric(8) + "_" + destFilename;
        File destinationFile = new File(path + "/" + fileName);
        File destinationFile2 = new File(path + "/" + fileName2);

        byte[] bytes = sourceFile.getBytes();
        InputStream in = new ByteArrayInputStream(bytes);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        BufferedImage thumbImg = Scalr.resize(bImageFromConvert, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC,
                50,
                50, Scalr.OP_ANTIALIAS);

        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(destinationFile));
        ImageIO.write(thumbImg,"jpg",destinationFile2);
        stream.write(bytes);
        stream.close();



//        sourceFile.transferTo(destinationFile);
        List destination = new ArrayList<String>();
        destination.add("http://104.155.237.238/pic/trashImages/" + fileName);
        destination.add("http://104.155.237.238/pic/trashImages/" + fileName2);
        return destination;

        //return destinationFile.getAbsolutePath().replace("/home/ubuntu/pickle-core/trashImages", "");
    }
}
