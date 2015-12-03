package com.pickle.config;

import com.mangofactory.swagger.authorization.AuthorizationContext;
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.*;
import com.mangofactory.swagger.models.dto.builder.OAuthBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger
public class SwaggerConfig {

    @Value("${api.host}")
    private String HOST;

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                //This info will be used in Swagger. See realisation of ApiInfo for more details.
                .swaggerGroup("sample")
                .apiInfo(new ApiInfo(
                        "Pickle REST API",
                        "Pickle REST API based on the swagger 1.2 spec",
                        "http://en.wikipedia.org/wiki/Terms_of_service",
                        "pickandrecycle@gmail.com",
                        "Apache 2.0",
                        "http://www.apache.org/licenses/LICENSE-2.0.html"
                ))
                        //Here we disable auto generating of responses for REST-endpoints
                .useDefaultResponseMessages(false)
                        //Here we specify URI patterns which will be included in Swagger docs. Use regex for this purpose.
                .includePatterns(
                        "/trash.*",
                        "/account.*",
                        "/article.*",
                        "/notification.*",
                        "/trashnotification"
                )
                .authorizationTypes(authorizationTypes())
                .authorizationContext(authorizationContext())
                .genericModelSubstitutes(ResponseEntity.class);
    }

    private List<AuthorizationType> authorizationTypes() {
        ArrayList<AuthorizationType> authorizationTypes = new ArrayList<AuthorizationType>();

        List<AuthorizationScope> authorizationScopeList = new ArrayList();
        authorizationScopeList.add(new AuthorizationScope("TRUST", "access all"));

        List<GrantType> grantTypes = new ArrayList();

        LoginEndpoint loginEndpoint = new LoginEndpoint(HOST + "/oauth/authorize");
        grantTypes.add(new ImplicitGrant(loginEndpoint, "access_token"));

        TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint(HOST + "/sample/oauth/requestToken", "client_id", "client_secret");
        TokenEndpoint tokenEndpoint = new TokenEndpoint(HOST + "/sample/oauth/token", "auth_code");

        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint);
        grantTypes.add(authorizationCodeGrant);

        OAuth oAuth = new OAuthBuilder()
                .scopes(authorizationScopeList)
                .grantTypes(grantTypes)
                .build();

        authorizationTypes.add(oAuth);
        return authorizationTypes;
    }

    public AuthorizationContext authorizationContext() {
        List<Authorization> authorizations = new ArrayList();

        AuthorizationScope authorizationScope = new AuthorizationScope("TRUST", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        authorizations.add(new Authorization("oauth2", authorizationScopes));
        AuthorizationContext authorizationContext =
                new AuthorizationContext.AuthorizationContextBuilder(authorizations).build();
        return authorizationContext;
    }

}
