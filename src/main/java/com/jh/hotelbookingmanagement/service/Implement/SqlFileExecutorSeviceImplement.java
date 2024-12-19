package com.jh.hotelbookingmanagement.service.Implement;

import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.service.SqlFileExecutorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class SqlFileExecutorSeviceImplement implements SqlFileExecutorService {

    JdbcTemplate jdbcTemplate;
   /**
     * Executes an SQL file.
     *
     * @param sqlFilePath the path to the SQL file to execute.
     */
    @Override
    public void executeSqlFile(String sqlFilePath) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))){
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
            log.info("SQL file executed successfully: {}", sqlFilePath);
        }catch (IOException e) {
            log.error("Error reading SQL file: {}", sqlFilePath, e);
            throw new AppException(ErrorCode.FILE_READ_ERROR);
        } catch (Exception e) {
            log.error("Error executing SQL file: {}", sqlFilePath, e);
            throw new AppException(ErrorCode.SQL_EXECUTION_ERROR);
        }
    }
}

