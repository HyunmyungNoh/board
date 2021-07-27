package com.practice.board.service;

import com.practice.board.domain.entity.File;
import com.practice.board.domain.repository.FileRepository;
import com.practice.board.dto.FileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    /*
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
    */

    @Transactional
    public Long saveFile(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getId();
    }

    @Transactional
    public FileDto getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileDto fileDto = FileDto.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }

}
