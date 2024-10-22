# Spring Framework Configuration Approaches

## 1. XML-Based Configuration

The traditional and most classic approach to configuring Spring applications.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Bean Definition -->
    <bean id="greetingService" 
          class="com.example.GreetingServiceImpl">
        <property name="greeting" value="Hello!" />
    </bean>

    <!-- Constructor Injection -->
    <bean id="userService" 
          class="com.example.UserServiceImpl">
        <constructor-arg ref="greetingService" />
    </bean>
</beans>
```

### Advantages:
- Clear separation of configuration from code
- No need to recompile when changing configuration
- Good for legacy applications
- Easy to understand the overall application structure

### Disadvantages:
- Verbose
- No compile-time type checking
- Can become hard to maintain for large applications

## 2. Annotation-Based Configuration

Using annotations to configure Spring components, introduced in Spring 2.5.

### Component Scanning
```xml
<!-- Enable component scanning in XML -->
<context:component-scan base-package="com.example" />
```

### Common Annotations
```java
// Mark class as Spring component
@Component
public class GreetingServiceImpl implements GreetingService {
    private String greeting;
    
    // Inject dependency
    @Autowired
    public void setGreetingRepository(GreetingRepository repository) {
        this.repository = repository;
    }
}

// Specialized component annotations
@Controller    // For MVC controllers
@Service      // For service layer
@Repository   // For DAO layer
public class UserController {
    // Class implementation
}

// Specify qualifiers for disambiguation
@Autowired
@Qualifier("mainGreetingService")
private GreetingService greetingService;
```

### Advantages:
- Less verbose than XML
- Configuration is closer to code
- Better refactoring support
- Compile-time checking

### Disadvantages:
- Configuration is scattered across multiple classes
- Requires recompilation when changing configuration

## 3. Java-Based Configuration

Introduced in Spring 3.0, provides type-safe configuration using Java classes.

```java
@Configuration
public class AppConfig {
    
    @Bean
    public GreetingService greetingService() {
        GreetingServiceImpl service = new GreetingServiceImpl();
        service.setGreeting("Hello!");
        return service;
    }
    
    @Bean
    public UserService userService(GreetingService greetingService) {
        return new UserServiceImpl(greetingService);
    }
}

// Using the configuration
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        UserService service = context.getBean(UserService.class);
    }
}
```

### Advantages:
- Type-safe configuration
- Better refactoring support
- IDE support for code completion
- Good for microservices and smaller applications

### Disadvantages:
- Requires recompilation for configuration changes
- Can be verbose for large configurations

## 4. Groovy-Based Configuration

Available since Spring 4.0, allows configuration using Groovy DSL.

```groovy
beans {
    greetingService(GreetingServiceImpl) {
        greeting = "Hello!"
    }
    
    userService(UserServiceImpl, ref('greetingService'))
}
```

### Advantages:
- More concise than XML
- More flexible than Java configuration
- No compilation needed

### Disadvantages:
- Need to know Groovy
- Less IDE support
- Less common in practice

## 5. Hybrid Approaches

You can mix different configuration styles:

```java
@Configuration
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
```

### Best Practices for Choosing Configuration Style:

1. New Projects:
    - Use annotation-based configuration with Java configuration for framework setup
    - Prefer `@Component` scanning for application components
    - Use Java configuration for complex bean setup

2. Legacy Projects:
    - Keep existing XML configuration if working well
    - Gradually migrate to annotation/Java config for new components
    - Use hybrid approach during transition

3. Microservices:
    - Prefer Java configuration
    - Use annotation-based configuration for components
    - Minimize external configuration files

4. Large Enterprise Applications:
    - Consider mixing approaches based on module needs
    - Use XML for integration points
    - Use annotations for application components
    - Use Java configuration for complex setup