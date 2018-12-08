package br.com.loki.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// CRIA A ANNOTATION PUBLIC, PARA MÉTODOS E 'TIPOS', CONTROLADA PELA VM EM TEMPO DE EXECUÇÃO
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Public {

}
