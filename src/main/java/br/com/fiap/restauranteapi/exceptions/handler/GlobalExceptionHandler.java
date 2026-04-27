package br.com.fiap.restauranteapi.exceptions.handler;

import br.com.fiap.restauranteapi.exceptions.InvalidPasswordException;
import br.com.fiap.restauranteapi.exceptions.UsuarioNotFoundException;
import br.com.fiap.restauranteapi.exceptions.dto.MethodArgumentNotValidResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ProblemDetail handleHandlerMethodValidationException(HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Parâmetros Inválidos!");
        problemDetail.setDetail("Verifique os dados informados na requisição e tente novamente.");
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Erro de Validação!");
        problemDetail.setDetail("A requisição contém dados inválidos.");
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        var errors = ex.getFieldErrors()
                .stream()
                .map(fieldError -> new MethodArgumentNotValidResponseDTO(
                        fieldError.getField(),
                        fieldError.getDefaultMessage()))
                .toList();

        problemDetail.setProperty("errors", errors);

        return problemDetail;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Requisição Inválida!");
        problemDetail.setDetail(ex.getMostSpecificCause().getMessage());
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        return problemDetail;
    }

    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    public ProblemDetail handleUnsatisfiedServletRequestParameterException(HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Parâmetros Inválidos!");
        problemDetail.setDetail("Verifique os dados informados na requisição e tenta novamente.");
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        return problemDetail;
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ProblemDetail handleMissingPathVariableException(MissingPathVariableException ex, HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Parâmetro não informado!");
        problemDetail.setDetail("O parâmetro '" + ex.getVariableName() + "' não foi informado na requisição!");
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        return problemDetail;
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ProblemDetail handleInvalidPasswordException(InvalidPasswordException ex, HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Senha Incorreta!");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        return problemDetail;
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ProblemDetail handleUsuarioNotFoundException(UsuarioNotFoundException ex, HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("Usuário não encontrado!");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        return problemDetail;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ProblemDetail handleEntityNotFoundException(HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("Registro não encontrado!");
        problemDetail.setDetail("Não foi possível localizar um registro com o ID informado!");
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        return problemDetail;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDuplicateResourceException(DataIntegrityViolationException ex, HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        problemDetail.setTitle("Conflito de Dados!");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleInternalServerErrorException(HttpServletRequest pHttpServletRequest) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        problemDetail.setTitle(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        problemDetail.setDetail("Ocorreu um erro interno no servidor! Por favor, tente novamente.");
        problemDetail.setInstance(URI.create(pHttpServletRequest.getRequestURI()));

        return problemDetail;
    }
}