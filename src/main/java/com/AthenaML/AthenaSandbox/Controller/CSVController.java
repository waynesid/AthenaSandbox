package com.AthenaML.AthenaSandbox.Controller;

import com.AthenaML.AthenaSandbox.Domain.MatchResult;
import com.AthenaML.AthenaSandbox.Helper.CSVHelper;
import com.AthenaML.AthenaSandbox.Helper.ResponseMessage;
import com.AthenaML.AthenaSandbox.Service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Wayne Sidney
 * Created on {14/12/2022}
 */


@Controller
@RequestMapping(value="/api/csv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public class CSVController {

    @Autowired
    CSVService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + " !";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/matchresults")
    public ResponseEntity<List<MatchResult>> getAllMatchResults() {
        try {
            List<MatchResult> matchResultList = fileService.getAllMatchResults();

            if (matchResultList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(matchResultList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}