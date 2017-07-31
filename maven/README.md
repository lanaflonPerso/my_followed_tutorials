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

### 依赖打入Jar包及主函数设置插件

#### 插件配置
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-assembly-plugin</artifactId>
    <version>3.0.0</version>
    <configuration>
        <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
        <archive>
            <manifest>
                <mainClass>com.wefine.app.Main</mainClass>
            </manifest>
        </archive>
    </configuration>
    <executions>
        <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals>
                <goal>single</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
#### 预定义描述符
1. jar-with-dependencies
> Allow us to generate a jar package with all the dependencies defined in pom.xml file inside of it. This is useful when we plan to deliver an auto-executable jar.
2. bin 
> Use this predefined descriptor in order to create a binary distribution of your package.
3. src
> Use this predefined descriptor in order to distribute your source code. The output package will have the src folder content inside it.
4. project 
> Use this predefined descriptor in order to distribute your entire project minus the target folder content
