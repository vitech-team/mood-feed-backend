FROM openjdk:11.0.8-jdk-slim
ENV PORT 8080
EXPOSE 8080
COPY build/libs/*.jar /opt/app.jar

WORKDIR application

RUN java -Djarmode=layertools -jar /opt/app.jar extract

RUN pwd

RUN ls -l

COPY dependencies/ ./
COPY snapshot-dependencies/ ./
COPY resources/ ./
COPY application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]