FROM eclipse-temurin:21
EXPOSE 8080
RUN mkdir /opt/app
ADD build/libs/ApiAcuiOximetro-0.0.1-SNAPSHOT.jar acuioximetro.jar
ENTRYPOINT [ "java", "-jar", "/acuioximetro.jar" ]