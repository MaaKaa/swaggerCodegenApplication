package pl.maakaa.swaggerCodegen.swagger;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration class for Swagger.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket produceApi() {
        String groupName = "prod";
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .select()
                .apis(createApis())
                .paths(createPaths())
                .build()
                .groupName(groupName);
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder()
                .title("Albums API")
                .build();
    }

    private Predicate<RequestHandler> createApis() {
        return RequestHandlerSelectors.basePackage("pl.maakaa.swaggerCodegen");
    }

    private Predicate<String> createPaths() {
        return Predicates.and(PathSelectors.regex("/.*"));
    }
}
