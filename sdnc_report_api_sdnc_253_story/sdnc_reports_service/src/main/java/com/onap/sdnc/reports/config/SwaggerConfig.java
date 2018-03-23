package com.onap.sdnc.reports.config;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonIgnore;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableJpaRepositories("com.onap.sdnc.reports.repository")
@EntityScan("com.onap.sdnc.reports.*")
@EnableSwagger2
//@Profile("!test")
public class SwaggerConfig {
	
	 @Bean
	  public Docket newsApi() {
	      return new Docket(DocumentationType.SWAGGER_2)
	              .groupName("sdncreport")
	              .apiInfo(apiInfo())
	              .select()              
	              .paths(regex("/sdnc/report/.*"))
	             // .paths(PathSelectors.any())    
	              .build()
	              .directModelSubstitute(XMLGregorianCalendar.class, MixIn.class);
	  }
	  
	  public static interface MixIn {
	      @JsonIgnore
	      public void setYear(int year);
	  }
	  
	  /**
	   * 
	   * @return
	   */
	  private ApiInfo apiInfo() {
	      return new ApiInfoBuilder()
	              .title("SDNC Report Service REST APIs")
	              .description("SDNC Report Microservice REST APIs")
	              .termsOfServiceUrl("http://....")
	              .contact("TechMahindra")
	              .license("TechMahindra Licensed")
	              .licenseUrl("https://techmahindra.com")
	              .version("2.0")
	              .build();
	  }

}
