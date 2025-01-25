package com.jh.hotelbookingmanagement.exception;

import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Getter;

import java.util.Map;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1004, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    INVALID_STATUS(1009, "Booking Status can't be null！", HttpStatus.BAD_REQUEST),
    BOOKING_NOT_FOUND(1010, "There is no any booking yet!", HttpStatus.NOT_FOUND),
    BOOKING_NOT_FOUND_BY_USER(1011, "You have not make any booking yet!:(", HttpStatus.NOT_FOUND),
    ROOM_NOT_FOUND(1012, "No rooms found", HttpStatus.NOT_FOUND),
    BRANCH_NOT_FOUND(1013, "No branch found", HttpStatus.NOT_FOUND),
    BOOKING_METHOD_NOT_FOUND(1014, "No booking method found", HttpStatus.NOT_FOUND),
    DUPLICATED_KEY(1015, "There is a {attribute} using the same name.", HttpStatus.BAD_REQUEST),
    ROOM_ITEM_NOT_FOUND(1015, "Item not Found", HttpStatus.NOT_FOUND),
    SERVICE_NOT_FOUND(1016, "Services not Found", HttpStatus.NOT_FOUND),
    INSUFFICIENT_STOCK(1017, "Not Enough Stock", HttpStatus.BAD_REQUEST),
    INSUFFICIENT_QUANTITY(1018, "Quantity must be at least 1", HttpStatus.BAD_REQUEST),
    INVALID_DATE_RANGE(1019, "check out date must after check in date", HttpStatus.BAD_REQUEST),
    // Picture-specific error codes
    FILE_NOT_SUPPORTED(2001, "File type is not supported", HttpStatus.BAD_REQUEST),
    FILE_IS_EMPTY(2002, "File cannot be empty", HttpStatus.BAD_REQUEST),
    FILE_SIZE_EXCEEDED(2003, "File size exceeds the maximum limit", HttpStatus.BAD_REQUEST),
    FILE_UPLOAD_FAILED(2004, "Failed to upload the file", HttpStatus.INTERNAL_SERVER_ERROR),
    FILE_PATH_INVALID(2005, "Invalid file path", HttpStatus.BAD_REQUEST),
    FILE_SAVE_FAILED(2006, "Failed to save the file", HttpStatus.INTERNAL_SERVER_ERROR),
    FILE_DELETE_FAILED(2007, "Failed to delete the file", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_PICTURE_CATEGORY(2008, "Invalid Picture Category", HttpStatus.BAD_REQUEST),
    // Sql File
    FILE_READ_ERROR(1101, "Error reading SQL file", HttpStatus.BAD_REQUEST),
    SQL_EXECUTION_ERROR(1102, "Error executing SQL file", HttpStatus.INTERNAL_SERVER_ERROR),

    // Cursor
    PAYMENT_TYPE_NOT_FOUND(1020, "Payment type not found", HttpStatus.NOT_FOUND),
    PAYMENT_STATUS_NOT_FOUND(1021, "Payment status not found", HttpStatus.NOT_FOUND),
    PAYMENT_NOT_FOUND(1022, "Payment not found", HttpStatus.NOT_FOUND),
    ROOM_TYPE_NOT_FOUND(1023, "Room type not found", HttpStatus.NOT_FOUND),

    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

    public String getFormattedMessage(Map<String, Object> attributes) {
        String formattedMessage = this.message;
        if (attributes != null) {
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                formattedMessage = formattedMessage.replace("{" + entry.getKey() + "}", String.valueOf(entry.getValue()));
            }
        }
        return formattedMessage;
    }

}
