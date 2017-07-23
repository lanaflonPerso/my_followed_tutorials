## Maven 常用插件使用

### 多模块版本号统一更新插件
#### 插件配置
```xml
<plugin>
    <!-- mvn -N versions:update-child-modules -->
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>versions-maven-plugin</artifactId>
    <version>2.4</version>
</plugin>
```

#### 使用说明
1. 修改主父模块中的版本号；
2. 执行 `mvn -N versions:update-child-modules ` 统一更新子模块；
3. 保存修改 `git add -A .; git commit -m "update versions"`；
4. 完成。
