# TomEE/DS Micro Project Template

A minimal project template demonstrating Apache TomEE with Apache DeltaSpike integration.
It shows CDI beans, DeltaSpike configuration, JSF pages, and embedded TomEE for development.

## Requirements

- Java 25+
- Maven 3.6.3+

## Build

```bash
mvn clean verify
```

## Run

```bash
mvn clean package tomee:run
```

Then open: http://localhost:8080/demo-service/index.xhtml

### Development mode (hot-reload)

Run `org.os890.cdi.dev.DevStarter` from your IDE.

## Testing

Tests use the [Dynamic CDI Test Bean Addon](https://github.com/os890/dynamic-cdi-test-bean-addon)
with OpenWebBeans SE for CDI container bootstrapping in tests.

## Quality Plugins

| Plugin     | Purpose                          |
|------------|----------------------------------|
| Compiler   | `-Xlint:all`, fail on warnings   |
| Enforcer   | Java 25+, dependency convergence |
| Checkstyle | Code style validation            |
| RAT        | Apache 2.0 license headers       |
| JaCoCo     | Code coverage reporting          |
| Surefire   | Test execution                   |

## License

[Apache License, Version 2.0](LICENSE)
