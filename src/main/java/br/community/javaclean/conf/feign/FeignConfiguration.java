package br.community.javaclean.conf.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "br.community.javaclean.gateways.feign")
public class FeignConfiguration {}
