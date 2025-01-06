FROM maven:3-amazoncorretto-21

COPY ./ ./

RUN mvn clean package -Dmaven.test.skip

CMD ["java", "-jar", "target/test-web-atrio-0.0.1-SNAPSHOT.jar"]