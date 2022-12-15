package com.AthenaML.AthenaSandbox.Service;

import com.AthenaML.AthenaSandbox.Domain.MatchResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Wayne Sidney
 * Created on {14/12/2022}
 */
public interface CSVService {
    public void save(MultipartFile file);
    public List<MatchResult> getAllMatchResults();
}
