package com.AthenaML.AthenaSandbox.Service;

import com.AthenaML.AthenaSandbox.Domain.MatchResult;
import com.AthenaML.AthenaSandbox.Helper.CSVHelper;
import com.AthenaML.AthenaSandbox.Repository.MatchResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Wayne Sidney
 * Created on {14/12/2022}
 */
@Service
public class CSVServiceImpl implements CSVService{

    @Autowired
    private MatchResultsRepository matchResultsRepository;
    @Override
    public void save(MultipartFile file) {
        try{
            List<MatchResult> matchResultList = CSVHelper.csvToDatabase(file.getInputStream());
            matchResultsRepository.saveAll(matchResultList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MatchResult> getAllMatchResults() {
        return (List<MatchResult>) matchResultsRepository.findAll();
    }


}
