package scalerlearningapi.productapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import scalerlearningapi.productapi.DTO.ErrorResponseDto;
import scalerlearningapi.productapi.Exceptions.NotFoundException;

@ControllerAdvice
public class ExceptionsControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
   public ResponseEntity<ErrorResponseDto> handleNotFoundException(Exception exception){
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
