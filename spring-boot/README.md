# Spring Boot

## Reference
* http://git.oschina.net/didispace/SpringBoot-Learning

## 01 起步 `springboot-getstart`
使用 https://start.spring.io 页面创建一个SpringBoot基本工程。加入控制器和静态页面。

## 02 配置使用 `springboot-multi-config`

配置文件建议使用 application.yml， 测试发现使用 Properties 文件时，当前版本不能读取到中文数据，哪怕使用spring.factories配置 PropertySourceLoader 也不行。

### 使用YML格式配置文件

### 使用ConfigurationProperties注解创建自定义配置

```java
@Component
@ConfigurationProperties(prefix = "foo")
@Getter
@Setter
@ToString
public class FooProperties {
    private boolean enabled;
    private int counter;
    private InetAddress remoteAddress;
    private final Security security = new Security();

    @Getter
    @Setter
    @ToString
    public static class Security {
        private String name;
        private String password;
        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
    }
}
```
搭配配置处理器依赖，自动检查配置属性是否正确，利于开发与配置：
```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-configuration-processor</artifactId>
        <optional>true</optional>
    </dependency>
```

### 在配置文件中可使用表达式 ${random.int}

### 使用 Profile
```yaml
spring:
    profiles:
        active: default
```