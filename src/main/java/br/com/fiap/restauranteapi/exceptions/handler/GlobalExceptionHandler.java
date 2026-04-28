package br.com.fiap.restauranteapi.exceptions.handler;

import br.com.fiap.restauranteapi.exceptions.InvalidPasswordException;
import br.com.fiap.restauranteapi.exceptions.UsuarioNotFoundException;
import br.com.fiap.restauranteapi.exceptions.dto.ErrorResponseDTO;
import br.com.fiap.restauranteapi.exceptions.dto.MethodArgumentNotValidResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ErrorResponseDTO> handleHandlerMethodValidationException(HandlerMethodValidationException ex, HttpServletRequest pHttpServletRequest) {

        var response = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Parâmetros Inválidos!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/invalid-parameters",
                "Verifique os dados informados na requisição e tente novamente.",
                ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest pHttpServletRequest) {

        var errors = ex.getFieldErrors()
                .stream()
                .map(fieldError -> new MethodArgumentNotValidResponseDTO(
                        fieldError.getField(),
                        fieldError.getDefaultMessage()))
                .toList();

        var response = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de Validação!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/validation-error",
                "A requisição contém dados inválidos!",
                errors
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest pHttpServletRequest) {

        var response = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Requisição Inválida!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/unreadable-message",
                ex.getMostSpecificCause().getMessage(),
                ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    public ResponseEntity<ErrorResponseDTO> handleUnsatisfiedServletRequestParameterException(UnsatisfiedServletRequestParameterException ex, HttpServletRequest pHttpServletRequest) {

        var response = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Parâmetros Inválidos!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/request-parameter-error",
                "Verifique os dados informados na requisição e tente novamente.",
                ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ErrorResponseDTO> handleMissingPathVariableException(MissingPathVariableException ex, HttpServletRequest pHttpServletRequest) {

        var response = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Parâmetro não Informado!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/missing-path-variable",
                "O parâmetro '" + ex.getVariableName() + "' é obrigatório e não foi informado na URL!",
                ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidPasswordException(InvalidPasswordException ex, HttpServletRequest pHttpServletRequest) {

        var response = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Senha Incorreta!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/invalid-password",
                ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUsuarioNotFoundException(UsuarioNotFoundException ex, HttpServletRequest pHttpServletRequest) {

        var response = new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                "Usuário não encontrado!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/usuario-not-found",
                ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleEntityNotFoundException(EntityNotFoundException ex, HttpServletRequest pHttpServletRequest) {

        var response = new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                "Registro não encontrado!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/entity-not-found",
                "Não foi possível localizar um registro com o ID informado!",
                ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateResourceException(DataIntegrityViolationException ex, HttpServletRequest pHttpServletRequest) {

        var response = new ErrorResponseDTO(
                HttpStatus.CONFLICT.value(),
                "Conflito de Dados!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/data-integrity-violation",
                ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleInternalServerErrorException(Exception ex, HttpServletRequest pHttpServletRequest) {

        var response = new ErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro Interno no Servidor!",
                pHttpServletRequest.getRequestURI(),
                "/RestauranteAPI/problems/internal-server-error",
                ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}