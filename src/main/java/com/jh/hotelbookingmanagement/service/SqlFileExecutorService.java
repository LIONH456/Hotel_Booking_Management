package com.jh.hotelbookingmanagement.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SqlFileExecutorService {
    void executeSqlFile(String sqlFilePath) throws IOException;
}
