Spring Security Notes: 
My references
1> Create spring mvc project
2> Add manual dependencies required.
3> Create Dispatcherintializer class andcontroller and try one or two get mappers
examples created here DSPInitializer and SecController and created hi by get mapper.
4> Now build and run app and go to browser see if you're able to access hi and bye mapper.

Hope it is working :D 

next step is to add security dependecies.
5> add the above dependencies.
    <dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-web</artifactId>
    <version>${spring.version}</version>
    </dependency>
    <dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-config</artifactId>
    <version>${spring.version}</version>
    </dependency>

6> Now  you know entry point for app or front end controller is dispatcher servlet 
but when you add security you want to add secuirty u need to hit  **DelegatingFilterProxy**
consider this as entry point of security set up. 
so in this porject we created securityinit class whihc extends AbstractSecurityWebApplicationInitializer.
7> Now after entry point delegate proxy next point of entry is to go through "**springSecurityFilterChain**"
which check various security in different levels.
For that we have created securityappconfig class and annotated @EnableWebSecurity
now if we run you ll see login page. if we try to login it will through error.
We will see how to add user and password in next project SpringmvcSecurity02