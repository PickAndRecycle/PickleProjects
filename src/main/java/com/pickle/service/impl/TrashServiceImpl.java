package com.pickle.service.impl;

import com.pickle.converter.TrashVoConverter;
import com.pickle.exception.ServiceException;
import com.pickle.persistence.domain.Trash;
import com.pickle.persistence.repository.TrashRepository;
import com.pickle.service.TrashService;
import com.pickle.vo.TrashVO;
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
 * Created by Yanuar Wicaksana on 11/2/15.
 */


@Service
@Transactional(readOnly = true)
public class TrashServiceImpl implements TrashService{

    public static final Logger logger = LoggerFactory.getLogger(TrashServiceImpl.class);


    @Autowired
    TrashVoConverter trashVoConverter;

    @Autowired
    TrashRepository trashRepository;

    @Override
    public TrashVO add(TrashVO vo) {
        //input to database
        Trash trash = trashVoConverter.transferVOToModel(vo,null);

        trashRepository.save(trash);

        vo.setId(trash.getSecureId());

        return vo;
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

        File newPhotoDirectory = new File(photoDirectory, "trashImages");
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
    public TrashVO addFile(TrashVO vo, MultipartFile file) throws IOException {
        //input to database
        Trash trash = trashVoConverter.transferVOToModel(vo,null);

        List<String> url = sendToServer(file);
        trash.setPhoto_url(url.get(0));
        trash.setThumbnailUrl(url.get(1));

        trashRepository.save(trash);



        vo.setId(trash.getSecureId());

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

    @Override
    public TrashVO update(String s, TrashVO vo) {

        Trash trash = trashRepository.findBySecureId(s);

        trash = trashVoConverter.transferVOToModel(vo,trash);

        trashRepository.saveAndFlush(trash);

        return trashVoConverter.transferModelToVO(trash, null);

    }

    @Override
    public Boolean delete(String s) {
       return null;
    }

    @Override
    public Collection<TrashVO> findAll() {
        Collection<Trash> TrashList = trashRepository.findAll();

        return trashVoConverter.transferListOfModelToListOfVO(TrashList, null);
    }

    @Override
    public TrashVO findById(String s) {

        Trash trash = trashRepository.findBySecureId(s);

        if (trash == null) {
            throw new ServiceException("Trash item not found: " + s);
        }

        return trashVoConverter.transferModelToVO(trash, null);
    }
}

