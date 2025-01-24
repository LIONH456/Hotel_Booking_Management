package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.service.SqlFileExecutorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class SqlFileExecutorSeviceImplement implements SqlFileExecutorService {
    @NonFinal
    @Value("${sql.path}")
    String STORE_PATH;


    JdbcTemplate jdbcTemplate;
   /**
     * Executes an SQL file.
     *
     * @param fileName the SQL file Name to execute.
     */
    @Override
    public void executeSqlFile(String sqlFileName) throws IOException {
        String fullpath = STORE_PATH + sqlFileName;
        try(BufferedReader reader = new BufferedReader(new FileReader(fullpath))){
            String line;
            StringBuilder sql = new StringBuilder();



            while ((line = reader.readLine()) != null) {
                if(line.startsWith("--"))
                    continue;
                sql.append(line);
                if (line.endsWith(";")) { // Execute one statement at a time
                    jdbcTemplate.execute(sql.toString());
                    sql.setLength(0); // Clear the buffer
                }
            }
            log.info("SQL file executed successfully: {}", fullpath);
        }catch (IOException e) {
            log.error("Error reading SQL file: {}", fullpath, e);
            throw new AppException(ErrorCode.FILE_READ_ERROR);
        } catch (Exception e) {
            log.error("Error executing SQL file: {}", fullpath, e);
            throw new AppException(ErrorCode.SQL_EXECUTION_ERROR);
        }
    }
}

